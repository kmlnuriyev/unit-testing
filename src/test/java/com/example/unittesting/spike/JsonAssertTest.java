package com.example.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResult = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {

        String expectedResult = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

        // when we write true for strict then method checks all tags
        // for instance if we delete the quantity tag from json then the test will fail
        JSONAssert.assertEquals(expectedResult, actualResult, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {

        String expectedResult = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResult, actualResult, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {

        String expectedResult = "{id:1, name:Ball, price:10, quantity:100}";
        JSONAssert.assertEquals(expectedResult, actualResult, true);
    }
}
