package payroll_system.main.classification;

public class SalariedClassification extends PaymentClassification {
    double itsSalary;

    public SalariedClassification(double salary) {
        itsSalary = salary;
    }
}