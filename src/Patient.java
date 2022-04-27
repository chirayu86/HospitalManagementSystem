

public class Patient extends User {
    private String patientName;
    private String patientAge;
    private String patientInDate;
    private String patientId ;


    Patient(String name,String age,String date,String id)
    {
        this.patientName = name;
        this.patientAge = age;
        this.patientInDate = date;
        this.patientId = id;
    }
    public Patient(){}

    public void showInfo()
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %5s %5s", this.patientName,this.patientId,this.patientInDate,this.patientAge);
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
    }

    public String getName()
    {
        return this.patientName;
    }


    public void login(String name)
    {
        if(DataBase.checkIfPatientInDatabase(name))
        {
            System.out.println("login successful");
        }
        else {
            System.out.println("name does not exist");
            System.exit(0);
        }
    }

}
