package com.hj.pas.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerUtil {
    /**
     * 按照字符串模板输出
     *
     * @param input
     * @param templateStr
     * @return
     */
    public static String freemarkerProcess(Map input, String templateStr) {
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        String template = "";
        stringLoader.putTemplate(template, templateStr);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setTemplateLoader(stringLoader);
        try {
            Template templateCon = cfg.getTemplate(template);
            StringWriter writer = new StringWriter();
            templateCon.process(input, writer);
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

}
