package com.hj.pas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.pas.mapper.CompanyDimensionMapper;
import com.hj.pas.model.CompanyDimension;
import com.hj.pas.service.ICompanyDimensionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 公司考核维度表 服务实现类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Service
public class CompanyDimensionServiceImpl extends ServiceImpl<CompanyDimensionMapper, CompanyDimension> implements ICompanyDimensionService {

    @Override
    public List<CompanyDimension> getListByQuery(CompanyDimension para) {
        if (para != null) {
            QueryWrapper<CompanyDimension> query = new QueryWrapper<>(para);
            return this.list(query);
        }
        return null;
    }

    @Override
    public CompanyDimension getByPara(String companyId, String dimensionId, String cycle) {
        CompanyDimension companyDimension = new CompanyDimension();
        companyDimension.setCompanyId(companyId);
        companyDimension.setDimensionId(dimensionId);
        companyDimension.setCycle(cycle);
        QueryWrapper<CompanyDimension> queryWrapper = new QueryWrapper<>(companyDimension);
        return getOne(queryWrapper);
    }
}
