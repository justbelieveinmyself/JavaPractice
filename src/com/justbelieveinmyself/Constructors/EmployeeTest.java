package com.justbelieveinmyself.Constructors;
//308 page about images <img src="doc-files/help.png" alt="Help image"/>
/**
 * This class tests work with the main method
 * @see Employee
 * Thank you for learning.
 * <img src="doc-files/help.png" alt="Help image"/>
 */
public class EmployeeTest {
    /**
     * This is description for main method. Thanks for watching.
     * @see Employee#getNewInstanse(Employee) - useless method btw 
     * @param args - arguments from command line.
     */
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee(null, 50000, 2002, 10, 2);
        staff[1] = new Employee("Ilya", 60000, 2004, 1, 21);
        staff[2] = new Employee("Vadim", 70000, 2003, 5, 12);
        Employee.getNewInstanse(staff[2]);
        System.out.println("id name salary hire_date");
        for(Employee e : staff){
            e.increaseSalary(0);
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary() + " " + e.getHireDate());
        }

    }
}
