package com.hj.pas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.pas.mapper.UserMapper;
import com.hj.pas.model.User;
import com.hj.pas.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getUserByName(String userName) {
        if (StringUtils.isBlank(userName)) {
            return null;
        }
        User user = new User();
        user.setUserName(userName);
        QueryWrapper<User> query = new QueryWrapper<>(user);
        return getOne(query);
    }
}
