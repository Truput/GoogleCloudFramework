package com.epam.google_cloud.calculator_options;

public enum DataCenterLocations {
    IOWA("Iowa"), FRANKFURT("Frankfurt"), OREGON("Oregon"), LONDON("London");

    private String value;

    DataCenterLocations(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
