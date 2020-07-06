package com.hj.pas.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hftk.tools.constant.BaseConstant;
import com.hj.pas.constant.CommonConstant;
import com.hj.pas.mapper.CompanyKpiMapper;
import com.hj.pas.model.CompanyDimension;
import com.hj.pas.model.CompanyKpi;
import com.hj.pas.service.ICompanyDimensionService;
import com.hj.pas.service.ICompanyKpiService;
import com.hj.pas.vo.CompanyKpiResultVO;
import com.hj.pas.vo.CompanyKpiVO;
import com.hj.pas.vo.CompanyScoresVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 考核维度表 服务实现类
 *
 * @author qxq
 * @since 2020-06-22
 */
@Service
public class CompanyKpiServiceImpl extends ServiceImpl<CompanyKpiMapper, CompanyKpi>
        implements ICompanyKpiService {
  @Autowired
  private CompanyKpiMapper companyKpiMapper;
  @Autowired
  private ICompanyDimensionService companyDimensionService;

  @Override
  public Map<String, List<CompanyScoresVO>> getCompanyList(String cycle) {
    List<CompanyScoresVO> list = companyKpiMapper.getCompanyList(cycle);
    Map<String, List<CompanyScoresVO>> group =
            list.stream().collect(Collectors.groupingBy(CompanyScoresVO::getHfGroup));
    Map<String, List<CompanyScoresVO>> result = new HashMap<>();
    group.forEach(
            (key, value) -> {
              if (BaseConstant.YES.equals(key)) {
                result.put(CommonConstant.HF_GROUP_NAME, value);
              } else {
                result.put(CommonConstant.HF_GROUP_CHILD_NAME, value);
              }
            });
    return result;
  }

  @Override
  public List<CompanyKpiResultVO> getCompanyKpiList(String companyId, String cycle) {
    List<CompanyKpiVO> list = companyKpiMapper.getKpiList(companyId, cycle);
    Map<String, List<CompanyKpiVO>> map =
            list.stream().collect(Collectors.groupingBy(CompanyKpiVO::getCompanyDimensionId));
    CompanyDimension para = new CompanyDimension();
    para.setCompanyId(companyId);
    para.setCycle(cycle);
    // 获取公司维度列表
    List<CompanyDimension> companyDimensionList = companyDimensionService.getListByQuery(para);
    List<CompanyKpiResultVO> resultList = new ArrayList<>();
    for (CompanyDimension companyDimension : companyDimensionList) {
      // 根据公司维度id从map中取结果值 如果值为空跳过
      List<CompanyKpiVO> kpiList = map.get(companyDimension.getId());
      if (CollectionUtils.isEmpty(kpiList)) {
        continue;
      }
      CompanyKpiResultVO vo = new CompanyKpiResultVO();
      vo.setCompanyId(companyDimension.getCompanyId());
      vo.setCompanyDimensionId(companyDimension.getId());
      vo.setCycle(companyDimension.getCycle());
      vo.setMaxValue(companyDimension.getMaxValue());
      vo.setMinValue(companyDimension.getMinValue());
      vo.setWeight(companyDimension.getWeight());
      vo.setCompanyDimensionSort(companyDimension.getSort());
      vo.setDimensionName(kpiList.get(0).getDimensionName());
      vo.setList(kpiList);
      resultList.add(vo);
    }
    resultList.sort(Comparator.comparing(CompanyKpiResultVO::getCompanyDimensionSort));
    return resultList;
  }
}
