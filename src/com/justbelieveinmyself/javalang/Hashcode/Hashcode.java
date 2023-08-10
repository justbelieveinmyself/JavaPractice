package com.justbelieveinmyself.javalang.Hashcode;


import java.util.Arrays;

public class Hashcode {
    public static void main(String[] args) {
        //hashCode
        String hello = "Hello world";
        System.out.println(hello.hashCode());

        Employee employee =  new Employee("Ilya", 60000, 2004, 1, 21);
        Employee employee1 =  new Employee("Ilya", 60000, 2004, 1, 21);
        Object objEmp = (Object) employee1;
        System.out.println("If objects equals");
        if(employee.equals(objEmp)) {
            System.out.print("Then they hashCode must be equals: ");
            System.out.print(employee.hashCode() + " ");
            System.out.println(objEmp.hashCode());
        }

        //Arrays.hashCode(array); for generate array hashcode

        double salary = 10;
        Double.hashCode(salary); //for primitive types

        //toString method
        System.out.println(employee.toString());
        Manager manager = new Manager("Carl Cracker", 80000, 1987, 12, 15, 5000);
        System.out.println(manager.toString());
        int[] array = new int[] {1, 2, 3, 4, 5};
        System.out.println(array.toString());
        System.out.println(Arrays.toString(array));
        //Arrays.deepToString()
    }
}
