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
 * 打分明细表
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_score")
@ApiModel(value="Score对象", description="打分明细表")
public class Score extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公司分数id")
    @TableField("company_score_id")
    private String companyScoreId;

    @ApiModelProperty(value = "kpi_id")
    @TableField("kpi_id")
    private String kpiId;

    @ApiModelProperty(value = "打分人id")
    @TableField("score_person")
    private String scorePerson;

    @ApiModelProperty(value = "分数")
    @TableField("scores")
    private BigDecimal scores;

    @ApiModelProperty(value = "权重分")
    @TableField("weight_scores")
    private BigDecimal weightScores;


}
