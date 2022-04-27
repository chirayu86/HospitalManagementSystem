import java.util.Scanner;

public class HospitalManagememtSystem {

    Scanner sc = new Scanner(System.in);
    DataBase newdata = new DataBase();
    Admin admin = new Admin();
    Doctor doc = new Doctor();

   // Patient patient = new Patient();

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
        System.out.println("2 to list  specific patient ");
        System.out.println("3 to recommend test");
        System.out.println("4 to prescribe medicines only after test is prescribed");
        System.out.println("5 to  get prescription");
        System.out.println("6 to exit");
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

    public void adminMenu() {
        int adminChoice = sc.nextInt();
        while (adminChoice < 6) {
            switch (adminChoice) {
                case 1:
                    String nAme, dOcId, dept, spec;
                    System.out.println("enter name of doctor");
                    nAme = sc.next();
                    System.out.println("enter id");
                    dOcId = sc.next();
                    System.out.println("enter department");
                    dept = sc.next();
                    System.out.println("enter specialization");
                    spec = sc.next();
                    newdata.addToListDoctor(admin.addDoctor(nAme, dOcId, dept, spec));
                    System.out.println("entered info successfully");
                    printMenuForAdmin();
                    adminChoice = sc.nextInt();
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %20s %5s %5s", "NAME", "ID", "DEPARTMENT", "SPECIALIZATION");
                    System.out.println();
                    admin.listDoctors();
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
                    newdata.addToListPatient(admin.addPatient(patientName, age, dat, pid));
                    System.out.println("entered info successfully");
                    printMenuForAdmin();
                    adminChoice = sc.nextInt();
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %20s %5s %5s", "NAME", "ID", "Date", "Age");
                    System.out.println();
                    admin.listPatients();
                    printMenuForAdmin();
                    adminChoice = sc.nextInt();
                    break;
                case 5:
                    System.out.println("enter the name of patient");
                    String patientNameOnBill = sc.next();
                    if(newdata.checkIfPatientInDatabase(patientNameOnBill)){
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

    public void doctorMenu()
    {
        int doctorChoice = sc.nextInt();
        while(doctorChoice<6)
        {
            switch (doctorChoice)
            {
                case 1:
                    System.out.println("list of patients is");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %20s %5s %5s", "NAME", "ID", "Date", "Age");
                    System.out.println();
                    admin.listPatients();
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;
                case 2:
                    System.out.println("enter patient name");
                    String nameOfPatient = sc.next();
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %20s %5s %5s", "NAME", "ID", "Date", "Age");
                    System.out.println();
                    doc.showSpecificPatientInfo(nameOfPatient);
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;
                case 3:
                    System.out.println("enter patient name");
                    String nameForPrescription = sc.next();
                    if(newdata.checkIfPatientInDatabase(nameForPrescription)) {
                        System.out.println("enter test name ");
                        String nameOfTest = sc.next();
                        doc.PrescribePatient(nameForPrescription, nameOfTest);
                    }
                    else
                    {
                        System.out.println("patient does not exist");
                    }
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;
                case 4:
                    System.out.println("enter patient name");
                    String nameForMedicines = sc.next();
                    if(newdata.checkIfPatientInDatabase(nameForMedicines)) {
                        System.out.println("enter the number of medicines");
                        int numberOfMeds = sc.nextInt();
                        System.out.println("enter the name of medicines");
                        String[] arrOfMeds = new String[numberOfMeds];
                        for (int i = 0; i < arrOfMeds.length; i++) {
                            arrOfMeds[i] = sc.next();
                        }
                        doc.prescribeMedicines(nameForMedicines, arrOfMeds);
                        System.out.println("------------------operation completed------------------------");
                    }
                    else {
                        System.out.println("patient does not exist");
                    }
                        printMenuForDoctorConsole();
                        doctorChoice = sc.nextInt();
                    break;
                case 5:
                    System.out.println("enter patient name to get prescription");
                    String nameToGetPrescription = sc.next();
                    doc.getPrescribedMedicines(nameToGetPrescription);
                    printMenuForDoctorConsole();
                    doctorChoice = sc.nextInt();
                    break;


            }
        }
    }

    public void patientMenu(String patientname)
    {
        int patientChoice = sc.nextInt();
        do {
            switch (patientChoice) {
                case 1:
                    Bill.printBill(patientname);
                    printMenuForPatient();
                    patientChoice = sc.nextInt();
                    break;
                case 2:
                    doc.getPrescribedMedicines(patientname);
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
                    hms.adminMenu();
                    hms.printMainMenu();
                    choice = sc.nextInt();
                    break;
                case 2:
                    User userDoctor = new Doctor();
                    System.out.println("enter doctor password");
                    userDoctor.login(sc.next());
                    hms.printMenuForDoctorConsole();
                    hms.doctorMenu();
                    hms.printMainMenu();
                    choice = sc.nextInt();
                    break;
                case 3:
                    User userPatient = new Patient();
                    System.out.println("name of patient");
                    String pname = sc.next();
                    userPatient.login(pname);
                    hms.printMenuForPatient();
                    hms.patientMenu(pname);
                    hms.printMainMenu();
                    choice = sc.nextInt();
                    break;
                default:
                    System.out.println("wrong choice");
            }
        }while(choice<4);


    }
}
