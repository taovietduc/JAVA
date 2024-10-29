// VIẾT BẰNG JAVA
// 9. Tính diện tích hình tròn

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class CircleArea { // Khai báo class CircleArea
    public static void main(String[] args) { // Khai báo hàm main
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập bán kính từ người dùng
        System.out.print("Nhập bán kính hình tròn: ");
        double radius = scanner.nextDouble();

        // Tính diện tích hình tròn
        double area = Math.PI * radius * radius;

        // Hiển thị kết quả
        System.out.println("Diện tích hình tròn là: " + area);
    }
}
