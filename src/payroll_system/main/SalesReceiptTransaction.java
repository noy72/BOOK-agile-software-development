package payroll_system.main;

public class SalesReceiptTransaction implements Transaction {
    private long itsDate;
    private int itsAmount;
    private int itsEmpId;

    public SalesReceiptTransaction(long date, int amount, int empId) {
        itsDate = date;
        itsAmount = amount;
        itsEmpId = empId;
    }


    @Override
    public void Execute() {
        Employee e = PayrollDatabase.GetEmployee(itsEmpId);
        if (e != null) {
            PaymentClassification pc = e.GetClassification();
            if (pc instanceof CommissionedClassification) {
                CommissionClassification cc = (CommissionClassification) pc;
                cc.AddSalesReceipt(new SalesReceipt(itsDate, itsAmount));
            } else {
                throw new RuntimeException(
                        "Tried to add receipt to non-commissioned employee."
                );
            }
        } else {
            throw new RuntimeException("No such employee.");
        }
    }
}
