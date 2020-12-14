package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("wc")
class Config {


    private Boolean caseSensitive;

    private List<String> skip;
    public Config Config() {
        return new Config();
    }

    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }


    public List<String> getSkip() {
        return skip;
    }

    public void setSkip(List<String> skip) {
        this.skip = skip;
    }


}
