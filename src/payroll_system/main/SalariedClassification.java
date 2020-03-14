package payroll_system.main;

import payroll_system.main.PaymentClassification;

public class SalariedClassification extends PaymentClassification {
    double itsSalary;

    public SalariedClassification(double salary) {
        itsSalary = salary;
    }
}
