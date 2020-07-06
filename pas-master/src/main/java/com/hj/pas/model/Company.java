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
 * 公司表
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_company")
@ApiModel(value="Company对象", description="公司表")
public class Company extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公司名称")
    @TableField("company_name")
    private String companyName;

    @ApiModelProperty(value = "是否总部 Y ,N")
    @TableField("hf_group")
    private String hfGroup;


}
