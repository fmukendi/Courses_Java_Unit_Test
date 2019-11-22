package com.mukeapps.unittesting.unittesting.utils;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        assertThat(numbers, hasSize(3) );
        assertThat(numbers, hasItems(10, 20) );
        assertThat(numbers, everyItem(greaterThan(9)));
        assertThat(numbers, everyItem(lessThan(100)));

        assertThat("", isEmptyString());
        assertThat("ABCDE", containsString("BCD"));
        assertThat("ABDCD", startsWith(("AB")));
        assertThat("ABCD", endsWith("CD"));

    }
}
