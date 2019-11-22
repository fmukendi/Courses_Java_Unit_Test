package com.mukeapps.unittesting.unittesting.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;



class  SomeDataServiceStub implements  SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class  SomeDataServiceEmptyStub implements  SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

@SpringBootTest
class SomeBusinessImplStubTest {

    private SomeBusinessImpl someBusiness;

    @BeforeEach
    void setUp() {
        this.someBusiness = new SomeBusinessImpl();
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void  test(){
//        fail("Not Yet Implemented");
//    }

    @Test
    public   void  calculateSum_basic(){
        someBusiness.setSomeDataService(new SomeDataServiceStub());

        int actuarResult = someBusiness.calculateSumWithDataService();
        int expectedResult = 6;
        assertEquals(actuarResult , expectedResult);
    }


    @Test
    public   void  calculateSum_empty(){
        someBusiness.setSomeDataService(new SomeDataServiceEmptyStub());

        int actuarResult = someBusiness.calculateSumWithDataService();
        int expectedResult = 0;
        assertEquals(actuarResult , expectedResult);
    }
}