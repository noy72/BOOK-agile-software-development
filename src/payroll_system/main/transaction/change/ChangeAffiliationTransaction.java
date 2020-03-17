package payroll_system.main.transaction.change;

import payroll_system.main.affiliation.Affiliation;
import payroll_system.main.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    void Change(Employee e) {
        RecordMembership(e);
        e.SetAffiliation(GetAffiliation());
    }

    abstract void RecordMembership(Employee e);

    abstract Affiliation GetAffiliation();
}
