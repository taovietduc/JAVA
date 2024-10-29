// VIẾT BẰNG JAVA
// 5. Đếm số ký tự trong chuỗi


import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class CountCharacters { // Tên class phải trùng với tên file
    public static void main(String[] args) { // Hàm main để chạy chương trình
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập chuỗi từ bàn phím
        System.out.print("Nhập một chuỗi: ");
        String input = scanner.nextLine();

        // Đếm số ký tự trong chuỗi
        int length = input.length();

        // Hiển thị kết quả
        System.out.println("Số ký tự trong chuỗi là: " + length);
    }
}
