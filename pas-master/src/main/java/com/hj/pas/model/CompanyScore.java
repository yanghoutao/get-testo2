package com.hj.pas.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_company_score")
@ApiModel(value = "CompanyScore对象", description = "")
public class CompanyScore extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公司id")
    @TableField("company_id")
    private String companyId;

    @ApiModelProperty(value = "打分周期")
    @TableField("cycle")
    private String cycle;

    @ApiModelProperty(value = "打分人")
    @TableField("score_person")
    private String scorePerson;

    @ApiModelProperty(value = "总分")
    @TableField("scores")
    private BigDecimal scores;


}
