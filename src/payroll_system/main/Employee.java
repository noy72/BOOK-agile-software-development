package payroll_system.main;

import payroll_system.main.affiliation.Affiliation;
import payroll_system.main.affiliation.NoAffiliation;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.method.PaymentMethod;
import payroll_system.main.schedule.PaymentSchedule;

import java.util.Calendar;

public class Employee {
    private int itsEmpId;
    private String itsName;
    private String itsAddress;
    private PaymentClassification itsPc;
    private PaymentSchedule itsPs;
    private PaymentMethod itsPm;
    private Affiliation itsAf;

    public Employee(int empId, String name, String address) {
        itsEmpId = empId;
        itsName = name;
        itsAddress = address;
        itsAf = new NoAffiliation();
    }

    public String GetName() {
        return itsName;
    }

    public String GetAddress() {
        return itsAddress;
    }

    public PaymentClassification GetClassification() {
        return itsPc;
    }

    public PaymentSchedule GetSchedule() {
        return itsPs;
    }

    public PaymentMethod GetMethod() {
        return itsPm;
    }

    public Affiliation GetAffiliation() {
        return itsAf;
    }

    public void SetName(String name) {
        itsName = name;
    }

    public void SetAddress(String address) {
        itsAddress = address;
    }

    public void SetClassification(PaymentClassification pc) {
        itsPc = pc;
    }

    public void SetSchedule(PaymentSchedule ps) {
        itsPs = ps;
    }

    public void SetMethod(PaymentMethod pm) {
        itsPm = pm;
    }

    public void SetAffiliation(Affiliation af) {
        itsAf = af;
    }

    public void Payday(Paycheck pc) {
        double grossPay = itsPc.CalculatePay(pc);
        double deductions = itsAf.CalculateDeductions(pc);
        double netPay = grossPay - deductions;
        pc.SetGrossPay(grossPay);
        pc.SetDeductions(deductions);
        pc.SetNetPay(netPay);
        itsPm.Pay(pc);
    }

    public boolean IsPayDate(Calendar payDate) {
        return itsPs.IsPayDate(payDate);
    }

    public Calendar GetPayPeriodStartDate(Calendar payDate) {
        return payDate;
    }
}
