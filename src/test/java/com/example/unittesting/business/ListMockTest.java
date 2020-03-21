package com.example.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    List mock = mock(List.class);

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
}
