package com.epam.google_cloud.models;

import com.epam.google_cloud.calculator_options.*;
import com.epam.google_cloud.utils.SearchInEnumUtil;

public class CalculatorFormModel {
    private Product product;
    private String numberOFInstances;
    private OperatingSystems operatingSystem;
    private VMClass vmClass;
    private Series series;
    private MachineTypes machineType;
    private NumberOfGPU numberOfGPUs;
    private GPUTypes gpuType;
    private LocalSSDs localSSDNumber;
    private DataCenterLocations dataCenterLocation;
    private CommitedUsages commitedUsage;
    private double totalEsimatedCost;

    public CalculatorFormModel(String product, String numberOFInstances, String operatingSystem, String vmClass,
                               String series, String machineType,
                               String numberOfGPUs, String gpuType, String localSSDNumber,
                               String dataCenterLocation, String commitedUsage, String totalEstimatedCost) {
        setProduct(product);
        setNumberOFInstances(numberOFInstances);
        setOperatingSystem(operatingSystem);
        setVmClass(vmClass);
        setSeries(series);
        setMachineType(machineType);
        setNumberOfGPUs(numberOfGPUs);
        setGpuType(gpuType);
        setLocalSSDNumber(localSSDNumber);
        setDataCenterLocation(dataCenterLocation);
        setCommitedUsage(commitedUsage);
        setTotalEsimatedCost(totalEstimatedCost);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = SearchInEnumUtil.recieveSpecificProduct(product);
    }

    public String getNumberOFInstances() {
        return numberOFInstances;
    }

    public void setNumberOFInstances(String numberOFInstances) {
        int numberToInt = Integer.parseInt(numberOFInstances);
        if (numberToInt > 0 && numberToInt < Integer.MAX_VALUE){
            this.numberOFInstances = numberOFInstances;
        } else {
            throw new IllegalArgumentException("Incorrect number of instances value!");
        }
    }

    public OperatingSystems getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = SearchInEnumUtil.recieveSpecificOS(operatingSystem);
    }

    public VMClass getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = SearchInEnumUtil.recieveSpecificVMClass(vmClass);
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = SearchInEnumUtil.recieveSpecificSeries(series);
    }

    public MachineTypes getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = SearchInEnumUtil.recieveSpecificMachineType(series, machineType);
    }

    public NumberOfGPU getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = SearchInEnumUtil.recieveSpecificNumberOFGPUs(numberOfGPUs);
    }

    public GPUTypes getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = SearchInEnumUtil.recieveSpecificGPUType(gpuType);
    }

    public LocalSSDs getLocalSSDNumber() {
        return localSSDNumber;
    }

    public void setLocalSSDNumber(String localSSDNumber) {
        this.localSSDNumber = SearchInEnumUtil.recieveSpecificLocalSSDs(localSSDNumber);
    }

    public DataCenterLocations getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = SearchInEnumUtil.recieveSpecificLocation(dataCenterLocation);
    }

    public CommitedUsages getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = SearchInEnumUtil.recieveSpecificCommitedUsage(commitedUsage);
    }

    public double getTotalEsimatedCost() {
        return totalEsimatedCost;
    }

    public void setTotalEsimatedCost(String totalEsimatedCost) {
        this.totalEsimatedCost = Double.parseDouble(totalEsimatedCost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalculatorFormModel that = (CalculatorFormModel) o;

        if (product != that.product) return false;
        if (numberOFInstances != null ? !numberOFInstances.equals(that.numberOFInstances) : that.numberOFInstances != null)
            return false;
        if (vmClass != that.vmClass) return false;
        if (series != that.series) return false;
        if (machineType != that.machineType) return false;
        if (numberOfGPUs != that.numberOfGPUs) return false;
        if (gpuType != that.gpuType) return false;
        if (localSSDNumber != that.localSSDNumber) return false;
        if (dataCenterLocation != that.dataCenterLocation) return false;
        return commitedUsage == that.commitedUsage;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (numberOFInstances != null ? numberOFInstances.hashCode() : 0);
        result = 31 * result + (vmClass != null ? vmClass.hashCode() : 0);
        result = 31 * result + (series != null ? series.hashCode() : 0);
        result = 31 * result + (machineType != null ? machineType.hashCode() : 0);
        result = 31 * result + (numberOfGPUs != null ? numberOfGPUs.hashCode() : 0);
        result = 31 * result + (gpuType != null ? gpuType.hashCode() : 0);
        result = 31 * result + (localSSDNumber != null ? localSSDNumber.hashCode() : 0);
        result = 31 * result + (dataCenterLocation != null ? dataCenterLocation.hashCode() : 0);
        result = 31 * result + (commitedUsage != null ? commitedUsage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CalculatorFormModel{" +
                "product=" + product +
                ", numberOFInstances='" + numberOFInstances + '\'' +
                ", vmClass=" + vmClass +
                ", series=" + series +
                ", machineType=" + machineType +
                ", numberOfGPUs=" + numberOfGPUs +
                ", gpuType=" + gpuType +
                ", localSSDNumber=" + localSSDNumber +
                ", dataCenterLocation=" + dataCenterLocation +
                ", commitedUsage=" + commitedUsage +
                '}';
    }
}
