package com.justbelieveinmyself.javalang.Abstact;

public class Main {
    public static void main(String[] args) {
        var people = new Person[2];
        people[0] = new Employee("Vadim", 1000000, 2004, 5,11);
        people[1] = new Student("Vadim", "Programming engineer");
        for (Person person : people) {
            System.out.println(person.getName() + ", " + person.getDescription());
        }
    }
}
