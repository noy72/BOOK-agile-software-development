package payroll_system.main.transaction;

import payroll_system.main.classification.HourlyClassification;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.schedule.PaymentSchedule;
import payroll_system.main.schedule.WeeklySchedule;

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
