package payroll_system.main.classification;

public class CommissionedClassification extends PaymentClassification {
    private double itsSalary;
    private double itsRate;

    public CommissionedClassification(double salary, double rate) {
        super();
        itsSalary = salary;
        itsRate = rate;
    }

    public double GetSalary() {
        return itsSalary;
    }

    public double GetRate() {
        return itsRate;
    }
}
