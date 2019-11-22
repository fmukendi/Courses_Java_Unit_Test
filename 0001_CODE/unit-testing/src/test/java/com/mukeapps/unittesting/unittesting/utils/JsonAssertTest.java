package com.mukeapps.unittesting.unittesting.utils;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    private String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantitiy\":100}";

    @Test
    public void jsonAssert_strictTrue_exactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantitiy\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);


    }

    @Test
    public void jsonAssert_String_false () throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
    @Test
    public void jsonAssert_WithoutEscapeCharacters () throws JSONException {
        String expectedResponse = "{id:1,name:Ball,price:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
