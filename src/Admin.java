public class Admin extends User {
    private String adminPassword = "123456#";

    public Bill generateBill(String patientName,int amount,String id)
    {
        Bill bill = new Bill(id,patientName,amount);
        DataBase.billList.add(bill);
        return bill;

    }
    public Doctor addDoctor(String nAme,String dOcId,String dept,String spec) {

        Doctor doctor = new Doctor(nAme, dOcId, dept, spec);
        return doctor;
    }
    public Patient addPatient(String nAme,String age,String dat,String id) {
        Patient patient = new Patient(nAme, age, dat, id);
        return patient;
    }

    public void listDoctors()
    {
        for(Doctor d : DataBase.doctors)
        {
            d.showInfoDoctor();
        }
    }
    public void listPatients()
    {
        for(Patient p : DataBase.patients)
        {
            p.showInfo();
        }
    }
    public void login(String password)
    {

        if(password.equals(adminPassword))
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
