package com.justbelieveinmyself.javalang.Hashcode;

public class Manager extends Employee {
    private int bonus = 100;
    public void setBonus(int bonus){
        this.bonus = bonus;
    }
    public int getBonus(){
        return bonus;
    }
    @Override
    public double getSalary(){
        return super.getSalary() + bonus; //private fields not available in subclasses
    }

    public void increaseSalary(int percent){
        System.out.println("from manager");
    }
    public Manager(String name, double salary, int year, int month, int day, int bonus){
        super(name, salary, year, month, day); //must be first statement
        this.bonus = bonus;
    }
    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false; // super.equals checked that this and otherObject belong to the same class
        Manager other = (Manager) otherObject;
        return this.bonus == other.bonus;
    }
    @Override
    public String toString(){
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
