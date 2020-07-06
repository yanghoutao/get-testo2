package com.hj.pas.controller;

import com.hftk.tools.http.ResultCodeEnum;
import com.hftk.tools.http.ResultGenerator;
import com.hftk.tools.http.ResultMsg;
import com.hj.pas.service.ICompanyKpiService;
import com.hj.pas.vo.CompanyKpiResultVO;
import com.hj.pas.vo.CompanyScoresVO;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 考核维度表 前端控制器
 *
 * @author qxq
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/company-kpi")
public class CompanyKpiController {
  @Autowired
  private ICompanyKpiService companyKpiService;

  @PostMapping("/getCompanyList")
  @ApiOperation(value = "获取公司列表", notes = "获取公司列表")
  public ResultMsg getCompanyList(String cycle) {
    Map<String, List<CompanyScoresVO>> companyList = companyKpiService.getCompanyList(cycle);
    return ResultGenerator.genSuccessResult(companyList);
  }

  @PostMapping("/getCompanyKpiList")
  @ApiOperation(value = "获取公司绩效列表", notes = "获取公司绩效列表")
  public ResultMsg getCompanyKpiList(String companyId, String cycle) {
    if (StringUtils.isAnyBlank(companyId, cycle)) {
      return ResultGenerator.genSuccessResult(ResultCodeEnum.PARAMETER_NULL);
    }
    List<CompanyKpiResultVO> resultList = companyKpiService.getCompanyKpiList(companyId, cycle);
    return ResultGenerator.genSuccessResult(resultList);
  }
}
