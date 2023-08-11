package com.justbelieveinmyself.javalang.Interfaces;




import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args) {
        Employee employee = new Employee("V", 100, 1, 1, 1);
        Employee employee1 = new Employee("D", 150, 1, 1, 1);
        Employee employee2 = new Employee("I", 50, 1, 1, 1);
        System.out.println(employee.compareTo(employee1));
        //compareTo method should be compatible with the equals method.

//        Student[] students = new Student[2];
//        students[0] = new Student("V", "prog");
//        students[1] = new Student("Y", "prog");
//        Arrays.sort(students); //exception: cannot be cast to class java.lang.Comparable

        Employee[] employees = new Employee[3];
        employees[0] = employee;
        employees[1] = employee1;
        employees[2] = employee2;
        Arrays.sort(employees);
        for (Employee e : employees) {
            System.out.println(e.getName()  + " " + e.getSalary());
        }
        System.out.println("Try with manager:");
        Manager manager = new Manager("A", 200, 1, 1, 1, 10);
        employees[0] = manager;
        Arrays.sort(employees);
        for (Employee e : employees) {
            System.out.println(e.getName()  + " " + e.getSalary());
        }

        //If subclasses have different notions of comparison, then you should outlaw
        //comparison of objects that belong to different classes. Each compareTo
        //method should start out with the test:
        //if (getClass() != other.getClass()) throw new ClassCastException();


    }

}
