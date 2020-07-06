package com.hj.pas.controller;


import com.hftk.tools.http.ResultGenerator;
import com.hftk.tools.http.ResultMsg;
import com.hj.pas.service.IScoreService;
import com.hj.pas.vo.ScoreRequestVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 打分明细表 前端控制器
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private IScoreService scoreService;

    @PostMapping("/save")
    @ApiOperation(value = "保存分数", notes = "保存分数")
    public ResultMsg save(ScoreRequestVO scoreRequestVO) {
        boolean result = scoreService.saveScore(scoreRequestVO);
        return ResultGenerator.genSuccessResult(result);
    }
}
