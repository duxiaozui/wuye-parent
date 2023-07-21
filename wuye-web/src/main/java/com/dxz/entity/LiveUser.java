package com.dxz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * <p>
 * 业主表
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-21
 */
@Getter
@Setter
@TableName("live_user")
@ApiModel(value = "LiveUser对象", description = "业主表")
public class LiveUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("姓名")
    private String trueName;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("性别 0：女 1：男")
    private Integer sex;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("账号是否可用；0不可用，1可用")
    private boolean enabled;

    @ApiModelProperty("账户是否锁定;0锁定，1未锁定")
    private boolean accountNonLocked;

    @ApiModelProperty("账号是否过期;0过期，1未过期")
    private boolean accountNonExpired;

    @ApiModelProperty("密码是否过期;0过期，1未过期")
    private boolean credentialsNonExpired;

    @ApiModelProperty("假删字段；0删除，1未删除")
    private boolean deleted;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
