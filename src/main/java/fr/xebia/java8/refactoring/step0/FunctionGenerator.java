package fr.xebia.java8.refactoring.step0;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class FunctionGenerator {

    public static Function<Integer, Integer> plusOneFunction() {
        return value -> value + 1;
    }

    public static Predicate<Integer> evenNumberPredicate() {
        return integer -> integer % 2 == 0;
    }

    public static Consumer<int[]> incrementArrayValueConsumer() {
        return arrayValues -> {
            for (int i = 0; i < arrayValues.length; i++) {
                arrayValues[i] = arrayValues[i] + 1;
            }
        };
    }

    public static Supplier<Integer> todaySupplier() {
        return () -> LocalDate.now().get(ChronoField.DAY_OF_MONTH);
    }

    public static BiFunction<String, Integer, String> concatAsStringFunction() {
        return (firstValue, secondValue) -> firstValue + " " + secondValue;
    }

    // BinaryOperator is BiFunction with same generic type
    public static BinaryOperator<Integer> sumFunction() {
        return Integer::sum;
    }

    public static Consumer<String> addToListConsumer(List<String> list) {
        return list::add;
    }

    public static Function<String, BigDecimal> stringToBiDecimalFunction() {
        return BigDecimal::new;
    }

    // Comparator is also a FunctionalInterface that can be replaced by lambda syntax
    public static Comparator<String> byStringLengthComparator() {
        return (o1, o2) -> Integer.compare(o1.length(), o2.length());
    }
}
