public class Admin extends User {
    private String adminPassword = "123456#";

    public Bill generateBill(String patientName,int amount,String id)
    {
        Bill bill = new Bill(id,patientName,amount);
        DataBase.billList.add(bill);
        if(DataBase.checkIfPatientIsAdmitted(patientName)) {
            AdmittedPatient patient = DataBase.getAdmittedPatientFromDataBase(patientName);
            for (Room r : DataBase.roomList) {
                if (patient.getRoom().getRoomNo() == r.getRoomNo()) {
                    r.setEmpty(true);
                }
            }
            DataBase.admittedPatientList.remove(patient);
        }
        return bill;
    }
    public void addDoctor(String nAme,String dOcId,String dept,String spec,String password) {

        Doctor doctor = new Doctor(nAme, dOcId, dept, spec,password);
        DataBase.addToListDoctor(doctor);
    }
    public void addPatient(String nAme,String age,String dat,String id) {
        Patient patient = new Patient(nAme, age, dat, id);
        DataBase.addToListPatient(patient);
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
