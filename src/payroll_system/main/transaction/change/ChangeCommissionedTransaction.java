package payroll_system.main.transaction.change;


import payroll_system.main.classification.CommissionedClassification;
import payroll_system.main.classification.HourlyClassification;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.schedule.BiweeklySchedule;
import payroll_system.main.schedule.PaymentSchedule;
import payroll_system.main.schedule.WeeklySchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
    private double itsSalary;
    private double itsRate;

    public ChangeCommissionedTransaction(int empId, double salary, double rate) {
        super(empId);
        itsSalary = salary;
        itsRate = rate;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    PaymentClassification GetClassification() {
        return new CommissionedClassification(itsSalary, itsRate);
    }
}
