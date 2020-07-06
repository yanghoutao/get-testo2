package com.hj.pas.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.pas.model.CompanyKpi;
import com.hj.pas.vo.CompanyKpiVO;
import com.hj.pas.vo.CompanyScoresVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 考核维度表 Mapper 接口
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface CompanyKpiMapper extends BaseMapper<CompanyKpi> {

    List<CompanyScoresVO> getCompanyList(String cycle);

    List<CompanyKpiVO> getKpiList(@Param("companyId") String companyId, @Param("cycle") String cycle);
}
