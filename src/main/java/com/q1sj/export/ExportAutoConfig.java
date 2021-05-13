package com.q1sj.export;

import com.qsj.export.Export;
import com.qsj.export.ExportContext;
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
    @Autowired
    private Environment env;

    private int excelMaxRows = 10000;
    private String excelSavePath = "/";

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

        return new ExportContext(exportList, excelMaxRows, excelSavePath);
    }
}
