package payroll_system.main.transaction;

import payroll_system.main.PayrollDatabase;

public class DeleteEmployeeTransaction implements Transaction {
    private int itsEmpId;

    public DeleteEmployeeTransaction(int empId) {
        itsEmpId = empId;
    }

    @Override
    public void Execute() {
        PayrollDatabase.DeleteEmployee(itsEmpId);
    }
}
