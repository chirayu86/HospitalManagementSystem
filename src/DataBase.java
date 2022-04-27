import java.util.ArrayList;

public class DataBase {
        static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        static ArrayList<Patient> patients = new ArrayList<Patient>();
        static ArrayList<Bill> billList = new ArrayList<Bill>();

        static ArrayList<Prescription> prescriptionsList = new ArrayList<Prescription>();
        public void SampleDoctorList()
        {
            doctors.add(new Doctor("hari","1","cancer","cardic"));
            doctors.add(new Doctor("pappu","11","nerurology","nerulogist"));
        }
        public void SamplePatientList()
        {
            patients.add(new Patient("hero","12","12aug","3"));
            patients.add(new Patient("her","12","2aug","2"));
            patients.add(new Patient("ushe","14","2jan","12"));

        }
        public void addToListDoctor(Doctor doc)
        {
            doctors.add(doc);

        }
        public void addToListPatient(Patient p)
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


    public Doctor getDoctorFromDataBase(String docName)
    {
        for(Doctor d : DataBase.doctors)
        {
            if(d.getDocName().equals(docName))
            {
                return d;
            }
        }
        return null;
    }

    }
