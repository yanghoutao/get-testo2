package com.hj.pas.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hj.pas.service.ICompanyService;
import com.hj.pas.vo.ImportChildData;

import java.util.ArrayList;
import java.util.List;

public class ExcelChildListener extends AnalysisEventListener<ImportChildData> {
    private ICompanyService companyService;

    public ExcelChildListener(ICompanyService clocksService) {
        this.companyService = clocksService;
    }

    // 可以通过实例获取该值
    private List<ImportChildData> datas = new ArrayList<ImportChildData>();

    @Override
    public void invoke(ImportChildData o, AnalysisContext analysisContext) {
        o.setRowIndex(analysisContext.readRowHolder().getRowIndex());
        datas.add(o); // 数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(o); // 根据自己业务做处理
    }

    private void doSomething(ImportChildData object) {
        companyService.saveChildImport(object);
    }

    public List<ImportChildData> getDatas() {
        return datas;
    }

    public void setDatas(List<ImportChildData> datas) {
        this.datas = datas;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // datas.clear();//解析结束销毁不用的资源
    }
}
