package com.epam.google_cloud.calculator_options;

public enum OperatingSystems {
    DEBIAN_AND_OTHERS("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS"),
    WINDOWS("Paid: Windows Server 2008r2, Windows Server 2012r2, Windows Server 2016, Windows Core"),
    RED_HAT("Paid: Red Hat Enterprise Linux"),
    RED_HAT_SAP("Paid: Red Hat Enterprise Linux for SAP Applications");

    private String value;

    OperatingSystems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
