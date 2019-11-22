package com.mukeapps.unittesting.unittesting.utils;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AsserJTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(10, 20, 30);
//        assertThat(numbers, hasSize(3) );
         assertThat(numbers).hasSize(3)
                            .contains(10,30)
                            .allMatch(x -> x >= 10)
                             .allMatch(x -> x < 100)
                             .noneMatch(x -> x < 0 );

//        assertThat("", isEmptyString());
          assertThat("ABCDE").contains("BCD")
                                     .isNotEmpty()
                                     .startsWith("AB")
                                     .endsWith("DE");

    }
}
