package com.hj.pas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.pas.model.Dimension;

/**
 * <p>
 * 考核维度表 服务类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface IDimensionService extends IService<Dimension> {

    Dimension getDimensionByName(String dimensionName);
}
