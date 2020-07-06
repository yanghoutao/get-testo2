package com.hj.pas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.pas.model.CompanyKpi;
import com.hj.pas.vo.CompanyKpiResultVO;
import com.hj.pas.vo.CompanyScoresVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 考核维度表 服务类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface ICompanyKpiService extends IService<CompanyKpi> {

    Map<String, List<CompanyScoresVO>> getCompanyList(String cycle);

    List<CompanyKpiResultVO> getCompanyKpiList(String companyId, String cycle);
}
