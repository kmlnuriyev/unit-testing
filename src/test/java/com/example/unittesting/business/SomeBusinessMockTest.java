package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService dataServiceMock;

    /* We refactored with Mockito annotations..
    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @BeforeEach
    public void before() {
        business.setSomeDataService(dataServiceMock);
    }*/

    @Test
    void calculateSumUsingDataService_basic() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    void calculateSumUsingDataService_empty() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    void calculateSumUsingDataService_one() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{11});
        assertEquals(11, business.calculateSumUsingDataService());
    }
}