package payroll_system.main.transaction;

import payroll_system.main.Employee;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.schedule.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    @Override
    void Change(Employee e) {
        e.SetSchedule(GetSchedule());
        e.SetClassification(GetClassification());
    }

    abstract PaymentSchedule GetSchedule();

    abstract PaymentClassification GetClassification();
}
