package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3};
    }
}

public class SomeBusinessStubTest {

    @Test
    void calculateSumUsingDataService_basic() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_empty() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_one() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{11});
        int expectedResult = 11;

        assertEquals(expectedResult, actualResult);
    }
}