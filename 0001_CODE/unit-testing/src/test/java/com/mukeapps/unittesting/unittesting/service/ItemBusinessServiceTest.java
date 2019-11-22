package com.mukeapps.unittesting.unittesting.service;

import static org.mockito.Mockito.when;

import com.mukeapps.unittesting.unittesting.model.Item;
import com.mukeapps.unittesting.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessServiceImpl itemBusinessServiceImpl;

    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void caluculateItemValue_basic() {

        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item( 1, "Ball", 10, 100),
                new Item( 2, "Ball2", 20, 100)
        ));

        List<Item> items = itemBusinessServiceImpl.retrieveAllItems();
        assertEquals(1000,items.get(0).getValue() );
        assertEquals(2000,items.get(1).getValue() );
    }


}

