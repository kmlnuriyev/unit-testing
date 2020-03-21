package com.example.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {

        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferent() {

        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameter() {

        when(mock.get(0)).thenReturn("Kamal");
        assertEquals("Kamal", mock.get(0));
        assertNull(mock.get(1));
    }

    @Test
    public void returnWithGenericParameter() {

        when(mock.get(anyInt())).thenReturn("assign");
        assertEquals("assign", mock.get(0));
        assertEquals("assign", mock.get(1));
    }

    @Test
    public void verificationBasics() {

        // SUT -> system under test
        String value1 = mock.get(0);
//        String value2 = mock.get(1);

        // verify
        verify(mock).get(0);
        verify(mock).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {

        // SUT
        mock.add("SomeString");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {

        // SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    // A mock does not retain behaviour of the original class!
    public void mocking() {

        ArrayList arrayListMock = mock(ArrayList.class);

        System.out.println(arrayListMock.get(0));// null
        System.out.println(arrayListMock.size());// 0
        arrayListMock.add("one");
        arrayListMock.add("two");
        System.out.println(arrayListMock.size());// 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());// 5
    }

    @Test
    // A spy, by default, retains behaviour of the original class (not like mock)!
    public void spying() {

        ArrayList arrayListSpy = spy(ArrayList.class);

//        System.out.println(arrayListSpy.get(0));// null pointer exception
        System.out.println(arrayListSpy.size());// 0
        arrayListSpy.add("one");
        arrayListSpy.add("two");
        System.out.println(arrayListSpy.size());// 2
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());// 5

        verify(arrayListSpy).add("one");
    }
}
