package com.dxz.web.system.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author duxiaozui(董文宇)
 * 日期 2023/14/21(星期五) 11:14
 * request：编写接收分页请求参数类
 */

@Data
public class BaseParam {
    private Integer currentPage = 1;//当前页
    private Integer pageSize = 5;//每页参数展示大小

    /**
     * @author duxiaozui(董文宇)
     * 日期 2023/14/21(星期五) 15:14
     * request：
     */
    @Data
    public static class LoginParam {
        @NotBlank(message = "用户名不能为空")
        private String username;
        @NotNull(message = "身份类型不能为空")
        private Integer userType;
        @NotBlank(message = "密码不能为空")
        private String password;
        @NotBlank(message = "验证码id不能为空")
        private String captchaId;
        @NotBlank(message = "验证码不能为空")
        private String captchaCode;
    }
}
