package ConcreteClasses;

import java.io.Serializable;

public class Room implements Serializable{
    private String roomNo;
    private String roomType;
    private double roomRent;

    public Room() {
    }

    public Room(String roomNo, String roomType , double roomRent) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomRent = roomRent;
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

    public double getRoomRent() {
        return this.roomRent;
    }

    public void setRoomRent(double roomRent) {
        this.roomRent = roomRent;
    }


    @Override
    public String toString() {
        return 
            " Room No = " + getRoomNo() + "\n" +
            " Room Type = " + getRoomType() +  "\n" +
            " Room Rent = " + getRoomRent() + "\n";
    }

}
