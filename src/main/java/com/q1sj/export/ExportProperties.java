package com.q1sj.export;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Q1sj
 * @date 2021.5.14 11:07
 */
@ConfigurationProperties(prefix = "excel")
public class ExportProperties {
    /**
     * 单excel最大行数
     * enableSubList=true时生效
     */
    private int maxRows = 10000;
    /**
     * 导出excel存放的根路径
     */
    private String savePath = "/";
    /**
     * 是否subList
     */
    private boolean enableSubList = false;

    public int getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public boolean isEnableSubList() {
        return enableSubList;
    }

    public void setEnableSubList(boolean enableSubList) {
        this.enableSubList = enableSubList;
    }
}
