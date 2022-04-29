public class Room {
    private String roomNo;
    private boolean isEmpty = true;

    public Room(String roomNo)
    {
        this.roomNo = roomNo;
    }

    public boolean getEmpty()
    {
        return this.isEmpty;
    }

    public void setEmpty(boolean bool)
    {
        this.isEmpty = bool;
    }

    public String getRoomNo()
    {
        return this.roomNo;
    }

}
