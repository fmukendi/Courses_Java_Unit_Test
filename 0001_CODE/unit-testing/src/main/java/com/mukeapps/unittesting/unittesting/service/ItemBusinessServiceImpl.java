package com.mukeapps.unittesting.unittesting.service;

import com.mukeapps.unittesting.unittesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    public Item retrieveHardCodedItem(){


        return new Item(1, "Ball", 10 , 100);
    }
}
