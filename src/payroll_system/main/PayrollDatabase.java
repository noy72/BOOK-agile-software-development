package payroll_system.main;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
    private static Map<Integer, Employee> itsEmployees = new HashMap<>();
    private static Map<Integer, Employee> itsUnionMember = new HashMap<>();

    public static void AddEmployee(int empId, Employee e) {
        itsEmployees.put(empId, e);
    }

    public static Employee GetEmployee(int empId) {
        return itsEmployees.get(empId);
    }

    public static void DeleteEmployee(int itsEmpId) {
        itsEmployees.remove(itsEmpId);
    }

    public static void Clear() {
        itsEmployees.clear();
    }

    public static void AddUnionMember(int memberId, Employee e) {
        itsUnionMember.put(memberId, e);
    }

    public static Employee GetUnionMember(int memberId) {
        return itsUnionMember.get(memberId);
    }
}
