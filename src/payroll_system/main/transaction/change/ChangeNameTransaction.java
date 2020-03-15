package payroll_system.main.transaction.change;

import payroll_system.main.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    private String itsName;

    public ChangeNameTransaction(int empId, String name) {
        super(empId);
        itsName = name;
    }

    @Override
    void Change(Employee e) {
        e.SetName(itsName);
    }
}
