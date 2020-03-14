package payroll_system.main;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    private double itsSalary;

    public AddSalariedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        itsSalary = salary;
    }

    @Override
    public PaymentSchedule GetSchedule() {
        return new MonthlySchedule();
    }

    @Override
    public PaymentClassification GetClassification() {
        return new SalariedClassification(itsSalary);
    }
}
