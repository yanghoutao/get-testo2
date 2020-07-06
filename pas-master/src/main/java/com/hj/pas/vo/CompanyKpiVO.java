package com.hj.pas.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ClassNameCompanyScoresVO @Author QiXueQing @Date 2020/6/28 @Version V1.0
 */
@Getter
@Setter
@ToString
public class CompanyKpiVO {

  private String dimensionId;
  private String dimensionName;
  private BigDecimal dimensionWeight;
  private BigDecimal dimensionMinValue;
  private BigDecimal dimensionMaxValue;
  private Integer dimensionSort;
  private String kpiId;
  private String companyDimensionId;
  private String kpiNo;
  private String kpi;
  private String kpiDefine;
  private String beforeLastYear;
  private String lastYear;
  private String pass;
  private String fullMark;
  private String challenge;
  private BigDecimal kpiWeight;
  private BigDecimal kpiMinValue;
  private BigDecimal kpiMaxValue;
  private String completeStandard;
  private String realValue;
  private Integer kpiSort;
  private String scoreMethod;
  private String source;
  private String appraiser;
  private String remark;
  private String scoreId;
  private BigDecimal scores;
  private String needScore;
  private String companyScoreId;
  private Integer dimensionScoreType;
  private Integer kpiScoreType;
}
