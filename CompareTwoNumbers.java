// VIẾT BẰNG JAVA
// 7. So sánh hai số.

import java.util.Scanner; // Import thư viện Scanner để lấy input từ người dùng

public class CompareTwoNumbers { // Tên class phải trùng với tên file
    public static void main(String[] args) { // Hàm main để chạy chương trình
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số thứ nhất
        System.out.print("Nhập số thứ nhất: ");
        int number1 = scanner.nextInt();

        // Nhập số thứ hai
        System.out.print("Nhập số thứ hai: ");
        int number2 = scanner.nextInt();

        // So sánh hai số
        if (number1 > number2) {
            System.out.println(number1 + " lớn hơn " + number2);
        } else if (number1 < number2) {
            System.out.println(number1 + " nhỏ hơn " + number2);
        } else {
            System.out.println(number1 + " bằng " + number2);
        }
    }
}
