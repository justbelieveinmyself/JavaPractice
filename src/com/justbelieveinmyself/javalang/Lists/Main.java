package com.justbelieveinmyself.javalang.Lists;

import com.justbelieveinmyself.javalang.Hashcode.Employee;

import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>(); //“diamond” syntax because the empty brackets <> resemble a diamond.
        ArrayList<Employee> staff1 = new ArrayList<Employee>();
        var staff2 = new ArrayList<Employee>(); // a good idea to use the var keyword to avoid duplicating the class name
        //var staff3 = new ArrayList<>(); // creates arraylist of objects

        staff.add(new Employee("Harry", 100, 2000, 1, 1));

        staff.ensureCapacity(50) ; // first 50 calls to add will not involve any costly reallocation

        System.out.println("Size= " +staff.size());

        staff.trimToSize(); //reduces capacity to its current size

        staff.set(0, new Employee("Dmitry", 100, 2000, 1, 1)); //equivalent staff[0] = dmitry;
        //staff.set(1, new Employee("Dmitry", 100, 2000, 1, 1)); //error: no element 1 yet (we can only replace elements)

        Employee e = staff.get(0);

        var arrayStaff = staff.toArray();
        System.out.println("arrayStaff[0]= " + arrayStaff[0]);

        Employee removed = staff.remove(0);
        // Inserting and removing elements is not terribly efficient. It is probably not
        // worth worrying about for small array lists. But if you store many elements
        // and frequently insert and remove in the middle of a collection, consider
        // using a linked list instead.

        staff.add(new Employee("Ilya", 100, 2000, 1, 1));
        System.out.println("Using enhanced for: ");
        for (Employee em : staff) {
            System.out.println(em);
        }

        //@SuppressWarnings("unchecked") use when you work with legacy code raw types array list (only when you sure that is legal)
        // ArrayList<Employee> resul = (ArrayList<Employee>) ArrayListLegacy;


    }
}
