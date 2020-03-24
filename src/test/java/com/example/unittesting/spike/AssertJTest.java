package com.example.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Better assertions with AssertJ
public class AssertJTest {

    @Test
    public void learning() {

        List<Integer> numbers = Arrays.asList(12, 13, 15);

        assertThat(numbers)
                .hasSize(3) // size is 3
                .contains(12, 13) // list contains elements
                .allMatch(x -> x > 10) // every element is greater than 10
                .allMatch(x -> x < 100) // every element is less than 100
                .noneMatch(x -> x < 0); // none of element is less than zero

        assertThat("").isEmpty();
        assertThat("ABCDE").contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");
    }
}
