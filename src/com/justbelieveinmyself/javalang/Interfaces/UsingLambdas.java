package com.justbelieveinmyself.javalang.Interfaces;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

public class UsingLambdas {
    String text1 = "123";
//    public static void repeat(String text, int count)
//    {
//        for (int i = 1; i <= count; i++)
//        {
//            ActionListener listener = event ->
//            {
//                String text1 = "hello"; // The body of a lambda expression has the same scope as a nested block
//                System.out.println(i + ": " + text); // closure (замыкание - свободная переменная в лямбде)
//                // ERROR: Cannot refer to changing i
//                // local variables referenced from a lambda expression must be final or effectively final
//            };
//            new Timer(1000, listener).start();
//        }
//    }

    public static void main(String[] args) {
        String[] strings = new String[] {"Ai","Dmitry","Ilya","Alex","Vadim","Danil","Julia","Elza"};
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, (String first, String second) -> second.length()-first.length()); //using functional interface
        System.out.println(Arrays.toString(strings));
        Timer timer = new Timer(1000,event -> System.out.println("The time is " + new Date())); //using functional interface
        timer.start();
        JOptionPane.showConfirmDialog(null, "Hello, do u want to close app?");
        //System.exit(0);
        List<String> stringList = new ArrayList<>(Arrays.stream(strings).toList());
        stringList.add(null);
        //lambda
        stringList.removeIf(s -> s == null); //Predicate func interface
        //method ref
//        stringList.removeIf(Objects::isNull);
        for (String s : stringList) {
            System.out.println(s);
        }
        LocalDate day = null;
        LocalDate hireDay = Objects.requireNonNullElseGet(day, () -> LocalDate.of(1970, 1, 1)); //Supplier
        new Thread(() -> System.out.println("jekkii")).start();
        Runnable task = System.out::println;
        task.run();
        Arrays.sort(strings, String::compareToIgnoreCase);
//        repeat(4, () -> System.out.println("hello world"));

        repeat(9, i -> System.out.println("Countdown: " + (9-i)));
        Employee[] employees = new Employee[]{
                new Employee("Vadim", 1500, 1, 1, 1),
                new Employee("Vadim", 100, 1, 1, 1),
                new Employee("Danil", 100, 1, 1, 1),
                new Employee(null, 100, 1, 1, 1),
                new Employee("Kiril", 100, 1, 1, 1),
                new Employee("Kiril", 1040, 1, 1, 1)

        };
        //Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()));
        Arrays.sort(employees, Comparator.comparing(Employee::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
        //if some employees don't have name(null) don't throw a null pointer exception
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void repeat(int i, Runnable action) {
        for (int j = 0; j < i; j++) {
            action.run();
        }
    }
    private static void repeat(int i, IntConsumer action){
        for (int j = 0; j < i; j++) {
            action.accept(j);
        }
    }
}
