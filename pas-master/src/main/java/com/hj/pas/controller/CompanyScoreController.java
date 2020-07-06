package com.hj.pas.controller;


import com.hftk.tools.http.ResultGenerator;
import com.hftk.tools.http.ResultMsg;
import com.hj.pas.service.ICompanyScoreService;
import com.hj.pas.vo.CompanySortVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/company-score")
public class CompanyScoreController {
    @Autowired
    private ICompanyScoreService companyScoreService;

    @PostMapping("/getSortList")
    @ApiOperation(value = "获取评分排列表", notes = "获取评分排列表")
    public ResultMsg getSortList(String cycle, String hfGroup) {
        List<CompanySortVO> result = companyScoreService.getSortList(cycle, hfGroup);
        return ResultGenerator.genSuccessResult(result);
    }
}
