package controller;

import model.Hotel;
import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelManagement {
    private static List<Hotel> hotels = new ArrayList<>();

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public int size() {
        return hotels.size();
    }


    public void displayAllHotel() {
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println(hotels.get(i));
        }

    }

    public void addNewHotel(Hotel hotel) {
        this.hotels.add(hotel);

    }

    public void updateHotel(int index, Hotel hotel) {
        hotels.set(index, hotel);
    }

    public void remoHotel(int index) {
        hotels.remove(index);
    }

    public int findHotelByType(String type) {
        int index = -1;
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getType().equals(type)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Hotel findHotelByName(String searchName) {
        Hotel result = null;

        for (Hotel hotel : hotels) {
            Person person = hotel.getPerson();
            boolean found = person.getName().equals(searchName);
            if (found) {
                result = hotel;
                break;
            }
        }

        return result;
    }

    public Hotel findHotelByRoom(String searchRoomId) {
        Hotel result = null;
        for (Hotel hotel : hotels) {
            boolean found = hotel.getRoomId().equals(searchRoomId);
            if (found) {
                result = hotel;
                break;
            }
        }

        return result;
    }

}
