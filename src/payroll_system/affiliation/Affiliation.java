package payroll_system.affiliation;

public interface Affiliation {
    void AddServiceCharge(long date, double amount);
    double GetServiceCharge(long date);
}
