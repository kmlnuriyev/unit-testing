package com.example.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// Using Hamcrest matchers test
// Better assertions with Hamcrest
public class HamcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 13, 15);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12, 13));
        assertThat(numbers, everyItem(greaterThan(10)));
    }
}
