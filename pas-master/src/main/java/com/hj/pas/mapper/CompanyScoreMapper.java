package com.hj.pas.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.pas.model.CompanyScore;
import com.hj.pas.vo.CompanySortVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface CompanyScoreMapper extends BaseMapper<CompanyScore> {

  List<CompanySortVO> getSortList(
          @Param("cycle") String cycle,
          @Param("hfGroup") String hfGroup,
          @Param("scorePerson") String scorePerson);
}
