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
                System.out.println("bill id is" + b.billId);
                System.out.println("name on bill is" + b.patientNameOnBill);
                System.out.println("amount of bill is" + b.amountOnBill);
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

    public String getNameOnBill()
    {
        return this.patientNameOnBill;
    }
}
