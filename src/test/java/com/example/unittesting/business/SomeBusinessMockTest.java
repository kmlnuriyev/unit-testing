package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {

    @Test
    void calculateSumUsingDataService_basic() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});

        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService_empty() {

        SomeBusinessImpl business = new SomeBusinessImpl();

        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService_one() {

        SomeBusinessImpl business = new SomeBusinessImpl();

        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{11});

        business.setSomeDataService(dataServiceMock);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 11;

        assertEquals(expectedResult, actualResult);
    }
}