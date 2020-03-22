package com.example.unittesting.business;

import com.example.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retrieveHardCodedItem() {
        return new Item(2, "Ball", 10, 100);
    }
}
