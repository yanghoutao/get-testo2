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
 * 公司考核维度表
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_company_dimension")
@ApiModel(value="CompanyDimension对象", description="公司考核维度表")
public class CompanyDimension extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "维度id")
    @TableField("company_id")
    private String companyId;

    @ApiModelProperty(value = "维度id")
    @TableField("dimension_id")
    private String dimensionId;

    @ApiModelProperty(value = "打分周期")
    @TableField("cycle")
    private String cycle;

    @ApiModelProperty(value = "权重")
    @TableField("weight")
    private BigDecimal weight;

    @ApiModelProperty(value = "最小值")
    @TableField("min_value")
    private BigDecimal minValue;

    @ApiModelProperty(value = "最大值")
    @TableField("max_value")
    private BigDecimal maxValue;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "打分方式 1.权重打分 2. 直接计分")
    @TableField("score_type")
    private Integer scoreType;


}
