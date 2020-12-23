package com.epam.google_cloud.calculator_options;

public enum CommitedUsages {
    NONE("None"), ONE_YEAR("1 Year"), THREE_YEARS("3 Years");

    private String value;

    CommitedUsages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
