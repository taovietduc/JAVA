// VIẾT BẰNG JAVA
// 6. In hình tam giác bằng dấu "*".

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class TrianglePattern { // Tên class phải trùng với tên file
    public static void main(String[] args) { // Hàm main để chạy chương trình
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập chiều cao của tam giác
        System.out.print("Nhập chiều cao của tam giác: ");
        int height = scanner.nextInt();

        // Vòng lặp in ra hình tam giác
        for (int i = 1; i <= height; i++) {
            // In các dấu * theo số dòng
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Xuống dòng sau mỗi lần in một hàng
            System.out.println();
        }
    }
}
