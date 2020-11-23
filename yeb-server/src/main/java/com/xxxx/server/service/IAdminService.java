package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.AdminVO;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 */
public interface IAdminService extends IService<Admin> {
	/**
	 * 登录之后返回token
	 * @param username
	 * @param password
	 * @param code
	 * @param request
	 * @return
	 */
	RespBean login(String username, String password, String code, HttpServletRequest request);

	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	Admin getAdminByUserName(String username);

	/**
	 * 根据用户id查询角色列表
	 * @param adminId
	 * @return
	 */
	List<Role> getRoles(Integer adminId);

	int updateMyPic(Integer id, String userFace);

	Integer updatePass(AdminVO adminVO);

    List<Admin> listAll(String keywords);


}