package com.example.unittesting.data;

import com.example.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DataJpaTest // in memory db is created and all the data is added..
public class ItemRepositoryTest {

    @Autowired
    ItemRepository repository;

    @Test
    public void findAll_test() {

        List<Item> items = repository.findAll();

        assertEquals(3, items.size());
    }
}
