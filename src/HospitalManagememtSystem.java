import java.util.Scanner;

public class HospitalManagememtSystem {

    Scanner sc = new Scanner(System.in);


    public void printMainMenu()
    {
        System.out.println("-----------------------------------------------------------------------------enter the type of user-----------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------------------------enter 1 for admin, 2 for doctor,3 for patient,4 to exit-----------------------------------------------------------------------");
    }

    public void printMenuForDoctorConsole()
    {
        System.out.println();
        System.out.println();
        System.out.println("--------------enter doctor menu choices------------------");
        System.out.println("1 to list patient details");
        System.out.println("2 to list specific patient ");
        System.out.println("3 to prescribe test to patient");
        System.out.println("4 to prescribe medicines only after test is prescribed");
        System.out.println("5 to  get prescription");
        System.out.println("6 to admit patient");
        System.out.println("7 to see details of admitted patients");
        System.out.println("8 to exit");
    }

    public  void printMenuForAdmin()
    {
        System.out.println();
        System.out.println();
        System.out.println("------------------enter admin menu choice-----------------------");
        System.out.println("1:add doctor");
        System.out.println("2:list doctor");
        System.out.println("3:add patient");
        System.out.println("4:list patient");
        System.out.println("5:generate bill");
      //  System.out.println("6:to allot room to patient(only if patient is admitted by a doctor)");
        System.out.println("6 to exit");
    }

    public void printMenuForPatient()
    {
        System.out.println();
        System.out.println();
        System.out.println("enter patient menu choice");
        System.out.println("1:pay bill");
        System.out.println("2.show prescription");
        System.out.println("3. to exit");
    }

    public void adminMenu(Admin admin) {
        int adminChoice = sc.nextInt();
        while (adminChoice < 6) {
            switch (adminChoice) {
                case 1:
                    String nAme, dOcId, dept, spec,pass;
                    System.out.println("enter name of doctor");
                    nAme = sc.next();
                    System.out.println("enter id");
                    dOcId = sc.next();
                    System.out.println("enter department");
                    dept = sc.next();
                    System.out.println("enter specialization");
                    spec = sc.next();
                    System.out.println("enter password for doctor");
                    pass = sc.next();
                    admin.addDoctor(nAme,dOcId,dept,spec,pass);
                    System.out.println("entered info successfully");
                    printMenuForAdmin();
                    adminChoice = sc.nextInt();
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %20s %5s %5s", "NAME", "ID", "DEPARTMENT", "SPECIALIZATION");
                    System.out.println();
                    DataBase.listDoctors();
                    printMenuForAdmin();
                    adminChoice = sc.nextInt();
                    break;
                case 3:
                    String patientName, dat, age, pid;
                    System.out.println("enter name of patient");
                    patientName= sc.next();
                    System.out.println("enter the age of the patient");
                    age = sc.next();
                    System.out.println("enter in date");
                    dat = sc.next();
                    System.out.println("enter id");
                    pid = sc.next();
                    admin.addPatient(patientName,age,dat,pid);
                    System.out.println("entered info successfully");
                    printMenuForAdmin();
                    adminChoice = sc.nextInt();
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %20s %5s %5s", "NAME", "ID", "Date", "Age");
                    System.out.println();
                    DataBase.listPatients();
                    printMenuForAdmin();
                    adminChoice = sc.nextInt();
                    break;
                case 5:
                    System.out.println("enter the name of patient");
                    String patientNameOnBill = sc.next();
                    if(DataBase.checkIfPatientInDatabase(patientNameOnBill)){
                    System.out.println("enter bill amount");
                    int amount = sc.nextInt();
                    System.out.println("enter bill ID");
                    String billId = sc.next();
                    admin.generateBill(patientNameOnBill, amount, billId);
                    System.out.println("bill generated successfully");}
                    else {
                        System.out.println("patient not found");
                    }
                    printMenuForAdmin();
                    adminChoice = sc.nextInt();
                    break;
                    default:
                    break;
            }


        }
    }

    public void doctorMenu(Doctor doc)
    {
        int doctorChoice = sc.nextInt();
        while(doctorChoice<8)
        {
            switch (doctorChoice)
            {
                case 1:
                    System.out.println("list of patients is");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %20s %5s %5s", "NAME", "ID", "Date", "Age");
                    System.out.println();
                    DataBase.listPatients();
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;
                case 2:
                    System.out.println("enter patient name");
                    String nameOfPatient = sc.next();
                    doc.showSpecificPatientInfo(nameOfPatient);
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;
                case 3:
                    System.out.println("enter patient name");
                    String nameForPrescription = sc.next();
                    if(DataBase.checkIfPatientInDatabase(nameForPrescription)) {
                        System.out.println("enter the number of tests");
                        int number = sc.nextInt();
                        String[] testID = new String[number];
                        int length = testID.length;
                        int i=0;
                        System.out.println("enter test ids");
                        while(i<length)
                        {
                            testID[i]=sc.next();
                            i++;
                        }
                        System.out.println("enter the number of medicine");
                        int numberMeds = sc.nextInt();
                        String[] medID = new String[numberMeds];
                        int lengthMed = medID.length;
                        int j=0;
                        System.out.println("enter the medicine name");
                        while(j<lengthMed)
                        {
                            medID[j]=sc.next();
                            j++;
                        }
                        doc.PrescribePatient(nameForPrescription,testID,medID);
                    }
                    else
                    {
                        System.out.println("patient does not exist");
                    }
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;
                case 5:
                    System.out.println("enter patient name to get prescription");
                    String nameToGetPrescription = sc.next();
                    Prescription.printTestAndPrescription(nameToGetPrescription);
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;
                case 6:
                    System.out.println("enter the name of the patient you would like to admit");
                    String nameToAdmit = sc.next();
                    System.out.println("enter contact no of patient");
                    String contactInfo = sc.next();
                    doc.admitPatient(nameToAdmit,contactInfo);
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;
                case 7:
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %20s %5s %5s %5s", "NAME", "ID", "Date", "Age","Room no");
                    System.out.println();
                    DataBase.listAdmittedPatients();
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
            }
        }
    }

    public void patientMenu(Patient p)
    {
        int patientChoice = sc.nextInt();
        do {
            switch (patientChoice) {
                case 1:
                    Bill.printBill(p.getName());
                    printMenuForPatient();
                    patientChoice = sc.nextInt();
                    break;
                case 2:
                   Prescription.printTestAndPrescription(p.getName());
                    printMenuForPatient();
                    patientChoice = sc.nextInt();
                    break;
                default:
                    System.out.println("wrong choice");
            }
        }while(patientChoice<3);

    }
    public static void main(String[] args) {
        DataBase sampleData = new DataBase();
        sampleData.SampleDoctorList();
        HospitalManagememtSystem hms = new HospitalManagememtSystem();
        sampleData.SamplePatientList();
        sampleData.sampleRoomList();
        sampleData.SampleTestList();
        sampleData.SampleMedicineList();
        Scanner sc = new Scanner(System.in);
        hms.printMainMenu();
        int choice = sc.nextInt();
        do {
            switch (choice)
            {
                case 1:
                    User user = new Admin();
                    System.out.println("enter admin password");
                    user.login(sc.next());
                    hms.printMenuForAdmin();
                    hms.adminMenu((Admin) user);
                    hms.printMainMenu();
                    choice = sc.nextInt();
                    break;
                case 2:
                    System.out.println("enter the name of the doctor");
                    String nameOfDoctorForLogin = sc.next();
                    User doctor = DataBase.getDoctorFromDataBase(nameOfDoctorForLogin);
                    System.out.println("enter doctor password");
                    try {
                        doctor.login(sc.next());
                    }
                    catch(NullPointerException e)
                    {
                        System.out.println("no such account exists");
                        hms.printMainMenu();
                        choice = sc.nextInt();
                        break;
                    }
                    hms.printMenuForDoctorConsole();
                    hms.doctorMenu((Doctor) doctor);
                    hms.printMainMenu();
                    choice = sc.nextInt();
                    break;
                case 3:
                    System.out.println("name of patient");
                    String pname = sc.next();
                    User userPatient = DataBase.getPatientFromDatabase(pname);
                    try {
                        userPatient.login(pname);
                    }catch (NullPointerException e)
                    {
                        System.out.println("no such patient exists");
                        hms.printMainMenu();
                        choice = sc.nextInt();
                        break;
                    }
                    hms.printMenuForPatient();
                    hms.patientMenu((Patient) userPatient);
                    hms.printMainMenu();
                    choice = sc.nextInt();
                    break;
                default:
                    System.out.println("wrong choice");
            }
        }while(choice<4);


    }
}
