package com.justbelieveinmyself.javalang.Interfaces;

public class Student implements Person, Named{ //two the same default methods
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getName());
    }
    @Override
    public String getName(){ //need to implement method to choose which one we will use.
        return Person.super.getName();
    }
    //Can the Student class inherit the default method from the Person interface?
    //This might be reasonable, but the Java designers decided in favor of
    //uniformity. It doesn’t matter how two interfaces conflict. If at least one
    //interface provides an implementation, the compiler reports an error, and the
    //programmer must resolve the ambiguity.
}
