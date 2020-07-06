package com.hj.pas.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author qxq
 * @since 2020-02-12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ImportData implements Serializable {
    private int rowIndex;
    @ExcelProperty(index = 0)
    private String companyName;
    @ExcelProperty(index = 1)
    private String dimensionName;
    @ExcelProperty(index = 2)
    private String dimensionWeight;
    @ExcelProperty(index = 3)
    private String kpi;
    @ExcelProperty(index = 4)
    private String kpiWeight;
    @ExcelProperty(index = 5)
    private String pass;
    @ExcelProperty(index = 6)
    private String completeStandard;
    @ExcelProperty(index = 7)
    private String scoreMethod;
    @ExcelProperty(index = 8)
    private String realValue;
}
