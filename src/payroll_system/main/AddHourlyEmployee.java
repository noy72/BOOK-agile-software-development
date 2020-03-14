package payroll_system.main;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private double itsHourlyRate;

    public AddHourlyEmployee(int empId, String name, String address, double hourlyRate) {
        super(empId, name, address);
        itsHourlyRate = hourlyRate;
    }

    @Override
    public PaymentSchedule GetSchedule() {
        return new WeeklySchedule();
    }

    @Override
    public PaymentClassification GetClassification() {
        return new HourlyClassification(itsHourlyRate);
    }
}
