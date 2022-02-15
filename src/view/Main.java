package view;

import controller.HotelManagement;
import model.Hotel;
import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        HotelManagement hotelManagement = new HotelManagement();
        Person person1 = new Person("Bùi Quốc Luýt", "1/1/1993", "0123456");
        Person person2 = new Person("Phạm Mạnh Hùng", "1/12/1994", "1234567");
        Person person3 = new Person("Nguyễn Văn Toàn", "12/12/1987", "2345678");
        Hotel hotel1 = new Hotel("101", 5, "Víp", 100000, person1);
        Hotel hotel2 = new Hotel("102", 6, "Thường", 50000, person2);
        Hotel hotel3 = new Hotel("202", 2, "Víp", 150000, person3);

        hotelManagement.addNewHotel(hotel1);
        hotelManagement.addNewHotel(hotel2);
        hotelManagement.addNewHotel(hotel3);

        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    int size = hotelManagement.size();
                    if (size == 0) {
                        System.out.println("Danh sách rỗng");
                    } else {
                        System.out.println("---Danh sách khách sạn---");
                        hotelManagement.displayAllHotel();

                    }
                    break;
                }
                case 2: {
                    System.out.println("-- Thêm thông tin khách thuê phòng--");
                    sc.nextLine();
                    Hotel hotel = getHotel();
                    hotelManagement.addNewHotel(hotel);
                    break;
                }
                case 3: {
                    System.out.println("-- Chỉnh sửa thông tin khách thuê phòng--");
                    System.out.println("Nhập vị trí muốn sửa:");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index < 0 || index >= hotelManagement.size()) {
                        System.out.println("Vị trí chỉnh sửa không hợp lệ");
                    } else {
                        Hotel hotel = getHotel();
                        hotelManagement.updateHotel(index, hotel);
                    }

                    break;
                }
                case 4: {
                    System.out.println("-- Xoá thông tin khách thuê phòng--");
                    System.out.println("Nhập vị trí muốn xoá:");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index < 0 || index >= hotelManagement.size()) {
                        System.out.println("Vị trí xoá không hợp lệ");
                    } else {
                        hotelManagement.remoHotel(index);
                    }

                    break;
                }
                case 5: {
                    System.out.println("Tìm kiếm thông tin khách thuê phòng");
                    menuFind();
                    System.out.println("Nhập lựa chọn của bạn");
                    int choice2 = sc.nextInt();
                    sc.nextLine();

                    switch (choice2) {
                        case 1: {
                            System.out.println("Nhập tên: ");
                            String name = sc.nextLine();
                            Hotel result = hotelManagement.findHotelByName(name);
                            if (result == null) {
                                System.out.println("Không tìm thấy!!");
                            } else {
                                System.out.println("Kết quả tìm kiếm là: ");
                                System.out.println(result);
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Nhập phòng ");
                            String room = sc.nextLine();
                            Hotel result = hotelManagement.findHotelByRoom(room);
                            if (result == null) {
                                System.out.println("Không tìm thấy!!");
                            } else {
                                System.out.println("Kết quả tìm kiếm là: ");
                                System.out.println(result);
                            }
                            break;
                        }

                        default:
                            break;
                    }
                }
//                case 6: {
//                    sc.nextLine();
//                    System.out.println("Nhập tên của khách hàng");
//                    String identity = sc.nextLine();
//                    String name = null;
//                    HotelManagement.getMoneyByName(name);
//                    break;
//                }
            }
        } while (choice != 0);

    }

    private static void menuFind() {
        System.out.println("1. Tìm kiếm theo tên");
        System.out.println("2. Tìm kiếm theo phòng");
        System.out.println("0. Thoát");
    }


    private static Hotel getHotel() {
        Person person = getPerson();

        System.out.println("Nhập số phòng");
        String roomId = sc.nextLine();
        System.out.println("Nhập số ngày trọ");
        int dayRents = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập loại phòng");
        String type = sc.nextLine();
        System.out.println("Nhập giá phòng");
        double price = sc.nextDouble();
        return new Hotel(roomId, dayRents, type, price, person);
    }
    private static Person getPerson() {
        System.out.println("Nhập thông tin khách trọ");
        System.out.println("Nhập tên khách trọ");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh:");
        String dateOfBirth = sc.nextLine();
        System.out.println("Nhập căn cước:");
        String identity = sc.nextLine();
        return new Person(name, dateOfBirth, identity);
    }

    private static void menu() {
        System.out.println("---Menu quản lý khách sạn----");
        System.out.println("1. Hiển thị tất cả thông tin");
        System.out.println("2. Thêm thông tin khách thuê phòng");
        System.out.println("3. Cập nhật thông tin khách thuê phòng");
        System.out.println("4. Xoá thông tin khách thuê phòng");
        System.out.println("5. Tìm kiếm thông tin khách thuê phòng");
        System.out.println("6. Tính tiền khách thuê phòng qua tên của khách");
        System.out.println("0. Thoát chương trình");
    }
}
