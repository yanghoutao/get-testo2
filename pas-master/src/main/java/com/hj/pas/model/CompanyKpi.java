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
 * 考核维度表
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_company_kpi")
@ApiModel(value="CompanyKpi对象", description="考核维度表")
public class CompanyKpi extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "维度id")
    @TableField("company_dimension_id")
    private String companyDimensionId;

    @ApiModelProperty(value = "kpi编号")
    @TableField("kpi_no")
    private String kpiNo;

    @ApiModelProperty(value = "考核指标")
    @TableField("kpi")
    private String kpi;

    @ApiModelProperty(value = "指标定义")
    @TableField("kpi_define")
    private String kpiDefine;

    @ApiModelProperty(value = "前年数据")
    @TableField("before_last_year")
    private String beforeLastYear;

    @ApiModelProperty(value = "上年数据")
    @TableField("last_year")
    private String lastYear;

    @ApiModelProperty(value = "及格")
    @TableField("pass")
    private String pass;

    @ApiModelProperty(value = "满分")
    @TableField("full_mark")
    private String fullMark;

    @ApiModelProperty(value = "挑战")
    @TableField("challenge")
    private String challenge;

    @ApiModelProperty(value = "权重")
    @TableField("weight")
    private BigDecimal weight;

    @ApiModelProperty(value = "最小值")
    @TableField("min_value")
    private BigDecimal minValue;

    @ApiModelProperty(value = "最大值")
    @TableField("max_value")
    private BigDecimal maxValue;

    @ApiModelProperty(value = "完成情况验收标准")
    @TableField("complete_standard")
    private String completeStandard;

    @ApiModelProperty(value = "实际值")
    @TableField("real_value")
    private String realValue;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "评分方法")
    @TableField("score_method")
    private String scoreMethod;

    @ApiModelProperty(value = "数据来源")
    @TableField("source")
    private String source;

    @ApiModelProperty(value = "评估人")
    @TableField("appraiser")
    private String appraiser;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "是否需要打分")
    @TableField("need_score")
    private String needScore;

    @ApiModelProperty(value = "评分方式")
    @TableField("score_type")
    private Integer scoreType;


}
