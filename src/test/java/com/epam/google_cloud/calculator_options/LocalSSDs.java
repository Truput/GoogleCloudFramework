package com.epam.google_cloud.calculator_options;

public enum LocalSSDs {
    ZERO("0"), ONE("1x375"), TWO("2x375"), THREE("3x375"), FOUR("4x375");

    private String value;

    LocalSSDs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
