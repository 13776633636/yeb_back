package com.xxxx.server.controller;

import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.AdminVO;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IAdminService;
import com.xxxx.server.utils.AdminUtils;
import com.xxxx.server.utils.AssertUtil;
import com.xxxx.server.utils.QiniuCloudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * 个人中心
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RequestMapping("/admin")
@RestController
public class AdminInfoController {

    //注入adminserver
    @Autowired
    private IAdminService adminService;

    /*
     * 改密码
     * */
    @PutMapping("/pass")
    public RespBean updatePass(@RequestBody AdminVO adminVO) {
        Integer row = adminService.updatePass(adminVO);
        if(row > 0){
            return RespBean.success("修改成功");
        }

        return RespBean.error("修改失败");
    }


    /*
     * 更新用户信息，手机号码，电话号码等
     * */
    @PutMapping("/info")
    public RespBean updateAdmin(@RequestBody Admin admin) {
        int length = admin.getPhone().length();
        AssertUtil.isTrue(length > 11, "手机号码长度不合法", 500);

        if (adminService.updateById(admin)) {
            return RespBean.success("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @PostMapping("/userface")
    public RespBean userface(@RequestParam(value = "file") MultipartFile image, HttpServletRequest request) {
        AssertUtil.isTrue(image.isEmpty(), "文件为空，请重新上传", 400);
        try {
            byte[] bytes = image.getBytes();
            String imageName = UUID.randomUUID().toString();

            try {
                //使用base64方式上传到七牛云
                String userFace = QiniuCloudUtil.put64image(bytes, imageName);
                //url设置进数据库
                //当前是登录状态
                //获取当前用户信息——admin id; update!
                Admin admin = AdminUtils.getCurrentAdmin();
                int row = adminService.updateMyPic(admin.getId(), userFace);
                if (row > 0) {
                    return RespBean.success("成功");
                }
                return RespBean.error("失败");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return RespBean.success("成功");
        } catch (IOException e) {
            return RespBean.error("失败");
        }


        //return RespBean.success("");
    }
}