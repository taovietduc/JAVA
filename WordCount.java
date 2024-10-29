// VIẾT BẰNG JAVA
// 8.Đếm số từ trong chuỗi

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class WordCount // Class WordCount
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập chuỗi cần đếm số từ từ người dùng
        System.out.print("Nhập một chuỗi: ");
        String input = scanner.nextLine();

        // Gọi phương thức đếm số từ trong chuỗi
        int wordCount = countWords(input); // Gán kết quả trả về từ phương thức vào biến wordCount

        // Hiển thị kết quả
        System.out.println("Số từ trong chuỗi là: " + wordCount);
    }

    // Phương thức đếm số từ trong một chuỗi
    public static int countWords(String str) // Phương thức trả về kiểu int
    {
        // Xóa khoảng trắng đầu và cuối, rồi tách chuỗi thành các từ bằng cách sử dụng dấu cách làm dấu phân cách
        String[] words = str.trim().split("\\s+"); // Tách chuỗi thành các từ

        // Nếu chuỗi rỗng thì số từ bằng 0
        if (words.length == 0 || words[0].isEmpty()) // Nếu chuỗi rỗng hoặc không có từ nào
        {
            return 0;
        }

        // Trả về độ dài của mảng từ
        return words.length;
    }
}

