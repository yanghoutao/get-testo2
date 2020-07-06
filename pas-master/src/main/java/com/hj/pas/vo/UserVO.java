package com.hj.pas.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserVO {

  private String userCode;

  @ApiModelProperty(value = "登录账户")
  private String userName;

  @ApiModelProperty(value = "真实姓名")
  private String trueName;

  @ApiModelProperty(value = "密码")
  private String password;
}
