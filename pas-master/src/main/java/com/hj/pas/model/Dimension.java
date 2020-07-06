package com.hj.pas.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("t_dimension")
@ApiModel(value="Dimension对象", description="考核维度表")
public class Dimension extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "维度名称")
    @TableField("dimension_name")
    private String dimensionName;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;


}
