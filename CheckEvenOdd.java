// VIẾT BẰNG JAVA
// 4. Kiểm tra số chẵn/lẻ

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class CheckEvenOdd { // Tên class phải trùng với tên file
    public static void main(String[] args) { // Hàm main để chạy chương trình
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số từ bàn phím
        System.out.print("Nhập một số: ");
        int number = scanner.nextInt();

        // Kiểm tra chẵn/lẻ
        if (number % 2 == 0) {
            System.out.println(number + " là số chẵn.");
        } else {
            System.out.println(number + " là số lẻ.");
        }
    }
}
