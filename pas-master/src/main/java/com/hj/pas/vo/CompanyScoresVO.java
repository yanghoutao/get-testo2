package com.hj.pas.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassNameCompanyScoresVO @Author QiXueQing @Date 2020/6/28 @Version V1.0
 */
@Getter
@Setter
@ToString
public class CompanyScoresVO {
  @ApiModelProperty(value = "公司ID")
  private String companyId;
  @ApiModelProperty(value = "公司名称")
  private String companyName;
  @ApiModelProperty(value = "是否总部")
  private String hfGroup;
  @ApiModelProperty(value = "待打分数量")
  private String waitCount;
}
