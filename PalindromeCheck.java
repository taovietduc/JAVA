// VIẾT BẰNG JAVA
// 7. Kiểm tra chuỗi palindrome

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class PalindromeCheck // Class PalindromeCheck
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in); 
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng

        // Nhập chuỗi cần kiểm tra từ người dùng
        System.out.print("Nhập chuỗi cần kiểm tra: "); 
        // Hiển thị thông báo để nhập chuỗi
        String input = scanner.nextLine(); // Đọc chuỗi từ bàn phím

        // Kiểm tra chuỗi có phải là palindrome hay không
        if (isPalindrome(input)) // Nếu là chuỗi palindrome
        {
            System.out.println(input + " là chuỗi palindrome."); // Hiển thị thông báo
        } else 
        {
            System.out.println(input + " không phải là chuỗi palindrome."); // Hiển thị thông báo
        }
    }

    // Phương thức kiểm tra chuỗi có phải là palindrome
    public static boolean isPalindrome(String str) // Phương thức trả về kiểu boolean
    {
        // Chuyển chuỗi về dạng viết thường và loại bỏ khoảng trắng để không phân biệt chữ hoa và dấu cách
        str = str.toLowerCase().replaceAll("\\s+", ""); 
        // Chuyển chuỗi về dạng viết thường và loại bỏ khoảng trắng

        int left = 0; // Chỉ số đầu của chuỗi
        int right = str.length() - 1; // Chỉ số cuối của chuỗi

        // So sánh các ký tự từ đầu và cuối chuỗi
        while (left < right) // Vòng lặp để so sánh các ký tự từ đầu và cuối chuỗi
        {
            if (str.charAt(left) != str.charAt(right)) // Nếu có một cặp ký tự không khớp
            {
                return false; // Nếu có một cặp ký tự không khớp, không phải là palindrome
            }
            left++; // Tăng chỉ số đầu
            right--; // Giảm chỉ số cuối
        }

        return true; // Nếu không có cặp ký tự nào không khớp, là palindrome
    }
}