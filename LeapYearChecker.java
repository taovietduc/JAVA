// VIẾT BẰNG JAVA
// 2. Kiểm tra năm nhuận

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class LeapYearChecker // Tên class phải trùng với tên file
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in); 

        // Nhập năm cần kiểm tra từ người dùng
        System.out.print("Nhập một năm: ");
        int year = scanner.nextInt();

        // Gọi phương thức kiểm tra năm nhuận và in kết quả
        if (isLeapYear(year)) // Nếu trả về true
        {
            System.out.println(year + " là năm nhuận.");
        }
        else // Nếu trả về false
        {
            System.out.println(year + " không phải là năm nhuận.");
        }
    }

    // Phương thức kiểm tra năm nhuận
    public static boolean isLeapYear(int year) // Trả về kiểu boolean
    {
        // Kiểm tra nếu năm chia hết cho 400, hoặc chia hết cho 4 nhưng không chia hết cho 100
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) // Nếu thỏa điều kiện
        {
            return true; // Trả về true
        }
        return false; // Trả về false
    }
}

