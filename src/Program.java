import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.println("Bem vindo - Quantos funcionarios serão Registrados:");

        int n_func = sc.nextInt();

        for(int i=0; i<n_func; i++) {

            System.out.println();
            System.out.println("Employee #"+ (i+1) +":");
            System.out.println("Id: ");
            Integer id = sc.nextInt();

            while (hasId(list,id)) {
                System.out.println("Id already taken, please try again:");
                id = sc.nextInt();

            }

            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.println();
        System.out.println("Entre the employee id that will have salary increase:");
        int idsalary = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id does not exist! ");
        }
        else {
            System.out.println("Enter the percentage: ");
            double percent = sc.nextDouble();

            emp.increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of Employees: ");
        for (Employee e : list) {
            System.out.println(e);
        }
        sc.close();
    }

    public static Integer position(List<Employee> list, int id){
        for(int i=0; i< list.size(); i++) {
            if (list.get(i).getId()== id){
                return i;
            }
        }
        return null;
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
                return emp != null;
    }
}