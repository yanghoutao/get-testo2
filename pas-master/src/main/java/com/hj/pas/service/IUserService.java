package com.hj.pas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.pas.model.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface IUserService extends IService<User> {

    User getUserByName(String userName);
}
