import javax.swing.text.TabExpander;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
        static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        static ArrayList<Patient> patients = new ArrayList<Patient>();
        static ArrayList<Bill> billList = new ArrayList<Bill>();

        static ArrayList<AdmittedPatient> admittedPatientList = new ArrayList<AdmittedPatient>();
        static ArrayList<Room> roomList = new ArrayList<Room>();
        static ArrayList<Prescription> prescriptionsList = new ArrayList<Prescription>();

        static ArrayList<Medicine> medicineListAvailable = new ArrayList<Medicine>();

        static ArrayList<Test> TestAvailableInHospital = new ArrayList<Test>();
        public void SampleDoctorList()
        {
            doctors.add(new Doctor("hari","1","cancer","cardic","1234"));
            doctors.add(new Doctor("pappu","11","nerurology","nerulogist","123"));
        }
        public void SamplePatientList()
        {
            patients.add(new Patient("hero","12","12aug","3"));
            patients.add(new Patient("her","12","2aug","2"));
            patients.add(new Patient("ushe","14","2jan","12"));

        }

        public void SampleMedicineList()
        {
            medicineListAvailable.add(new Medicine("para","tablet","200mg","morning"));
            medicineListAvailable.add(new Medicine("dolo","tablet","100mg","evening"));
            medicineListAvailable.add(new Medicine("digine","syrup","120mg","afternoon"));
        }

        public void SampleTestList()
        {
           TestAvailableInHospital.add(new Test("bl","blood test",1000));
            TestAvailableInHospital.add(new Test("ut","urine test",1000));
            TestAvailableInHospital.add(new Test("cd","cardiography",10000));

        }

        public void sampleRoomList()
        {
            roomList.add(new Room("1"));
            roomList.add(new Room("2"));
            roomList.add(new Room("3"));
            roomList.add(new Room("4"));
            roomList.add(new Room("5"));
            roomList.add(new Room("6"));
            roomList.add(new Room("7"));
            roomList.add(new Room("8"));

        }
        public static void addToListDoctor(Doctor doc)
        {
            doctors.add(doc);

        }
        public  static void addToListPatient(Patient p)
        {
            patients.add(p);
        }

        public static boolean checkIfPatientInDatabase(String name)
        {
            boolean flag = false;
            for(Patient p : patients)
            {
                if(p.getName().equals(name))
                {
                    flag = true;
                }
            }
            return flag;
        }

    public static boolean checkIfPatientIsAdmitted(String name)
    {
        boolean flag = false;
        for(AdmittedPatient p : admittedPatientList)
        {
            if(p.getName().equals(name))
            {
                flag = true;
            }
        }
        return flag;
    }

    public static  boolean checkIfMedicineInDatabase(String name)
    {
        boolean flag = false;
        for(Medicine m : medicineListAvailable)
        {
            if(m.getName().equals(name))
            {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean checkIfTestAvailableInHospital(String id)
    {
        boolean flag = false;
        for(Test test : TestAvailableInHospital)
        {
            if(test.getTestId().equals(id))
            {
                flag = true;
            }
        }
        return flag;
    }

    public  static void listDoctors()
    {
        for(Doctor d : doctors)
        {
            d.showInfoDoctor();
        }
    }
    public static void listPatients()
    {
        for(Patient p : patients)
        {
            p.showInfo();
        }
    }

    public static  void listAdmittedPatients()
    {
        for(AdmittedPatient ap : admittedPatientList)
        {
            ap.showInfo();
        }
    }
    public  static Doctor getDoctorFromDataBase(String docName)
    {
        for(Doctor d : doctors)
        {
            if(d.getDocName().equals(docName))
            {
                return d;
            }

        }
        return null;
    }

    public static Patient getPatientFromDatabase(String patientName)
    {
        for(Patient p : patients)
        {
            if(p.getName().equals(patientName))
            {
                return p;
            }

        }
        return null;
    }

    public  static  AdmittedPatient getAdmittedPatientFromDataBase(String name)
    {
        for(AdmittedPatient p : admittedPatientList)
        {
            if(p.getName().equals(name))
            {
                return p;
            }

        }
        return null;
    }

    public static Medicine getMedicineFromDatabase(String MedicineName)
    {
        for(Medicine M : medicineListAvailable)
        {
            if(M.getName().equals(MedicineName))
            {
                return M;
            }
        }
        return null;
    }

    public static Test  getTestFromDatabase(String testId)
    {
        for(Test test : TestAvailableInHospital)
        {
            if(test.getTestId().equals(testId))
            {
                return test;
            }
        }
        return null;
    }
    public static int countEmptyRoom()
    {
        int count = 0;
        for(Room r : roomList)
        {
            if(r.getEmpty())
            {
                count++;
            }
        }
        return count;
    }

    }
