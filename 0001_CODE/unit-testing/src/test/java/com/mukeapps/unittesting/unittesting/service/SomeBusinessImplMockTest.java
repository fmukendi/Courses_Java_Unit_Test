package com.mukeapps.unittesting.unittesting.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class SomeBusinessImplMockTest {

//    private SomeBusinessImpl someBusiness;
//    private SomeDataService someDataServiceMock;

//    @InjectMocks
//    private SomeBusinessImpl someBusiness = new SomeBusinessImpl();
    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Mock
    private SomeDataService someDataServiceMock;

    @BeforeEach
    void setUp() {

//        this.someBusiness = new SomeBusinessImpl();
//        this.someDataServiceMock = mock(SomeDataService.class);

        // someBusiness.setSomeDataService(someDataServiceMock);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void calculateSum_basic() {

        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(someBusiness.calculateSumWithDataService(), 6);
    }


    @Test
    public void calculateSum_empty() {

        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        int actuarResult = someBusiness.calculateSumWithDataService();
        int expectedResult = 0;
        assertEquals(actuarResult, expectedResult);
    }
}