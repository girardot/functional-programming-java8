package fr.xebia.java8.refactoring.step3;


import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberUtils {

    private static Map<Integer, Long> fibonacciValues = new HashMap<>();

    static {
        fibonacciValues.put(0, 0L);
        fibonacciValues.put(1, 1L);
        fibonacciValues.put(2, 1L);
    }

    /**
     * Return the random 'number' int between 0 and 'number * 10'
     *
     * @param number
     * @param seed
     * @return
     */
    public static int[] generateRandom(int number, @Nullable Long seed) {
        Random random = getRandom(seed);
        return random.ints(0, number * 10).limit(number).toArray();
    }

    public static Map<Boolean, List<Integer>> splitEvenAndOddNumber(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.partitioningBy(n -> (n % 2) == 0));
    }

    public static List<Long> fibonacci(int expectedNumberResult) {
        return IntStream
                .rangeClosed(1, expectedNumberResult)
                .mapToLong(NumberUtils::fibonacciComputation)
                .mapToObj(Long::valueOf)
                .collect(Collectors.toList());
    }

    /**
     * @return Infinite stream who return each next number of fibonacci sequence
     */
    public static Stream<Long> fibonacciStream() {
        final AtomicInteger counter = new AtomicInteger(1);
        return Stream.generate(() -> fibonacciComputation(counter.getAndIncrement()));
    }

    private static long fibonacciComputation(int number) {
        return fibonacciValues.computeIfAbsent(number, newNumber -> fibonacciComputation(newNumber - 1) + fibonacciComputation(newNumber - 2));
    }

    private static Random getRandom(Long seed) {
        if (seed == null) {
            return new Random();
        } else {
            return new Random(seed);
        }
    }
}
