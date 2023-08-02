package com.justbelieveinmyself.Constructors;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

/**
 * A class to store data about employees.
 * @see <a href="https://vk.com/justbeliveinmyself">Vadim Karpenko VK</a>
 * @version 1.1
 * @author justbelieveinmyself
 */
public class Employee {
    /**
     * Useless main, but we can run here a unit tests.
     * @param args - arguments from command line.
     */
    public static void main(String[] args) {
        //unit tests
    }

    /**
     * int field stored the id (private)
     */
    private int id;
    private static int nextId = 1;
    private double salary;
    private final String name; // we cannot change reference to the object after first set
    private static Random generator = new Random();
    private LocalDate hireDate;

    static{
        nextId = generator.nextInt(1000);
    }
    { //usually its never necessary
        id = nextId++;
    }
    public Employee(){
        name = "";
    } // no argument constructor
    public Employee(String name, double salary, int year, int month, int day){
//        if(name != null) {
//            this.name = name;
//        }
//        else{
//            this.name = "unknown";
//        }
//        this.name = Objects.requireNonNull(name, "Name cannot be null"); //will throw exception with description
//        id = nextId++;
        this.name = Objects.requireNonNullElse(name, "unknown");
        this.salary = salary;
        this.hireDate = LocalDate.of(year, month, day);
    }
    public Employee(String name, double salary, LocalDate hireDate){
        this(name, salary, hireDate.getYear(), hireDate.getMonthValue(), hireDate.getDayOfMonth());
    }
    public static void getNewInstanse(Employee old){
        old.increaseSalary(10); //it will work
        old = new Employee("test", 1,1,1,1); // a method cannot make an object parameter refer to a new object
    }
    public int getId(){
        return id;
    }
    public double getSalary()
    {
        return salary;
    }
    public void increaseSalary(double percent)
    {
        double increase = salary * percent/100;
        salary += increase;
    }

    /**
     * Accessor method to the private name field
     * @return String name of employee
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor method to the private hire date field
     * @return hire date employee
     * @throws NullPointerException when using constructor with no arguments
     */
    public LocalDate getHireDate() throws NullPointerException
    {
        return hireDate;
    }
    public boolean equals(Employee other)
    {
        return name.equals(other.name); // we can access to private field
    }
}
