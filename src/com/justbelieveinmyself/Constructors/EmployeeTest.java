package Constructors;

public class EmployeeTest {
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
