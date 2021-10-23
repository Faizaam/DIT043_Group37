package bussinessLogic.Employee;

import java.util.ArrayList;
import utility.Calculate;
import utility.Utilities;

import java.util.Comparator;

class SortByGrossSalary implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return Double.compare(a.getGrossSalary(), b.getGrossSalary());
    }
}

public class Staff {

    ArrayList<Employee> employeeList;

    public Staff() {
        employeeList = new ArrayList<>();
    }

    public void checkEmployeeList() throws Exception {
        if (employeeList.isEmpty()) {
            throw new Exception("No employees registered yet.");
        }
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        this.employeeList.add(new Employee(employeeID, employeeName, grossSalary));
        System.out.println(employeeList.get(0));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree)
            throws Exception {
        this.employeeList.add(new Manager(employeeID, employeeName, grossSalary, degree));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept)
            throws Exception {
        this.employeeList.add(new Director(employeeID, employeeName, grossSalary, degree, dept));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        this.employeeList.add(new Intern(employeeID, employeeName, grossSalary, gpa));
        return "Employee " + employeeID + " was registered successfully.";
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        int index = employeeIDExists(empID);
        return employeeList.get(index).setEmployeeName(newName);
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        int index = employeeIDExists(empID);
        return employeeList.get(index).setGrossSalary(newSalary);
    }

    public int employeeIDExists(String employeeID) throws Exception {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).checkEmployeeId(employeeID)) {
                return i;
            }
        }
        throw new Exception("Employee " + employeeID + " was not registered yet.");
    }

    public String removeEmployee(String empID) throws Exception {
        int index = employeeIDExists(empID);
        employeeList.remove(index);
        return "Employee " + empID + " was successfully removed.";
    }

    public String printSortedEmployees() throws Exception {
        checkEmployeeList();
        employeeList.sort(new SortByGrossSalary());
        String s = System.lineSeparator();
        String print = "Employees sorted by gross salary (ascending order):" + s;
        print = print + Utilities.printList(employeeList);
        return print;
    }

    public String printEmployee(String employeeID) throws Exception {
        int index = employeeIDExists(employeeID);
        return employeeList.get(index).toString();
    }

    public String printAllEmployees() throws Exception {
        checkEmployeeList();
        String s = System.lineSeparator();
        String print = "All registered employees:" + s;
        print = print + Utilities.printList(employeeList);
        return print;
    }

    public double getNetSalary(String employeeID) throws Exception {
        int index = employeeIDExists(employeeID);
        double netIncome = employeeList.get(index).getNetIncome();
        return Calculate.truncateDouble(netIncome, 2);
    }

    public double getTotalNetSalary() throws Exception {
        checkEmployeeList();
        double totalNetSalary = 0.0;
        for (Employee employee : employeeList) {
            totalNetSalary = totalNetSalary + employee.getGrossSalary();
            Calculate.truncateDouble(totalNetSalary, 2);

        }
        return totalNetSalary;
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        int index = employeeIDExists(empID);
        Manager temp = (Manager) employeeList.get(index);
        temp.setDegree(newDegree);
        return "Employee " + empID + " was updated successfully.";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        int index = employeeIDExists(empID);
        Director temp = (Director) employeeList.get(index);
        temp.setDepartment(newDepartment);
        return "Employee " + empID + " was updated successfully.";
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        int index = employeeIDExists(empID);
        Employee employee = employeeList.get(index);
        String id = employee.getEmployeeID();
        String name = employee.getEmployeeName();
        double salary = employee.getBaseSalary();
        employeeList.remove(index);
        employeeList.add(new Manager(id, name, salary, degree));

        return "Employee " + empID + "Promoted Successfully";
    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        int index = employeeIDExists(empID);
        Employee employee = employeeList.get(index);
        String id = employee.getEmployeeID();
        String name = employee.getEmployeeName();
        double salary = employee.getBaseSalary();
        employeeList.remove(index);
        employeeList.add(new Director(id, name, salary, degree, department));
        return "Employee " + empID + "Promoted Successfully";
    }
}
