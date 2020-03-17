package payroll_system.main.transaction;

import payroll_system.main.affiliation.Affiliation;
import payroll_system.main.affiliation.UnionAffiliation;
import payroll_system.main.PayrollDatabase;
import payroll_system.main.Employee;

public class ServiceChargeTransaction implements Transaction {
    private int itsMemberId;
    private long itsDate;
    private double itsAmount;

    public ServiceChargeTransaction(int memberId, long date, double amount) {
        itsMemberId = memberId;
        itsDate = date;
        itsAmount = amount;
    }

    @Override
    public void Execute() {
        Employee e = PayrollDatabase.GetUnionMember(itsMemberId);
        Affiliation af = e.GetAffiliation();
        if (af instanceof UnionAffiliation) {
            UnionAffiliation uaf = (UnionAffiliation) af;
            uaf.AddServiceCharge(itsDate, itsAmount);
        }
    }
}
