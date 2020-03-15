package payroll_system.main;

import payroll_system.affiliation.Affiliation;
import payroll_system.main.classification.PaymentClassification;
import payroll_system.main.method.PaymentMethod;
import payroll_system.main.schedule.PaymentSchedule;

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

}
