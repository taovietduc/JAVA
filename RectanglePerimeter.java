// VIẾT BẰNG JAVA
// 10. Tính chu vi hình chữ nhật

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class RectanglePerimeter { // Khai báo class RectanglePerimeter
    public static void main(String[] args) { // Khai báo hàm main
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập chiều dài và chiều rộng từ người dùng
        System.out.print("Nhập chiều dài hình chữ nhật: ");
        double length = scanner.nextDouble();

        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        double width = scanner.nextDouble();

        // Tính chu vi hình chữ nhật
        double perimeter = 2 * (length + width);

        // Hiển thị kết quả
        System.out.println("Chu vi hình chữ nhật là: " + perimeter);
    }
}
