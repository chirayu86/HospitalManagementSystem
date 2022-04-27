public class Doctor extends User {
    private String name;
    private String id;
    private String department;
    private String specialization;

    private String docPassword = "1234";

    //member functions and overloaded constructor
    Doctor(String name,String id,String dept,String spec)
    {
        this.name = name;
        this.id = id;
        this.department = dept;
        this.specialization = spec;
    }
    public Doctor(){}


    public String getDocName()
    {
        return this.name;
    }
    public void showInfoDoctor()
    {

        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %5s %5s", this.name,this.id,this.department,this.specialization);
        System.out.println();

    }


   public void showSpecificPatientInfo(String name) {

       System.out.println("-----------------------------------------------------------------------------");
       System.out.printf("%10s %20s %5s %5s", "NAME", "ID", "Date", "Age");
       System.out.println();
       for (Patient p : DataBase.patients) {
           if (p.getName().equals(name)) {
               p.showInfo();
           }
       }

   }
   public void PrescribePatient(String nameOfPatient,String test)
   {
       int flag = 0;
       for (Patient P : DataBase.patients)
       {

           if(P.getName().equals(nameOfPatient))
           {
               Prescription p = new Prescription(nameOfPatient,test);
               DataBase.prescriptionsList.add(p);
               System.out.println("---------------test prescribed successfully--------------------");
               flag = 1;
               break;
           }
       }
       if(flag == 0)
       {
           System.out.println("patient not found");
       }

   }

   public void prescribeMedicines(String nameOfPatient,String arr[])
   {

          for(Prescription P : DataBase.prescriptionsList)
               {
                   if(P.getNameOnPrescription().equals(nameOfPatient))
                   {

                       for(int i=0;i< arr.length;i++)
                       {
                           P.addMedicineToPrescription(arr[i]);

                       }
                   }
       }


   }
   public void getPrescribedMedicines(String patientName)
   {
       int flag = 0;
       for(Prescription P : DataBase.prescriptionsList)
       {
           if(P.getNameOnPrescription().equals(patientName))
           {
              P.printTestAndPrescription();
              flag = 1;
           }
       }
       if(flag == 0)
       {
           System.out.println("prescription not found");
       }
   }
    public void login(String password)
    {

       if(password.equals(docPassword))
       {
           System.out.println("login successful");
       }
       else
       {
           System.out.println("wrong password exiting system");
           System.exit(0);
       }

    }
}
