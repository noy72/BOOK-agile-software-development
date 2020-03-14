package payroll_system.main.transaction;

import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.classification.SalariedClassification;
import payroll_system.main.schedule.MonthlySchedule;
import payroll_system.main.schedule.PaymentSchedule;

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
