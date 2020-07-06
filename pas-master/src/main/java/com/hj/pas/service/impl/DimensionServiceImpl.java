package com.hj.pas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.pas.mapper.DimensionMapper;
import com.hj.pas.model.Dimension;
import com.hj.pas.service.IDimensionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考核维度表 服务实现类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Service
public class DimensionServiceImpl extends ServiceImpl<DimensionMapper, Dimension> implements IDimensionService {

    @Override
    public Dimension getDimensionByName(String dimensionName) {
        Dimension para = new Dimension();
        para.setDimensionName(dimensionName);
        QueryWrapper<Dimension> queryWrapper = new QueryWrapper<>(para);
        return getOne(queryWrapper);
    }
}
