package com.hj.pas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.pas.mapper.CompanyMapper;
import com.hj.pas.model.Company;
import com.hj.pas.model.CompanyDimension;
import com.hj.pas.model.CompanyKpi;
import com.hj.pas.model.Dimension;
import com.hj.pas.service.ICompanyDimensionService;
import com.hj.pas.service.ICompanyKpiService;
import com.hj.pas.service.ICompanyService;
import com.hj.pas.service.IDimensionService;
import com.hj.pas.vo.ImportChildData;
import com.hj.pas.vo.ImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <p>
 * 公司表 服务实现类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {
    @Autowired
    private IDimensionService dimensionService;
    @Autowired
    private ICompanyDimensionService companyDimensionService;
    @Autowired
    private ICompanyKpiService companyKpiService;

    @Value("${cycle}")
    private String cycle;

    @Override
    @Transactional
    public void saveImport(ImportData data) {
        String companyName = data.getCompanyName();
        Company company = getCompanyByName(companyName);
        if (company == null) {//如果查询不到公司就新增
            company = new Company();
            company.setCompanyName(companyName);
            save(company);
        }
        String dimensionName = data.getDimensionName();
        Dimension dimension = dimensionService.getDimensionByName(dimensionName);
        if (dimension == null) {//查询不到维度新增
            dimension = new Dimension();
            dimension.setDimensionName(dimensionName);
            dimensionService.save(dimension);
        }
        CompanyDimension companyDimension =
                companyDimensionService.getByPara(company.getId(), dimension.getId(), cycle);
        if (companyDimension == null) {//查询不到公司维度新增
            companyDimension = new CompanyDimension();
            companyDimension.setDimensionId(dimension.getId());
            companyDimension.setCompanyId(company.getId());
            companyDimension.setCycle(cycle);
            companyDimension.setWeight(new BigDecimal(data.getDimensionWeight()));
            companyDimensionService.save(companyDimension);
        }
        CompanyKpi companyKpi = new CompanyKpi();
        companyKpi.setCompanyDimensionId(companyDimension.getId());
        companyKpi.setKpi(data.getKpi());
        companyKpi.setPass(data.getPass());
        companyKpi.setWeight(new BigDecimal(data.getKpiWeight()));
        companyKpi.setCompleteStandard(data.getCompleteStandard());
        companyKpi.setRealValue(data.getRealValue());
        companyKpi.setScoreMethod(data.getScoreMethod());
        companyKpi.setSort(data.getRowIndex());
        companyKpiService.save(companyKpi);
    }

    @Override
    @Transactional
    public void saveChildImport(ImportChildData data) {
        String companyName = data.getCompanyName();
        Company company = getCompanyByName(companyName);
        if (company == null) {//如果查询不到公司就新增
            company = new Company();
            company.setCompanyName(companyName);
            save(company);
        }
        String dimensionName = data.getDimensionName();
        Dimension dimension = dimensionService.getDimensionByName(dimensionName);
        if (dimension == null) {//查询不到维度新增
            dimension = new Dimension();
            dimension.setDimensionName(dimensionName);
            dimensionService.save(dimension);
        }
        CompanyDimension companyDimension =
                companyDimensionService.getByPara(company.getId(), dimension.getId(), cycle);
        if (companyDimension == null) {//查询不到公司维度新增
            companyDimension = new CompanyDimension();
            companyDimension.setDimensionId(dimension.getId());
            companyDimension.setCompanyId(company.getId());
            companyDimension.setCycle(cycle);
            companyDimension.setWeight(new BigDecimal(data.getDimensionWeight()));
            companyDimensionService.save(companyDimension);
        }
        CompanyKpi companyKpi = new CompanyKpi();
        companyKpi.setCompanyDimensionId(companyDimension.getId());
        companyKpi.setKpi(data.getKpi());
        companyKpi.setKpiDefine(data.getKpiDefine());
        companyKpi.setWeight(new BigDecimal(data.getKpiWeight()));
        companyKpi.setBeforeLastYear(data.getBeforeYear());
        companyKpi.setLastYear(data.getLastYear());
        companyKpi.setPass(data.getPass());
        companyKpi.setFullMark(data.getFullMark());
        companyKpi.setChallenge(data.getChallenge());
        companyKpi.setRealValue(data.getRealValue());
        companyKpi.setScoreMethod(data.getScoreMethod());
        companyKpi.setSource(data.getDataSource());
        companyKpi.setAppraiser(data.getAppraiser());
        companyKpi.setRemark(data.getRemark());
        companyKpi.setSort(data.getRowIndex());
        companyKpiService.save(companyKpi);
    }

    private Company getCompanyByName(String companyName) {
        Company para = new Company();
        para.setCompanyName(companyName);
        QueryWrapper<Company> queryWrapper = new QueryWrapper<>(para);
        return getOne(queryWrapper);
    }
}
