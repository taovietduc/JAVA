// VIẾT BẰNG JAVA
// 9. Kiểm tra số hoàn hảo

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class PerfectNumberCheck // Class PerfectNumberCheck
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số cần kiểm tra từ người dùng
        System.out.print("Nhập một số nguyên dương: ");
        int number = scanner.nextInt();

        // Kiểm tra số hoàn hảo và in kết quả
        if (isPerfectNumber(number)) // Nếu là số hoàn hảo
        {
            System.out.println(number + " là số hoàn hảo.");
        } else // Nếu không phải là số hoàn hảo
        {
            System.out.println(number + " không phải là số hoàn hảo.");
        }
    }

    // Phương thức kiểm tra số hoàn hảo
    public static boolean isPerfectNumber(int num) {
        // Số nhỏ hơn hoặc bằng 1 không phải là số hoàn hảo
        if (num <= 1) // Nếu num <= 1
        {
            return false; // Trả về false
        }

        int sum = 0;

        // Tìm các ước số dương thực sự của num và tính tổng
        for (int i = 1; i <= num / 2; i++) // Duyệt từ 1 đến num / 2
        {
            if (num % i == 0) // Nếu i là ước số của num
            { // Nếu i là ước số của num
                sum += i; // Cộng i vào tổng
            }
        }

        // Kiểm tra nếu tổng các ước số bằng num
        return sum == num;
    }
}

