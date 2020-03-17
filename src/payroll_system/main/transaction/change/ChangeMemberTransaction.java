package payroll_system.main.transaction.change;

import payroll_system.affiliation.Affiliation;
import payroll_system.affiliation.UnionAffiliation;
import payroll_system.main.Employee;
import payroll_system.main.PayrollDatabase;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
    private int itsMemberId;
    private double itsDues;

    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId);
        itsMemberId = memberId;
        itsDues = dues;
    }

    @Override
    void RecordMembership(Employee e) {
        PayrollDatabase.AddUnionMember(itsMemberId, e);
    }

    @Override
    Affiliation GetAffiliation() {
        return new UnionAffiliation(itsMemberId, itsDues);
    }
}
