// VIẾT BẰNG JAVA
// 2. Đảo ngược chuỗi

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class ReverseString 
{
    public static void main(String[] args) 
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng Scanner để nhận input từ người dùng

        // Nhập chuỗi từ người dùng
        System.out.print("Nhập chuỗi cần đảo ngược: ");
        String input = scanner.nextLine(); // Đọc chuỗi từ bàn phím

        // Đảo ngược chuỗi
        String reversedString = "";
        for (int i = input.length() - 1; i >= 0; i--) // Duyệt chuỗi từ cuối về đầu
        {
            reversedString += input.charAt(i); // Lấy ký tự ở vị trí i và thêm vào chuỗi đảo ngược
        }

        // Hiển thị kết quả
        System.out.println("Chuỗi sau khi đảo ngược: " + reversedString);
    }
}

