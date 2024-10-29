// VIẾT BẰNG JAVA
// 10. Tạo hệ thống đặt vé máy bay đơn giản

import java.util.ArrayList; // Import ArrayList từ gói java.util để sử dụng ArrayList
import java.util.Scanner;  // Import Scanner từ gói java.util để sử dụng Scanner

// Lớp Flight đại diện cho chuyến bay
class Flight 
{
    private String flightNumber;  // Số hiệu chuyến bay
    private String departure;      // Điểm khởi hành
    private String destination;    // Điểm đến
    private int seatsAvailable;    // Số ghế còn trống

    // Constructor để khởi tạo chuyến bay
    public Flight(String flightNumber, String departure, String destination, int seatsAvailable) 
    // Constructor với tham số số hiệu chuyến bay, điểm khởi hành, điểm đến và số ghế còn trống
    {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    // Getter cho số hiệu chuyến bay
    public String getFlightNumber()  // Phương thức trả về số hiệu chuyến bay 
    {
        return flightNumber;
    }

    // Phương thức hiển thị thông tin chuyến bay
    public void displayInfo()  // Phương thức hiển thị thông tin chuyến bay
    {
        System.out.println("Số hiệu chuyến bay: " + flightNumber);
        System.out.println("Điểm khởi hành: " + departure);
        System.out.println("Điểm đến: " + destination);
        System.out.println("Ghế còn trống: " + seatsAvailable);
    }

    // Phương thức đặt vé
    public boolean bookSeat()  // Phương thức đặt vé 
    {
        if (seatsAvailable > 0)  // Nếu còn ghế trống
        {
            seatsAvailable--;
            return true;
        }
        return false; // Không còn ghế trống
    }
}

// Lớp Ticket đại diện cho vé máy bay
class Ticket  // Lớp Ticket đại diện cho vé máy bay 
{
    private String flightNumber;  // Số hiệu chuyến bay
    private String passengerName;  // Tên hành khách

    // Constructor để khởi tạo vé máy bay
    public Ticket(String flightNumber, String passengerName)  
    // Constructor với tham số số hiệu chuyến bay và tên hành khách
    {
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
    }

    // Phương thức hiển thị thông tin vé
    public void displayTicket()   // Phương thức hiển thị thông tin vé 
    {
        System.out.println("Vé máy bay:");
        System.out.println("Hành khách: " + passengerName);
        System.out.println("Số hiệu chuyến bay: " + flightNumber);
        System.out.println();
    }
}

// Lớp FlightBookingSystem để quản lý hệ thống đặt vé
class FlightBookingSystem  // Lớp FlightBookingSystem để quản lý hệ thống đặt vé
{
    private ArrayList<Flight> flights; // Danh sách chuyến bay

    // Constructor để khởi tạo hệ thống
    public FlightBookingSystem()  // Constructor để khởi tạo hệ thống với danh sách chuyến bay rỗng
    {
        flights = new ArrayList<>(); // Khởi tạo danh sách chuyến bay
    }

    // Phương thức thêm chuyến bay
    public void addFlight(Flight flight)  // Phương thức thêm chuyến bay
    {
        flights.add(flight);
    }

    // Phương thức hiển thị danh sách chuyến bay
    public void displayFlights()  // Phương thức hiển thị danh sách chuyến bay
    {
        System.out.println("Danh sách chuyến bay:");
        for (Flight flight : flights) 
        {
            flight.displayInfo();
            System.out.println();
        }
    }

    // Phương thức đặt vé
    public Ticket bookFlight(String flightNumber, String passengerName)  // Phương thức đặt vé 
    {
        for (Flight flight : flights)   // Duyệt qua danh sách chuyến bay
        {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber))  // So sánh số hiệu chuyến bay
            {
                if (flight.bookSeat())  // Đặt vé nếu còn ghế trống
                {
                    return new Ticket(flightNumber, passengerName); // Trả về vé mới
                } 
                else  // Nếu không còn ghế trống
                {
                    System.out.println("Xin lỗi, chuyến bay đã hết ghế."); // Thông báo chuyến bay đã hết ghế
                    return null;
                }
            }
        }
        System.out.println("Chuyến bay không tồn tại.");
        return null;
    }
}

// Lớp chính để thử nghiệm chương trình
public class FlightBookingApp  // Lớp chính để thử nghiệm chương trình
{
    public static void main(String[] args)  // Phương thức main để thực thi chương trình
    {
        FlightBookingSystem bookingSystem = new FlightBookingSystem(); // Khởi tạo hệ thống đặt vé
        Scanner scanner = new Scanner(System.in);

        // Thêm một số chuyến bay vào hệ thống
        bookingSystem.addFlight(new Flight("VN123", "Hà Nội", "Đà Nẵng", 5));
        bookingSystem.addFlight(new Flight("VN456", "TP.HCM", "Nha Trang", 3));
        bookingSystem.addFlight(new Flight("VN789", "Đà Lạt", "Hà Nội", 0)); // Chuyến bay đã hết ghế

        boolean running = true;

        while (running)  // Vòng lặp chính để chọn hành động
        {
            System.out.println("1. Xem danh sách chuyến bay");
            System.out.println("2. Đặt vé");
            System.out.println("3. Thoát");
            System.out.print("Chọn hành động: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice)     // Xử lý lựa chọn của người dùng
            {
                case 1:
                    bookingSystem.displayFlights(); // Hiển thị danh sách chuyến bay
                    break;
                case 2:
                    System.out.print("Nhập số hiệu chuyến bay: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Nhập tên hành khách: ");
                    String passengerName = scanner.nextLine();
                    Ticket ticket = bookingSystem.bookFlight(flightNumber, passengerName);
                    if (ticket != null) {
                        ticket.displayTicket();
                    }
                    break;
                case 3:
                    running = false;
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            System.out.println(); 
        }
        scanner.close();
    }
}

// Kết quả bài 10
// 1. Xem danh sách chuyến bay
// 2. Đặt vé
// 3. Thoát
// Chọn hành động: 1
// Danh sách chuyến bay:
// Số hiệu chuyến bay: VN123
// Điểm khởi hành: Hà Nội
// Điểm đến: Đà Nẵng
// Ghế còn trống: 5

// Số hiệu chuyến bay: VN456
// Điểm khởi hành: TP.HCM
// Điểm đến: Nha Trang
// Ghế còn trống: 3

// Số hiệu chuyến bay: VN789
// Điểm khởi hành: Đà Lạt
// Điểm đến: Hà Nội
// Ghế còn trống: 0

// 1. Xem danh sách chuyến bay
// 2. Đặt vé
// 3. Thoát
// Chọn hành động: 2
// Nhập số hiệu chuyến bay: VN123
// Nhập tên hành khách: Nguyen Van A
// Vé máy bay:
// Hành khách: Nguyen Van A
// Số hiệu chuyến bay: VN123

// 1. Xem danh sách chuyến bay
// 2. Đặt vé
// 3. Thoát
// Chọn hành động: 3
// Thoát chương trình.

