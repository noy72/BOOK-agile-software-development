package payroll_system.main.transaction;


import payroll_system.main.classification.HourlyClassification;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.schedule.PaymentSchedule;
import payroll_system.main.schedule.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    private double itsRate;

    public ChangeHourlyTransaction(int empId, double rate) {
        super(empId);
        itsRate = rate;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new WeeklySchedule();
    }

    @Override
    PaymentClassification GetClassification() {
        return new HourlyClassification(itsRate);
    }
}
