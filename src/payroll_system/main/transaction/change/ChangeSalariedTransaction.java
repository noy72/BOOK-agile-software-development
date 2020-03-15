package payroll_system.main.transaction.change;


import payroll_system.main.classification.HourlyClassification;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.classification.SalariedClassification;
import payroll_system.main.schedule.MonthlySchedule;
import payroll_system.main.schedule.PaymentSchedule;
import payroll_system.main.schedule.WeeklySchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    private double itsSalary;

    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        itsSalary = salary;
    }

    @Override
    PaymentSchedule GetSchedule() {
        return new MonthlySchedule();
    }

    @Override
    PaymentClassification GetClassification() {
        return new SalariedClassification(itsSalary);
    }
}
