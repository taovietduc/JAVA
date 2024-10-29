// VIẾT BẰNG JAVA
// 2. Tính tổng hai số

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class SumTwoNumbers {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Scanner để nhận input từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập số thứ nhất
        System.out.print("Nhập số thứ nhất: ");
        int number1 = scanner.nextInt();

        // Nhập số thứ hai
        System.out.print("Nhập số thứ hai: ");
        int number2 = scanner.nextInt();

        // Tính tổng hai số
        int sum = number1 + number2;

        // Hiển thị kết quả
        System.out.println("Tổng của hai số là: " + sum);
    }
}

