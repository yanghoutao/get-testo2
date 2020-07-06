package com.hj.pas.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ClassNameScoreRequestVO
 * @Author QiXueQing
 * @Date 2020/6/29
 * @Version V1.0
 **/
@Getter
@Setter
@ToString
public class ScoreRequestVO {
    private String id;
    private String kpiId;
    private String companyId;
    private String companyScoreId;
    private BigDecimal scores;
    private BigDecimal weight;
    private String cycle;
}
