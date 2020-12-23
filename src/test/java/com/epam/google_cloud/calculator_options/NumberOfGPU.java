package com.epam.google_cloud.calculator_options;

public enum NumberOfGPU {
    ZERO("0"), ONE("1"), TWO("2"), FOUR("4"), EIGHT("8");

    private String value;

    NumberOfGPU(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
