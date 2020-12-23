package com.epam.google_cloud.service;

import com.epam.google_cloud.models.CalculatorFormModel;

public class CalculatorFormCreator {
    private static final String PRODUCT_FIELD_SEARCH_TERM = "testdata.product";
    private static final String NUMBER_OF_INSTANCES = "testdata.number_of_instances";
    private static final String OS = "testdata.OS";
    private static final String VMOption = "testdata.virtual_machine";
    private static final String SERIES = "testdata.series";
    private static final String MACHINE_TYPE = "testdata.machine_type";
    private static final String NUMBER_OF_GPUS = "testdata.number_of_GPUs";
    private static final String GPU_TYPE = "testdata.GPU_type";
    private static final String LOCAL_SSDS_NUMBER = "testdata.local_SSD";
    private static final String LOCATION = "testdata.data_center_location";
    private static final String USAGE = "testdata.commited_usage";
    private static final String TOTAL_ESTIMATED_COST = "testdata.totalEstimatedCost";

    public static CalculatorFormModel withStandartOptions() {
        return new CalculatorFormModel(TestDataReader.getTestData(PRODUCT_FIELD_SEARCH_TERM),
                TestDataReader.getTestData(NUMBER_OF_INSTANCES), TestDataReader.getTestData(OS),
                TestDataReader.getTestData(VMOption), TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(MACHINE_TYPE), TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(GPU_TYPE), TestDataReader.getTestData(LOCAL_SSDS_NUMBER),
                TestDataReader.getTestData(LOCATION), TestDataReader.getTestData(USAGE),
                TestDataReader.getTestData(TOTAL_ESTIMATED_COST));
    }

}
