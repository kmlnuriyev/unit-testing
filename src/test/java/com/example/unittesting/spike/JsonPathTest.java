package com.example.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void learning() {

        String responseFromService = "[{\"id\":101, \"name\":\"Pencil\", \"quantity\":5}," +
                "{\"id\":102, \"name\":\"Pen\", \"quantity\":10}," +
                "{\"id\":103, \"name\":\"Book\", \"quantity\":15}]";

        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()"); // elements count
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(101, 102, 103);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='Book')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());
    }
}
