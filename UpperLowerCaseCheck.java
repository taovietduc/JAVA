// VIẾT BẰNG JAVA
// 4. Kiểm tra chữ hoa/chữ thường

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class UpperLowerCaseCheck // Tên class phải trùng với tên file
{
    public static void main(String[] args) // Phương thức main
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập một ký tự từ người dùng
        System.out.print("Nhập một ký tự: ");
        char ch = scanner.next().charAt(0);

        // Kiểm tra ký tự là chữ hoa hay chữ thường
        if (Character.isUpperCase(ch)) // Nếu là chữ hoa
        {
            System.out.println(ch + " là chữ hoa.");
        } 
        else if (Character.isLowerCase(ch)) // Nếu là chữ thường
        {
            System.out.println(ch + " là chữ thường.");
        } 
        else // Nếu không phải là chữ cái
        {
            System.out.println(ch + " không phải là chữ cái.");
        }
    }
}
