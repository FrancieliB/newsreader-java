package com.interview.newsreader.dto;

import java.util.Date;

import com.interview.newsreader.enuns.LanguageNewsEnum;
import com.interview.newsreader.enuns.SortNewsEnum;

public class ParametersNewsAPI {
    private String apiKey;
    private String q;
    private Date from;
    private Date to;
    private LanguageNewsEnum language;
    private SortNewsEnum sortBy;
    private Integer pageSize;
    private Integer page;
    
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public LanguageNewsEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageNewsEnum language) {
        this.language = language;
    }

    public SortNewsEnum getSortBy() {
        return sortBy;
    }

    public void setSortBy(SortNewsEnum sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }    
}
