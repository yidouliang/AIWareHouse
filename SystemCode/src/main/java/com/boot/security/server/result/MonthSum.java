package com.boot.security.server.result;

import java.math.BigDecimal;
import java.util.Date;

public class MonthSum {

    //该月份的营业额
    private BigDecimal sumPrice;

    private Integer months;

    private Integer count;

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
