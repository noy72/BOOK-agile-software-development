package payroll_system.main.affiliation;

import payroll_system.main.Paycheck;

public class NoAffiliation implements Affiliation {
    @Override
    public double CalculateDeductions(Paycheck pc) {
        return 0;
    }
}
