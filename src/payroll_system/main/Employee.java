package payroll_system.main;

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
