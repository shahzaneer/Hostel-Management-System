public class Room {
    private String roomNo;
    private String roomType;


    public Room() {
    }

    public Room(String roomNo, String roomType) {
        this.roomNo = roomNo;
        this.roomType = roomType;
    }

    public String getRoomNo() {
        return this.roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


    @Override
    public String toString() {
        return 
            " Room No = " + getRoomNo() + "\n" +
            " Room Type = " + getRoomType();
    }

}
