package payroll_system.main;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double itsSalary;
    private double itsCommissionedRate;

    public AddCommissionedEmployee(int empId, String name, String address, double salary, double commissionedRate) {
        super(empId, name, address);
        itsSalary = salary;
        itsCommissionedRate = commissionedRate;
    }

    @Override
    public PaymentSchedule GetSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    public PaymentClassification GetClassification() {
        return new CommissionedClassification(itsSalary, itsCommissionedRate);
    }
}
