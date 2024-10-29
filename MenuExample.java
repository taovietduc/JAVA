// VIẾT BẰNG JAVA
// 30. Tạo menu lựa chọn

import java.util.Scanner; // Import thư viện Scanner để sử dụng lớp Scanner

public class MenuExample  // Tạo class MenuExample để tạo menu lựa chọn
{
    public static void main(String[] args) // Hàm main để chạy chương trình Java
    {
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        int choice; // Biến để lưu lựa chọn của người dùng

        do 
        {
            // Hiển thị menu
            System.out.println("=== MENU ===");
            System.out.println("1. Tính tổng hai số");
            System.out.println("2. Kiểm tra số chẵn/lẻ");
            System.out.println("3. Tính diện tích hình tròn");
            System.out.println("4. Thoát");
            System.out.print("Chọn một tùy chọn (1-4): ");
            
            // Nhận lựa chọn từ người dùng
            choice = scanner.nextInt(); // Đọc lựa chọn từ bàn phím

            switch (choice) //  Kiểm tra lựa chọn của người dùng
            {
                case 1:
                    // Tính tổng hai số
                    System.out.print("Nhập số thứ nhất: ");
                    int num1 = scanner.nextInt();
                    System.out.print("Nhập số thứ hai: ");
                    int num2 = scanner.nextInt();
                    int sum = num1 + num2;
                    System.out.println("Tổng hai số: " + sum);
                    break;

                case 2:
                    // Kiểm tra số chẵn/lẻ
                    System.out.print("Nhập một số: ");
                    int num = scanner.nextInt();
                    if (num % 2 == 0) {
                        System.out.println(num + " là số chẵn.");
                    } else {
                        System.out.println(num + " là số lẻ.");
                    }
                    break;

                case 3:
                    // Tính diện tích hình tròn
                    System.out.print("Nhập bán kính hình tròn: ");
                    double radius = scanner.nextDouble();
                    double area = Math.PI * radius * radius;
                    System.out.println("Diện tích hình tròn là: " + area);
                    break;

                case 4:
                    // Thoát chương trình
                    System.out.println("Đang thoát...");
                    break;

                default:
                    // Lựa chọn không hợp lệ
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

            System.out.println(); // Dòng trống để ngăn cách giữa các tùy chọn

        } while (choice != 4); // Thoát khi người dùng chọn 4
    }
}

// Kết quả:
// === MENU ===
// 1. Tính tổng hai số
// 2. Kiểm tra số chẵn/lẻ
// 3. Tính diện tích hình tròn
// 4. Thoát
// Chọn một tùy chọn (1-4): 1
// Nhập số thứ nhất: 10
// Nhập số thứ hai: 20
// Tổng hai số: 30

// === MENU ===
// 1. Tính tổng hai số
// 2. Kiểm tra số chẵn/lẻ
// 3. Tính diện tích hình tròn
// 4. Thoát
// Chọn một tùy chọn (1-4): 4
// Đang thoát...
