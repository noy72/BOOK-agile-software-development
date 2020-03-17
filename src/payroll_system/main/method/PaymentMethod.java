package payroll_system.main.method;

import payroll_system.main.Paycheck;

public interface PaymentMethod {
    void Pay(Paycheck pc);
}
