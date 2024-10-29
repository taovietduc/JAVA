// VIẾT BẰNG JAVA
// 1. Chương trình máy tính bỏ túi đơn giản

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class SimpleCalculator // Chương trình máy tính bỏ túi đơn giản
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập hai số từ người dùng
        System.out.print("Nhập số thứ nhất: ");
        double num1 = scanner.nextDouble();

        System.out.print("Nhập số thứ hai: ");
        double num2 = scanner.nextDouble();

        // Nhập phép toán mà người dùng muốn thực hiện
        System.out.print("Chọn phép toán (+, -, *, /): ");
        char operator = scanner.next().charAt(0); // Lấy ký tự đầu tiên từ chuỗi nhập vào

        // Biến để lưu kết quả tính toán
        double result; // Kết quả có thể là số thực

        // Thực hiện phép toán dựa trên toán tử được nhập
        switch (operator) // Kiểm tra giá trị của operator
        {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Lỗi: Không thể chia cho 0.");
                    return;
                }
                break;
            default:
                System.out.println("Lỗi: Phép toán không hợp lệ.");
                return;
        }

        // Hiển thị kết quả
        System.out.println("Kết quả của phép toán là: " + result);
    }
}

