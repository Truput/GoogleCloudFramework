package com.epam.google_cloud.calculator_options;

public enum VMClass {
    REGULAR("Regular"), PREEMPTIBLE("Preemptible");

    private String value;

    VMClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
