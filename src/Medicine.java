public class Medicine {
    private String name;
    private String type;
    private String dose;
    private String time;

    public Medicine(String name, String type, String dose, String time) {
        this.name = name;
        this.type = type;
        this.dose = dose;
        this.time = time;
    }

    public String getName() {
        return name;
    }
    public void showInfo()
    {
        System.out.println("name of medicine is " +this.name);
        System.out.println("type of medicine is " +this.type);
        System.out.println("recommended dosage is  " +this.dose);
        System.out.println("time for medicine is  " +this.time);
    }

}
