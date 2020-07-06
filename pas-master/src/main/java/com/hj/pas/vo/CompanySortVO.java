package com.hj.pas.vo;

import io.swagger.annotations.ApiModelProperty;
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
public class CompanySortVO {

  @ApiModelProperty(value = "公司名称")
  private String companyName;
  @ApiModelProperty(value = "分数")
  private BigDecimal scores;
}
