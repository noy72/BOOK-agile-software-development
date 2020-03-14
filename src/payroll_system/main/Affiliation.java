package payroll_system.main;

public interface Affiliation {
    void AddServiceCharge(long date, double amount);
    double GetServiceCharge(long date);
}
