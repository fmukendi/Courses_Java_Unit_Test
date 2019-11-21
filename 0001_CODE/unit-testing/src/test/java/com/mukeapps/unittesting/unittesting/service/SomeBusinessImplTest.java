package com.mukeapps.unittesting.unittesting.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SomeBusinessImplTest {

    private SomeBusinessImpl someBusiness;

    @BeforeEach
    void setUp() {
        this.someBusiness = new SomeBusinessImpl();
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    private  void  test(){
//        fail("Not Yet Implemented");
//    }

    @Test
    private  void  calculateSum_basic(){
        int actuarResult = someBusiness.calculateSum(new int[] {1,2,3});

        int expectedResult = 5;
        assertEquals(actuarResult , expectedResult);
    }
}