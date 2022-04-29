public class AdmittedPatient extends Patient {

   private String emergencyContactNo;
   private Room room = null;

   private String admittedByDoctorName;

    public AdmittedPatient(String name,String age,String inDate,String patientID,String contactInfo,String doctorName) {
        super(name,age,inDate,patientID);
        this.emergencyContactNo = contactInfo;
        this.admittedByDoctorName = doctorName;
    }

    public void showInfo()
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %5s %5s %5s %5s %5s", this.getName(),this.getPatientId(),this.getPatientInDate(),this.getPatientAge(),room.getRoomNo(),this.admittedByDoctorName,this.emergencyContactNo);
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
    }

 public void setRoom(Room roomForStay)
 {
     this.room = roomForStay;
 }
 public Room getRoom()
 {
     return this.room;
 }

}
