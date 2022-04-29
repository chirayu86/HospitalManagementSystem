import java.util.ArrayList;

public class Prescription {
    private String doctorNameWhoPrescribed;
    private String nameOnPrescription;

    //private String Symptoms;

    private ArrayList<Test> testsPrescribed = new ArrayList<Test>();

    private ArrayList<Medicine> medicines = new ArrayList<Medicine>();

    Prescription(String docName,String name)
    {
        this.doctorNameWhoPrescribed = docName;
        this.nameOnPrescription = name;

    }

    public static void printTestAndPrescription(String patientName)
    {
        for(Prescription p : DataBase.prescriptionsList)
        {
            if(p.nameOnPrescription.equals(patientName))
            {
                System.out.println("the prescription for "+patientName);
                System.out.println("the name of prescribing doctor is  " +p.doctorNameWhoPrescribed);
                System.out.println("the test prescribed are");
                for(Test t : p.testsPrescribed)
                {
                    t.showInfo();
                    System.out.println();
                }
                System.out.println(" the medicine prescribed are");
                for(Medicine m : p.medicines)
                {
                    m.showInfo();
                    System.out.println();
                }
            }
            else
            {
                System.out.println("prescription not found");
            }
        }


    }

    public void addMedicine(Medicine m)
    {
        this.medicines.add(m);
    }
    public void addTest(Test t)
    {
        this.testsPrescribed.add(t);
    }
   // public String getNameOnPrescription(){return this.nameOnPrescription;}
}
