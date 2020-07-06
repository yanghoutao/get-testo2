package com.hj.pas.controller;


import com.alibaba.excel.EasyExcel;
import com.hftk.tools.http.ResultGenerator;
import com.hftk.tools.http.ResultMsg;
import com.hj.pas.service.ICompanyService;
import com.hj.pas.utils.ExcelChildListener;
import com.hj.pas.utils.ExcelListener;
import com.hj.pas.vo.ImportChildData;
import com.hj.pas.vo.ImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 公司表 前端控制器
 * </p>
 *
 * @author qxq
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private ICompanyService companyService;

    @PostMapping("/import")
    @ResponseBody
    public ResultMsg upload(@RequestParam("file") MultipartFile file) throws Exception {
        EasyExcel.read(file.getInputStream(), ImportData.class, new ExcelListener(companyService)).sheet().headRowNumber(1)
                .doRead();
        return ResultGenerator.genSuccessResult("导入成功");

    }

    @PostMapping("/importChild")
    @ResponseBody
    public ResultMsg importChild(@RequestParam("file") MultipartFile file) throws Exception {
        EasyExcel.read(file.getInputStream(), ImportChildData.class, new ExcelChildListener(companyService)).sheet().headRowNumber(1)
                .doRead();
        return ResultGenerator.genSuccessResult("导入成功");

    }

}
