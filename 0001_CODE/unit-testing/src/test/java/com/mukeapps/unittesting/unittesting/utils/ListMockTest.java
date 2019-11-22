package com.mukeapps.unittesting.unittesting.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class ListMockTest {

    private List<String> mock;


    @BeforeEach
    void setup(){
        mock = mock(List.class);
    }

    @Test
    public void test(){
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }


    @Test
    public void returnDifferentValues(){


        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public  void returnWithParam(){
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public  void returnGenericParam(){
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
        assertEquals("in28Minutes", mock.get(1));
    }
    @Test
    public  void verficationBasics(){
        //SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);
        //Verify
        verify(mock).get(0);
//        verify(mock).get(anyInt());
        verify(mock, times(2)).get(anyInt());
//        verify(mock, times(1)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }


    @Test
    public  void argumentCapturing(){
        // SUT
        mock.add("string1");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("string1", captor.getValue());
    }

    @Test
    public  void multipleArgumentCapturing(){
        // SUT
        mock.add("string1");
        mock.add("string2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("string1", allValues.get(0));
        assertEquals("string2", allValues.get(1));
    }


    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);

        arrayListMock.get(0); // null
        arrayListMock.size(); //0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        arrayListMock.size(); //0
        when(arrayListMock.size()).thenReturn(5);
        arrayListMock.size();//5
    }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);

        arrayListSpy.add("Test0");

        arrayListSpy.get(0); // Test0
        arrayListSpy.size(); //1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        arrayListSpy.size(); //3
        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.size();//5
        arrayListSpy.add("Test4");
        arrayListSpy.size(); //5
        verify(arrayListSpy).add("Test4");

    }
}
