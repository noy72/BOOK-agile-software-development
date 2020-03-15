package payroll_system.main.transaction.add;

import payroll_system.main.*;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.Employee;
import payroll_system.main.method.HoldMethod;
import payroll_system.main.method.PaymentMethod;
import payroll_system.main.schedule.PaymentSchedule;
import payroll_system.main.transaction.Transaction;

public abstract class AddEmployeeTransaction implements Transaction {
    private int itsEmpId;
    private String itsName;
    private String itsAddress;

    public AddEmployeeTransaction(int empId, String name, String address) {
        itsEmpId = empId;
        itsName = name;
        itsAddress = address;
    }

    public void Execute() {
        PaymentClassification pc = GetClassification();
        PaymentSchedule ps = GetSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(itsEmpId, itsName, itsAddress);
        e.SetClassification(pc);
        e.SetSchedule(ps);
        e.SetMethod(pm);
        PayrollDatabase.AddEmployee(itsEmpId, e);
    }

    public abstract PaymentSchedule GetSchedule();

    public abstract PaymentClassification GetClassification();
}
