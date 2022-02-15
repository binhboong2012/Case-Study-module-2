package model;

public class Hotel {
    private String roomId;
    private int rentDays;
    private String type;
    private double price;
    private Person person;

    public Hotel() {
    }

    public Hotel(String roomId, int rentDays, String type, double price, Person person) {
        this.roomId = roomId;
        this.rentDays = rentDays;
        this.type = type;
        this.price = price;
        this.person = person;
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDay(int rentDays) {
        this.rentDays = rentDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return  roomId + ", " + person + ", " + rentDays + ", " + type + ", " + price ;
    }
}
