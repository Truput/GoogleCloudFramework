package com.epam.google_cloud.calculator_options;

public enum  Product {
    COMPUTE_ENGINE("Compute Engine"),
    APP_ENGINE("App Engine"),
    KUBERNETES_ENGINE("Kubernetes Engine"),
    CLOUD_RUN("Cloud Run");

    private String value;

    Product(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
