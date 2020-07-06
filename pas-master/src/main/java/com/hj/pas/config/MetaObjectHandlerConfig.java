package com.hj.pas.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.hj.pas.utils.UserContext;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

  /*
   * (non-Javadoc)
   *
   * @see com.baomidou.mybatisplus.core.handlers.MetaObjectHandler#insertFill(org.
   * apache.ibatis.reflection.MetaObject) 插入公共字段，如果为非公共字段，需要判空和对象类型
   */
  @Override
  public void insertFill(MetaObject metaObject) {

    // 设置日期
    setFieldValByName("createDate", LocalDateTime.now(), metaObject);
    setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
    setFieldValByName("createBy", UserContext.getUserId(), metaObject);
    setFieldValByName("updateBy", UserContext.getUserId(), metaObject);
  }

  /*
   * (non-Javadoc)
   *
   * @see com.baomidou.mybatisplus.core.handlers.MetaObjectHandler#updateFill(org.
   * apache.ibatis.reflection.MetaObject) 更新公共字段，如果为非公共字段，需要判空和对象类型
   */
  @Override
  public void updateFill(MetaObject metaObject) {
    //		LocalDateTime businessTime = SystemConfig.getBusinessDateTime();
    setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
    setFieldValByName("updateBy", UserContext.getUserId(), metaObject);
  }
}
