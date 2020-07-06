package com.hj.pas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.pas.model.Score;
import com.hj.pas.vo.ScoreRequestVO;

/**
 * <p>
 * 打分明细表 服务类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface IScoreService extends IService<Score> {

    boolean saveScore(ScoreRequestVO scoreRequestVO);
}
