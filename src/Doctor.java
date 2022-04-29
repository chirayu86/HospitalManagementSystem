public class Doctor extends User {
    private String name;
    private String id;
    private String department;
    private String specialization;
    private String docPassword ;


    Doctor(String name,String id,String dept,String spec,String password)
    {
        this.name = name;
        this.id = id;
        this.department = dept;
        this.specialization = spec;
        this.docPassword = password;
    }



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
   public void PrescribePatient(String nameOfPatient,String[] testsId,String[] medicineName)
   {
       int flag = 0;
       for (Patient P : DataBase.patients)
       {

           if(P.getName().equals(nameOfPatient))
           {
               Prescription p = new Prescription(this.name,nameOfPatient);
               DataBase.prescriptionsList.add(p);
               for(String m : medicineName)
               {
                   if(DataBase.checkIfMedicineInDatabase(m))
                   {
                      p.addMedicine(DataBase.getMedicineFromDatabase(m));
                   }
                   else
                   {
                       System.out.println("medicine does not exist in database" +m);
                   }
               }
               for(String t : testsId)
               {
                   if(DataBase.checkIfTestAvailableInHospital(t))
                   {
                       p.addTest(DataBase.getTestFromDatabase(t));
                   }
                   else
                   {
                       System.out.println("test does not exist in database" +t);
                   }
               }
               flag = 1;
           }
       }
       if(flag == 0)
       {
           System.out.println("patient not found");
       }

   }



   public void admitPatient(String name,String contactInfo)
   {
       if(DataBase.checkIfPatientInDatabase(name))
       {
           Patient newPat = DataBase.getPatientFromDatabase(name);
           AdmittedPatient patient = new AdmittedPatient(newPat.getName(),newPat.getPatientAge(),newPat.getPatientInDate(),newPat.getPatientId(),this.name,contactInfo);
           DataBase.admittedPatientList.add(patient);
           int emptyRoom = DataBase.countEmptyRoom();
               if(emptyRoom>0)
               {
                   for(Room r : DataBase.roomList)
                   {if(r.getEmpty()) {
                       patient.setRoom(r);
                       r.setEmpty(false);
                       break;
                   }
                   }
                   System.out.println("patient has been alloted room");
                   System.out.println("remaining rooms are " +DataBase.countEmptyRoom());
               }
               else
               { System.out.println("all rooms are filled");}
           }
           else
           { System.out.println("patient does not exist");}

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
