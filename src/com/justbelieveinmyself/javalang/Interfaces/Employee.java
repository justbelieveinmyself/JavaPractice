package com.justbelieveinmyself.javalang.Interfaces;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Employee implements Comparable<Employee>, Cloneable {
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
        this.name = name;
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
    public void increaseSalary(double percent) {
        double increase = salary * percent/100;
        salary += increase;
    }
    public String getName()
    {
        return name;
    }
    public LocalDate getHireDate() throws NullPointerException {
        return hireDate;
    }
    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null || otherObject.getClass() != this.getClass()) return false;
        Employee other = (Employee) otherObject;
        return this.name.equals(other.name) && this.salary == other.salary && this.hireDate.equals(other.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, name, hireDate);
    }
    @Override
    public String toString(){
        return getClass().getSimpleName()+"[name=" + name  + ", salary=" +  salary + ", hireDate=" + hireDate + "]";
    }
    @Override
    public int compareTo(Employee other){
        return Double.compare(this.salary, other.salary);
    }

    @Override
    public Employee clone() throws CloneNotSupportedException{ // throws exception. if it final u can catch this exception.
        Employee clone = (Employee) super.clone();
        // copy mutable state here, so the clone can't change the internals of the original
        // in our situation it is not necessary cause LocalDate is immutable object
        return clone;

    }
}
