package com.justbelieveinmyself.javalang.ConstructorsInstanceofEqualsCasts;

public class ManagerTest {
    public static void main(String[] args) {
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15, 5000);
        var staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        for (Employee employee : staff) { //polymorphism
            System.out.println(employee.getSalary());
        }
        Manager manager = (Manager) staff[0]; //only explicit conversion

        Employee employee = new Manager("Carl Cracker", 80000, 1987, 12, 15, 5000);
        Employee employee1 = new Employee();
        manager.increaseSalary(1.0); //in super with double
        manager.increaseSalary(1);  //overload in subclass with int
        method1(employee); // Employee
        method1(employee1); // Employee
        method1(manager); // Manager but if remove overloading with manager we get 'Employee'

        // Manager fromEmployer = (Manager)staff[1]; ClassCastException
        if(staff[1] instanceof Manager){
            Manager man = (Manager) staff[1];
            man.setBonus(1000);
            // never true
        }
        if(staff[1] instanceof Manager man){ // called “pattern-matching”
            man.setBonus(1000);
            // never true but shorter (Java 16)
        }else{
            // man doesn't exist
        }
        //a useless instanceof pattern is an error:
        Manager manager1 = new Manager("Carl Cracker", 80000, 1987, 12, 15, 5000);
//        if(manager1 instanceof Employee man){ // error : of course is employee
//            System.out.println("hello"); // (manager1 instanceof Employee) is allowed, for backwards compatibility with Java 1.0.
//        }
        double bonus = staff[0] instanceof Manager man? man.getBonus() : 0; // useful

//        String description = switch(staff[0]){ //work on Java version 14+ (enhanced switch '->')
//            case Manager man -> "Manager.";
//            default -> "default";
//        };
        Employee eml1 = new Employee("Name", 100, 2000, 1, 1);
        Employee eml2 = new Employee("Name", 100, 2000, 1, 1);
        Employee eml3 = new Manager("Name", 100, 2000, 1, 1, 1);
        Object objEml = (Object) eml3;
        if(eml1.equals(objEml)){
            System.out.println("Cool");
        }else{
            System.out.println("Bad");
        }

    }
    static void method1(Manager manager){
        System.out.println("Manager");
    }
    static void method1(Employee employee){

        System.out.println("Employee");
    }
}
