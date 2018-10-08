package com.boot.security.server.result;

import java.util.List;

/**
 * 用于扇形图数据的pojo
 */
public class FanReport {

    //字符类型列表
    List<String> payTypes;

    List<PayCount> payCounts;

    public List<String> getPayTypes() {
        return payTypes;
    }

    public void setPayTypes(List<String> payTypes) {
        this.payTypes = payTypes;
    }

    public List<PayCount> getPayCounts() {
        return payCounts;
    }

    public void setPayCounts(List<PayCount> payCounts) {
        this.payCounts = payCounts;
    }
}
