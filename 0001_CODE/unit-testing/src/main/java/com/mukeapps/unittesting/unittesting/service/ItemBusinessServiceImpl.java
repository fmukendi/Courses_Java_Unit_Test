package com.mukeapps.unittesting.unittesting.service;

import com.mukeapps.unittesting.unittesting.model.Item;
import com.mukeapps.unittesting.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    ItemRepository itemRepository;

    public Item retrieveSampleItem(){


        return new Item(1, "Ball", 10 , 100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> dataList = itemRepository.findAll();
        for(Item d : dataList){
            d.setValue(d.getPrice() * d.getQuantitiy());
        }

        return dataList;
    }
}
