package com.q1sj.export;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    private ExportProperties exportProperties;

    @Bean
    public ExportContext getExportContext() {

        return new ExportContext(exportList,
                exportProperties.getMaxRows(),
                exportProperties.getSavePath(),
                exportStatusChangeListener,
                exportProperties.isEnableSubList());
    }
}
