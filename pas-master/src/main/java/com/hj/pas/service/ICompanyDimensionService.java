package com.hj.pas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.pas.model.CompanyDimension;

import java.util.List;

/**
 * <p>
 * 公司考核维度表 服务类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface ICompanyDimensionService extends IService<CompanyDimension> {

    public List<CompanyDimension> getListByQuery(CompanyDimension para);

    CompanyDimension getByPara(String companyId, String dimensionId, String cycle);
}
