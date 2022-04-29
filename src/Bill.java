public class Bill
{
    private String billId;
    private String patientNameOnBill;
    private int amountOnBill;

    Bill(String id,String name,int amt)
    {
       this.billId = id;
       this.amountOnBill = amt;
       this.patientNameOnBill = name;
    }

    public  static void printBill(String patientName)
    {
        int flag = 0;
        if(DataBase.checkIfPatientInDatabase(patientName))
        {
        for(Bill b : DataBase.billList) {
            if (patientName.equals(b.patientNameOnBill)) {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.printf("%10s %20s %5s", "BILL ID", "NAME", "AMOUNT");
                System.out.println();
                System.out.printf("%10s %20s %5s", b.billId,b.patientNameOnBill,b.amountOnBill);
                flag = 1;
            }
        }

        }
        else
        {
            System.out.println("patient does not exist");
        }
        if(flag == 0)
        {
            System.out.println("bill not generated");
        }
    }

}
