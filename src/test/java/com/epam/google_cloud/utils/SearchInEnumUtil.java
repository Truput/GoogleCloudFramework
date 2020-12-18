package com.epam.google_cloud.utils;

import com.epam.google_cloud.calculator_options.*;

public class SearchInEnumUtil {
    public static Product recieveSpecificProduct(String termOfSearch) {
        Product[] products = Product.values();
        for (int i = 0; i < products.length; i++){
            if (termOfSearch.equalsIgnoreCase(products[i].getValue())){
                return products[i];
            }
        }
        throw new IllegalArgumentException("Incorrect product!");
    }

    public static OperatingSystems recieveSpecificOS(String termOfSearch) {
        OperatingSystems[] operatingSystems = OperatingSystems.values();
        for (int i = 0; i < operatingSystems.length; i++){
            if (termOfSearch.equalsIgnoreCase(operatingSystems[i].getValue())){
                return operatingSystems[i];
            }
        }
        throw new IllegalArgumentException("Incorrect OS!");
    }

    public static VMClass recieveSpecificVMClass(String termOfSearch) {
        VMClass[] vmClasses = VMClass.values();
        for (int i = 0; i < vmClasses.length; i++){
            if (termOfSearch.equalsIgnoreCase(vmClasses[i].getValue())){
                return vmClasses[i];
            }
        }
        throw new IllegalArgumentException("Incorrect virtual machine class value!");
    }

    public static Series recieveSpecificSeries(String termOfSearch) {
        Series[] series = Series.values();
        for (int i = 0; i < series.length; i++){
            if (termOfSearch.equals(series[i].name())){
                return series[i];
            }
        }
        throw new IllegalArgumentException("Incorrect series value!");
    }

    public static MachineTypes recieveSpecificMachineType(Series series, String termOfSearch) {
        MachineTypes[] machineTypes = series.getMachineTypes();
        for (int i = 0; i < machineTypes.length; i++){
            if (termOfSearch.equalsIgnoreCase(machineTypes[i].getValue())){
                return machineTypes[i];
            }
        }
        throw new IllegalArgumentException("Incorrect machine type!");
    }

    public static DataCenterLocations recieveSpecificLocation(String termOfSearch) {
        DataCenterLocations[] dataCenterLocations = DataCenterLocations.values();
        for (int i = 0; i < dataCenterLocations.length; i++){
            if (termOfSearch.equalsIgnoreCase(dataCenterLocations[i].getValue())){
                return dataCenterLocations[i];
            }
        }
        throw new IllegalArgumentException("Incorrect data center location!");
    }

    public static NumberOfGPU recieveSpecificNumberOFGPUs(String termOfSearch) {
        NumberOfGPU[] numberOfGPUS = NumberOfGPU.values();
        for (int i = 0; i < numberOfGPUS.length; i++){
            if (termOfSearch.equalsIgnoreCase(numberOfGPUS[i].getValue())){
                return numberOfGPUS[i];
            }
        }
        throw new IllegalArgumentException("Incorrect number of GPUs!");
    }

    public static GPUTypes recieveSpecificGPUType(String termOfSearch) {
        GPUTypes[] gpuTypes = GPUTypes.values();
        for (int i = 0; i < gpuTypes.length; i++){
            if (termOfSearch.contains(gpuTypes[i].name())){
                return gpuTypes[i];
            }
        }
        throw new IllegalArgumentException("Incorrect GPU type!");
    }

    public static LocalSSDs recieveSpecificLocalSSDs(String termOfSearch) {
        LocalSSDs[] localSSDs = LocalSSDs.values();
        for (int i = 0; i < localSSDs.length; i++){
            if (termOfSearch.equalsIgnoreCase(localSSDs[i].getValue())){
                return localSSDs[i];
            }
        }
        throw new IllegalArgumentException("Incorrect local SSD value!");
    }

    public static CommitedUsages recieveSpecificCommitedUsage(String termOfSearch) {
        CommitedUsages[] commitedUsages = CommitedUsages.values();
        for (int i = 0; i < commitedUsages.length; i++){
            if (termOfSearch.equalsIgnoreCase(commitedUsages[i].getValue())){
                return commitedUsages[i];
            }
        }
        throw new IllegalArgumentException("Incorrect commited usage value!");
    }
}
