package payroll_system.main;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double itsSalary;

    public AddCommissionedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        itsSalary = salary;
    }

    @Override
    public PaymenSchedule GetSchedule() {
        return new CommissionedClassification(itsSalary);
    }

    @Override
    public PaymentClassification GetClassification() {
        return new BiweeklySchedule();
    }
}
