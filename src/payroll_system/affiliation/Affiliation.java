package payroll_system.affiliation;

import payroll_system.main.Paycheck;

public interface Affiliation {
    double CalculateDeductions(Paycheck pc);
}
