package com.hj.pas.controller;

import com.hftk.tools.http.ResultCodeEnum;
import com.hftk.tools.http.ResultGenerator;
import com.hftk.tools.http.ResultMsg;
import com.hftk.tools.util.MD5Util;
import com.hj.pas.config.jwt.JwtIgnore;
import com.hj.pas.config.jwt.Jwtconfig;
import com.hj.pas.model.User;
import com.hj.pas.service.IUserService;
import com.hj.pas.utils.JwtTokenUtil;
import com.hj.pas.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * 管理系统人员表 前端控制器
 *
 * @author qxq
 * @since 2020-04-10
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

  @Autowired private IUserService userService;

  @Autowired private Jwtconfig jwtConfig;

  @JwtIgnore
  @PostMapping("/login")
  @ApiOperation(value = "登录接口", notes = "登录接口")
  public ResultMsg login(@RequestBody UserVO userVO) {
    log.info("登录请求参数 {}", userVO);
    try {
      String userName = userVO.getUserName();
      String password = userVO.getPassword();
      password = MD5Util.md5Encode(password);
      User user = userService.getUserByName(userName);
      if (null != user && user.getPassword().equals(password)) {
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUserName(), jwtConfig);
        return ResultGenerator.genSuccessResult(token);
      } else {
        return ResultGenerator.genSuccessResult(ResultCodeEnum.LOGIN_FAIL);
      }
    } catch (Exception e) {
      log.error("error" + e);
      return ResultGenerator.genSuccessResult(ResultCodeEnum.LOGIN_FAIL);
    }
  }

  @PostMapping("/get")
  @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
  public ResultMsg get(String userId) throws UnsupportedEncodingException {
    User user = userService.getById(userId);
    return ResultGenerator.genSuccessResult(user);
  }

  @PostMapping("/save")
  @ApiOperation(value = "保存用户", notes = "保存用户")
  public ResultMsg save(User user) throws UnsupportedEncodingException {
    user.setPassword(MD5Util.md5Encode(user.getPassword()));
    userService.save(user);
    return ResultGenerator.genSuccessResult(true);
  }
}
