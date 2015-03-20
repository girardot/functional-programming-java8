package fr.xebia.java8.refactoring.step1;


import fr.xebia.java8.refactoring.data.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.math.BigDecimal.ONE;

public class BasicCollectionOperations {

    private static Map<String, BigDecimal> CURRENCIES_BY_ISOCODE = new HashMap<>();

    private static Map<Integer, Long> FIBONACCI_CACHE = new HashMap<>();

    static {
        CURRENCIES_BY_ISOCODE.put("USD", BigDecimal.valueOf(0.91));
        CURRENCIES_BY_ISOCODE.put("GBP", BigDecimal.valueOf(1.38));
        CURRENCIES_BY_ISOCODE.put("AUD", BigDecimal.valueOf(0.70));
        CURRENCIES_BY_ISOCODE.put("EUR", BigDecimal.valueOf(1));

        FIBONACCI_CACHE.put(0, 0L);
        FIBONACCI_CACHE.put(1, 1L);
        FIBONACCI_CACHE.put(2, 1L);
    }

    public static void resetPassword(List<User> users) {
        users.forEach(user -> user.password = null);
    }

    public static void removeExpiredUsers(List<User> users) {
        users.removeIf(User::isExpired);
    }

    public static void addOneDayToDates(List<LocalDate> localDates) {
        localDates.replaceAll(date -> date.plusDays(1));
    }

    public static Map<String, Integer> countWord(List<String> words) {
        Map<String, Integer> count = new HashMap<>();

        // words.forEach(s -> count.compute(s, (s1, integer) -> count.getOrDefault(s1, 0) + 1));
        words.forEach(s -> count.merge(s, 1, Integer::sum));

        return count;
    }

    public static BigDecimal exchangeRateWithEuro(String isoCode) {
        return CURRENCIES_BY_ISOCODE.getOrDefault(isoCode, ONE);
    }

    public static List<Long> fibonacci(int expectedNumberResult) {
        List<Long> result = new ArrayList<>(expectedNumberResult);

        for (int i = 1; i <= expectedNumberResult; i++) {
            result.add(fibonacciComputation(i));
        }
        return result;
    }

    private static long fibonacciComputation(int number) {
        return FIBONACCI_CACHE.computeIfAbsent(number, n -> fibonacciComputation(n - 1) + fibonacciComputation(n - 2));
    }

}
