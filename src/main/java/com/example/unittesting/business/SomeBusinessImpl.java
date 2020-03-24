package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSumUsingStream(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSum(int[] data) {

        int sum = 0;
        for (int i:data) {
            sum += i;
        }

        return sum;
    }

    public int calculateSumUsingDataService() {

        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int i:data) {
            sum += i;
        }

        return sum;
    }
}
