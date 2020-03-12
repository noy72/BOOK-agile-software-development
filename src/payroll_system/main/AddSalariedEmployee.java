package payroll_system.main;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    private double itsSalary;

    public AddSalariedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        itsSalary = salary;
    }

    @Override
    public PaymenSchedule GetSchedule() {
        return new SalariedClassification(itsSalary);
    }

    @Override
    public PaymentClassification GetClassification() {
        return new MonthlySchedule();
    }
}
