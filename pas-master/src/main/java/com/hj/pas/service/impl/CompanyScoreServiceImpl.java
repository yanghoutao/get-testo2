package com.hj.pas.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.pas.mapper.CompanyScoreMapper;
import com.hj.pas.model.CompanyScore;
import com.hj.pas.service.ICompanyScoreService;
import com.hj.pas.utils.UserContext;
import com.hj.pas.vo.CompanySortVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@Service
public class CompanyScoreServiceImpl extends ServiceImpl<CompanyScoreMapper, CompanyScore> implements ICompanyScoreService {
    @Autowired
    private CompanyScoreMapper companyScoreMapper;

    @Override
    public List<CompanySortVO> getSortList(String cycle, String hfGroup) {
        String scorePerson = UserContext.getUserId();
        return companyScoreMapper.getSortList(cycle, hfGroup, scorePerson);
    }
}
