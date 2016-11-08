package com.codyy.slr.entity;

public class BasicInfoVal {
    private String valId;

    private String value;

    public String getValId() {
        return valId;
    }

    public void setValId(String valId) {
        this.valId = valId == null ? null : valId.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}