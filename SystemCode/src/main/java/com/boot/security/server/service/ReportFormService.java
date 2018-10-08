package com.boot.security.server.service;

import com.boot.security.server.result.FanReport;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ReportFormService {

    FanReport getFanReport();

    List<BigDecimal> getTurnover(Date nowDay);
}
