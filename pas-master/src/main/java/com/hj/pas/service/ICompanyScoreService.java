package com.hj.pas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.pas.model.CompanyScore;
import com.hj.pas.vo.CompanySortVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface ICompanyScoreService extends IService<CompanyScore> {

    List<CompanySortVO> getSortList(String cycle, String hfGroup);
}
