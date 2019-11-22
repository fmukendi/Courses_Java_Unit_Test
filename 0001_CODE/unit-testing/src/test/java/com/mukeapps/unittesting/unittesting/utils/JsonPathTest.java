package com.mukeapps.unittesting.unittesting.utils;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void learning(){
        String reponseFromService = "[\n" +
                "  {\"id\":1001,\"name\":\"Item1\",\"price\":10,\"quantitiy\":20,\"value\":200},\n" +
                "  {\"id\":1002,\"name\":\"Item2\",\"price\":100,\"quantitiy\":200,\"value\":20000},\n" +
                "  {\"id\":1003,\"name\":\"Item3\",\"price\":109,\"quantitiy\":209,\"value\":22781}\n" +
                "]";

        DocumentContext context = JsonPath.parse(reponseFromService);
        int length = context.read("$.length()");

        System.out.println(context.read("$..id").toString());
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString());
        System.out.println(context.read("$.[?(@.name=='Item1')]").toString());
        System.out.println(context.read("$.[?(@.quantity==200)]").toString());
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1001, 1002, 1003);

        assertThat(length).isEqualTo(3);
    }
}
