package com.hj.pas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.pas.model.Company;
import com.hj.pas.vo.ImportChildData;
import com.hj.pas.vo.ImportData;

/**
 * <p>
 * 公司表 服务类
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
public interface ICompanyService extends IService<Company> {

    void saveImport(ImportData object);

    void saveChildImport(ImportChildData object);

}
