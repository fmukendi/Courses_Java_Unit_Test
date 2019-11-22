package com.mukeapps.unittesting.unittesting.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        // functional programming

        return Arrays.stream(data).reduce(Integer::sum).orElse(0);

        // 1+2+3+4+5 => 1+2+3++5
//        OptionalInt number =  Arrays.stream(data).reduce(Integer::sum);
//        return number.orElse(0);
//        int sum = 0;
//        for(int value: data){
//            sum += value;
//        }
//        return  sum;
    }

    public int calculateSumWithDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }
}
