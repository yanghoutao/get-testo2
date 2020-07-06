package com.hj.pas.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author qxq
 * @since 2020-02-12
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ImportChildData implements Serializable {
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
    private String kpiDefine;

    @ExcelProperty(index = 5)
    private String kpiWeight;

    @ExcelProperty(index = 6)
    private String beforeYear;

    @ExcelProperty(index = 7)
    private String lastYear;

    @ExcelProperty(index = 8)
    private String pass;

    @ExcelProperty(index = 9)
    private String fullMark;

    @ExcelProperty(index = 10)
    private String challenge;

    @ExcelProperty(index = 11)
    private String scoreMethod;

    @ExcelProperty(index = 12)
    private String dataSource;

    @ExcelProperty(index = 13)
    private String appraiser;

    @ExcelProperty(index = 14)
    private String remark;

    @ExcelProperty(index = 15)
    private String realValue;
}
