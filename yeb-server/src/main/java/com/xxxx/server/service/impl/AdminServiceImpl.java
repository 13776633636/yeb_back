package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.config.security.component.JwtTokenUtil;
import com.xxxx.server.mapper.AdminMapper;
import com.xxxx.server.mapper.AdminRoleMapper;
import com.xxxx.server.mapper.RoleMapper;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.AdminVO;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;
import com.xxxx.server.service.IAdminService;
import com.xxxx.server.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhoubin
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Value("${jwt.tokenHead}")
	private String tokenHead;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private AdminRoleMapper adminRoleMapper;


	/**
	 * 登录之后返回token
	 * @param username
	 * @param password
	 * @param code
	 * @param request
	 * @return
	 */
	@Override
	public RespBean login(String username, String password, String code, HttpServletRequest request) {
		String captcha = (String) request.getSession().getAttribute("captcha");
		if (StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
			return RespBean.error("验证码输入错误，请重新输入！");
		}
		//登录
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if (null==userDetails||!passwordEncoder.matches(password,userDetails.getPassword())){
			return RespBean.error("用户名或密码不正确");
		}
		if (!userDetails.isEnabled()){
			return RespBean.error("账号被禁用，请联系管理员！");
		}
		//更新security登录用户对象
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
				,null,userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		//生成token
		String token = jwtTokenUtil.generateToken(userDetails);
		Map<String,String> tokenMap = new HashMap<>();
		tokenMap.put("token",token);
		tokenMap.put("tokenHead",tokenHead);
		return RespBean.success("登录成功",tokenMap);
	}

	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	@Override
	public Admin getAdminByUserName(String username) {
		return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",username));
	}

	/**
	 * 根据用户id查询角色列表
	 * @param adminId
	 * @return
	 */
	@Override
	public List<Role> getRoles(Integer adminId) {
		return roleMapper.getRoles(adminId);
	}

    @Override
    public int updateMyPic(Integer id, String userFace) {
		int row = adminMapper.updateMyPic(id,userFace);
		return row;
    }

    @Override
    public Integer updatePass(AdminVO adminVO) {
		Integer adminId = adminVO.getAdminId();
		//数据库中的密码
		String oldpass = adminMapper.getPass(adminId);
		//boolean matches = passwordEncoder.matches(adminVO.getOldPass(), oldpass);

		AssertUtil.isTrue( !passwordEncoder.matches(adminVO.getOldPass(),oldpass),"密码不正确",400);
		AssertUtil.isTrue( passwordEncoder.matches(adminVO.getCheckPass(),oldpass),"新密码与旧密码相同",400);


		//将新密码更新到数据库
		String encode = passwordEncoder.encode(adminVO.getCheckPass());
		int rows = adminMapper.updatepass(adminId,encode);
		return rows;
    }

    @Override
    public List<Admin> listAll(String keywords) {
        List<Admin> list = adminMapper.listAll(keywords);
		
		return list;
    }



}