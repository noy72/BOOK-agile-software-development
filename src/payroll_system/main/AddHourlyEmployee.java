package payroll_system.main;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private double itsSalary;

    public AddHourlyEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        itsSalary = salary;
    }

    @Override
    public PaymenSchedule GetSchedule() {
        return new HourlyClassification(itsSalary);
    }

    @Override
    public PaymentClassification GetClassification() {
        return new WeeklySchedule();
    }
}
