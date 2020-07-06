package com.hj.pas.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value="User对象", description="用户表")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "IDM编号")
    @TableField("user_code")
    private String userCode;

    @ApiModelProperty(value = "登录账户")
    @TableField("user_name")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(value = "真实姓名")
    @TableField("true_name")
    @NotBlank(message = "姓名不能为空")
    private String trueName;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    @NotBlank(message = "密码不能为空")
    private String password;


}
