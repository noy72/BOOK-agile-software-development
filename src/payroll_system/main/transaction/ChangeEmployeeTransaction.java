package payroll_system.main.transaction;

import payroll_system.main.Employee;
import payroll_system.main.PayrollDatabase;

public abstract class ChangeEmployeeTransaction implements Transaction {
    private int itsEmpId;

    public ChangeEmployeeTransaction(int empId) {
        itsEmpId = empId;
    }

    public void Execute() {
        Employee e = PayrollDatabase.GetEmployee(itsEmpId);
        if (e != null) {
            Change(e);
        }
    }

    abstract void Change(Employee e);
}
