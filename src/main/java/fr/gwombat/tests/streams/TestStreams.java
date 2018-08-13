package fr.gwombat.tests.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by guillaume.
 *
 * @since 27/01/2018
 */
public class TestStreams {

    public static void main(String[] args) {
        final List<Integer> integers = Arrays.asList(1, 3, 2, 8, 5, 9, 10, 67, 54, 78);

        int result = integers.stream()
                             .filter(item -> item > 10)
                             .map(item -> item * 2)
                             .sorted()
                             .findFirst()
                             .orElse(-1);

        System.out.println("Finish!!: " + result);
    }
}
