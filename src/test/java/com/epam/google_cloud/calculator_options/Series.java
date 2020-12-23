package com.epam.google_cloud.calculator_options;

public enum Series {
    N1(new MachineTypes[]{MachineTypes.STANDART1N1, MachineTypes.STANDART4N1, MachineTypes.STANDART2N1, MachineTypes.STANDART8N1}),
    N2(new MachineTypes[]{MachineTypes.STANDART2N2, MachineTypes.STANDART4N2, MachineTypes.STANDART8N2}),
    E2(new MachineTypes[]{MachineTypes.STANDART2E2, MachineTypes.STANDART4E2, MachineTypes.STANDART8E2}),
    N2D(new MachineTypes[]{MachineTypes.STANDART2N2D, MachineTypes.STANDART4N2D, MachineTypes.STANDART8N2D});

    private MachineTypes[] machineTypes;

    Series(MachineTypes[] machineTypes) {
        this.machineTypes = machineTypes;
    }

    public MachineTypes[] getMachineTypes() {
        return machineTypes;
    }
}
