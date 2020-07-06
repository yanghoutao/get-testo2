package com.hj.pas.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameCompanyKpiResultVO
 * @Author QiXueQing
 * @Date 2020/6/29
 * @Version V1.0
 **/
@Getter
@Setter
@ToString
public class CompanyKpiResultVO {
    private String companyDimensionId;
    private String companyId;
    private String dimensionId;
    private String dimensionName;
    private String cycle;
    private BigDecimal weight;
    private BigDecimal minValue;
    private BigDecimal maxValue;
    private Integer companyDimensionSort;
    List<CompanyKpiVO> list = new ArrayList<>();
}
