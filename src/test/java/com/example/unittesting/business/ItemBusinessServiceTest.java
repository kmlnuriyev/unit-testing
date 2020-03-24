package com.example.unittesting.business;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService businessService;

    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveAllItems_basic() {

        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1, "Item1", 10, 5),
                new Item(2, "Item2", 15, 10)));

        List<Item> items = businessService.retrieveAllItems();

        assertEquals(50, items.get(0).getValue());
        assertEquals(150, items.get(1).getValue());
    }
}
