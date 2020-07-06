package com.hj.pas.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.pas.mapper.ScoreMapper;
import com.hj.pas.model.CompanyScore;
import com.hj.pas.model.Score;
import com.hj.pas.service.ICompanyScoreService;
import com.hj.pas.service.IScoreService;
import com.hj.pas.utils.UserContext;
import com.hj.pas.vo.ScoreRequestVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 打分明细表 服务实现类
 *
 * @author qxq
 * @since 2020-06-22
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {
  @Autowired
  private ICompanyScoreService companyScoreService;

  @Override
  @Transactional
  public boolean saveScore(ScoreRequestVO scoreRequestVO) {

    String scorePerson = UserContext.getUserId();
    BigDecimal weightScore =
            scoreRequestVO
                    .getScores()
                    .multiply(scoreRequestVO.getWeight())
                    .divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
    CompanyScore cs = null;//首先保存公司分数
    if (StringUtils.isBlank(scoreRequestVO.getCompanyScoreId())) {
      cs = new CompanyScore();
      cs.setScorePerson(scorePerson);
      cs.setScores(weightScore);
      cs.setCompanyId(scoreRequestVO.getCompanyId());
      cs.setCycle(scoreRequestVO.getCycle());
    } else {
      cs = companyScoreService.getById(scoreRequestVO.getCompanyScoreId());
      if (StringUtils.isNotBlank(scoreRequestVO.getId())) {//如果分数id不为空 需要先减掉原来权重分然后再加总
        Score old = getById(scoreRequestVO.getId());
        cs.setScores(cs.getScores().subtract(old.getWeightScores()).add(weightScore));
      } else {
        cs.setScores(cs.getScores().add(weightScore));
      }
    }
    companyScoreService.saveOrUpdate(cs);
    //保存打分详情
    Score score = new Score();
    score.setId(scoreRequestVO.getId());
    score.setKpiId(scoreRequestVO.getKpiId());
    score.setCompanyScoreId(cs.getId());
    score.setWeightScores(weightScore);
    score.setScores(scoreRequestVO.getScores());
    score.setScorePerson(scorePerson);
    this.saveOrUpdate(score);
    return true;
  }
}
