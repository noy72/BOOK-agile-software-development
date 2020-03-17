package payroll_system.main.transaction.change;

import payroll_system.main.affiliation.Affiliation;
import payroll_system.main.affiliation.NoAffiliation;
import payroll_system.main.affiliation.UnionAffiliation;
import payroll_system.main.Employee;
import payroll_system.main.PayrollDatabase;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    void RecordMembership(Employee e) {
        Affiliation af = e.GetAffiliation();
        if (af instanceof UnionAffiliation) {
            UnionAffiliation uf = (UnionAffiliation) af;
            int memberId = uf.GetMemberId();
            PayrollDatabase.RemoveUnionMember(memberId);
        }
    }

    @Override
    Affiliation GetAffiliation() {
        return new NoAffiliation();
    }
}
