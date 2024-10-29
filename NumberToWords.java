// VIẾT BẰNG JAVA
// 25. Chuyển đổi số sang chữ (1 thành "một", 2 thành "hai")

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class NumberToWords // Class chính của chương trình NumberToWords
{
    public static void main(String[] args) 
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số từ người dùng
        System.out.print("Nhập một số nguyên (0-9): ");
        int number = scanner.nextInt(); // Lấy số từ người dùng

        // Gọi phương thức để chuyển số thành chữ
        String result = numberToWord(number); // Gán kết quả vào biến result

        // Kiểm tra và in kết quả
        if (result != null) // Nếu số hợp lệ
        {
            System.out.println("Số " + number + " được đọc là: " + result); // In kết quả
        } 
        else // Nếu số không hợp lệ
        {
            System.out.println("Số không hợp lệ. Vui lòng nhập số từ 0 đến 9."); // Thông báo lỗi
        }
    }

    // Phương thức chuyển số từ 0 đến 9 thành chữ
    public static String numberToWord(int num) 
    {
        switch (num) // Sử dụng switch-case để chuyển số thành chữ
        {
            case 0:
                return "không";
            case 1:
                return "một";
            case 2:
                return "hai";
            case 3:
                return "ba";
            case 4:
                return "bốn";
            case 5:
                return "năm";
            case 6:
                return "sáu";
            case 7:
                return "bảy";
            case 8:
                return "tám";
            case 9:
                return "chín";
            default:
                return null; // Trả về null nếu số ngoài phạm vi 0-9
        }
    }
}

