package com.boot.security.server.dto;

import com.boot.security.server.model.AiConsumer;

public class AiConsumerDto extends AiConsumer {

    private String consumerTypeVal;

    private String consumerSourceVal;

    private String consumerStateVal;

    public String getConsumerTypeVal() {
        return consumerTypeVal;
    }

    public void setConsumerTypeVal(String consumerTypeVal) {
        this.consumerTypeVal = consumerTypeVal;
    }

    public String getConsumerSourceVal() {
        return consumerSourceVal;
    }

    public void setConsumerSourceVal(String consumerSourceVal) {
        this.consumerSourceVal = consumerSourceVal;
    }

    public String getConsumerStateVal() {
        return consumerStateVal;
    }

    public void setConsumerStateVal(String consumerStateVal) {
        this.consumerStateVal = consumerStateVal;
    }
}
