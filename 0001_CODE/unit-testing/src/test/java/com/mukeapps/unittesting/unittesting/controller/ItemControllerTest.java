package com.mukeapps.unittesting.unittesting.controller;


import com.mukeapps.unittesting.unittesting.model.Item;
import com.mukeapps.unittesting.unittesting.service.ItemBusinessServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessServiceImpl itemBusinessServiceImpl;

    @BeforeEach
    void setup(){

    }

    @Test
    public void dummy_item_basic() throws Exception {

        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantitiy\":100}";
        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantitiy\":100}"))
                .andReturn();


        // verify "Hello World";
//        assertEquals("Hello World", result.getResponse().getContentAsString());
//        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }



    @Test
    public void itemFromBusinessService() throws Exception {

        String expected = "{\"id\":2,\"name\":\"Ball\",\"price\":10,\"quantitiy\":10}";

        when(itemBusinessServiceImpl.retrieveSampleItem()).thenReturn(new Item(2, "Ball", 10, 10 ));

        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();


        // verify "Hello World";
//        assertEquals("Hello World", result.getResponse().getContentAsString());
    }



    @Test
    public void retreiveAllItems_basic() throws Exception {

        String expected = "[{\"id\":2,\"name\":\"Ball\",\"price\":10,\"quantitiy\":10}]";

        when(itemBusinessServiceImpl.retrieveAllItems()).thenReturn(Arrays.asList(new Item(2, "Ball", 10, 10 )));

        // call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/get-all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();


        // verify "Hello World";
//        assertEquals("Hello World", result.getResponse().getContentAsString());
    }
}
