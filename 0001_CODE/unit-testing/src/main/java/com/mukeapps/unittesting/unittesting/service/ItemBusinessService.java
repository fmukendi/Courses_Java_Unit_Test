package com.mukeapps.unittesting.unittesting.service;

import com.mukeapps.unittesting.unittesting.model.Item;

import java.util.List;

public interface ItemBusinessService {
    Item retrieveSampleItem();
    List<Item> retrieveAllItems();

}
