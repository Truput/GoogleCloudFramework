package com.epam.google_cloud.calculator_options;

public enum MachineTypes {
    STANDART1N1("n1-standard-1"),
    STANDART2N1("n1-standard-2"),
    STANDART4N1("n1-standard-4"),
    STANDART8N1("n1-standard-8"),
    STANDART2N2("n2-standard-2"),
    STANDART4N2("n2-standard-4"),
    STANDART8N2("n2-standard-8"),
    STANDART2E2("e2-standard-2"),
    STANDART4E2("e2-standard-4"),
    STANDART8E2("e2-standard-8"),
    STANDART2N2D("n2d-standard-2"),
    STANDART4N2D("n2d-standard-4"),
    STANDART8N2D("n2d-standard-8");

    private String value;

    MachineTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
