import java.util.ArrayList;

public class Prescription {
    private String nameOnPrescription;
    private String testPrescribed;
    private ArrayList<String> medicines = new ArrayList<String>();

    Prescription(String name,String test)
    {
        this.nameOnPrescription = name;
        this.testPrescribed = test;
    }

    public void addMedicineToPrescription(String meds)
    {
       this.medicines.add(meds);
    }

    public void printTestAndPrescription()
    {
        System.out.println("name on prescription is " +this.nameOnPrescription);
        System.out.println("test prescribed to patient  " +this.testPrescribed);
        System.out.println("medicines prescribed are: ");
        try
        {
            for (String meds : medicines) {
                System.out.println(meds);
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("medicine list is empty");
        }

    }

    public String getNameOnPrescription()
    {
        return this.nameOnPrescription;
    }
}
