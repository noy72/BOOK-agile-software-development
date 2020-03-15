package payroll_system.main.transaction.add;

import payroll_system.main.classification.CommissionedClassification;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.schedule.BiweeklySchedule;
import payroll_system.main.schedule.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double itsSalary;
    private double itsCommissionedRate;

    public AddCommissionedEmployee(int empId, String name, String address, double salary, double commissionedRate) {
        super(empId, name, address);
        itsSalary = salary;
        itsCommissionedRate = commissionedRate;
    }

    @Override
    public PaymentSchedule GetSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    public PaymentClassification GetClassification() {
        return new CommissionedClassification(itsSalary, itsCommissionedRate);
    }
}
