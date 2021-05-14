package com.q1sj.export;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * @author Q1sj
 * @date 2021.5.13 13:46
 */
@Configuration
public class ExportAutoConfig {
    @Autowired(required = false)
    private List<Export> exportList;
    @Autowired(required = false)
    private ExportStatusChangeListener exportStatusChangeListener;
    @Autowired
    private Environment env;

    /**
     * 单excel最大行数
     * enableSubList=true时生效
     */
    private int excelMaxRows = 10000;
    /**
     * 导出excel存放的根路径
     */
    private String excelSavePath = "/";
    /**
     * 是否subList
     */
    private boolean enableSubList = false;

    @Bean
    public ExportContext getExportContext() {
        String maxRow = env.getProperty("excel.max-rows");
        if (maxRow !=null){
            excelMaxRows = Integer.parseInt(maxRow);
        }
        String savePath = env.getProperty("excel.save-path");
        if (savePath !=null) {
            excelSavePath=savePath;
        }
        String subList = env.getProperty("excel.sublist");
        if (subList != null) {
            enableSubList=Boolean.parseBoolean(subList);
        }
        return new ExportContext(exportList, excelMaxRows, excelSavePath,exportStatusChangeListener,enableSubList);
    }
}
