// VIẾT BẰNG JAVA
// 4. Kiểm tra số nguyên tố

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class PrimeNumberCheck 
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng Scanner để nhận input từ người dùng

        // Nhập số cần kiểm tra từ người dùng
        System.out.print("Nhập một số nguyên dương: ");
        int number = scanner.nextInt(); // Đọc số từ bàn phím

        // Kiểm tra số nguyên tố và in kết quả
        if (isPrime(number)) // Gọi phương thức isPrime để kiểm tra số nguyên tố
        {
            System.out.println(number + " là số nguyên tố.");
        } else 
        {
            System.out.println(number + " không phải là số nguyên tố.");
        }
    }

    // Phương thức kiểm tra số nguyên tố
    public static boolean isPrime(int num) 
    {
        // Số nhỏ hơn 2 không phải là số nguyên tố
        if (num < 2) // Nếu số nhỏ hơn 2 thì không phải số nguyên tố
        {
            return false;
        }
        // Kiểm tra từ 2 đến căn bậc 2 của num
        for (int i = 2; i <= Math.sqrt(num); i++) // Duyệt từ 2 đến căn bậc 2 của num
        {
            // Nếu num chia hết cho i thì không phải số nguyên tố
            if (num % i == 0) // Nếu num chia hết cho i thì không phải số nguyên tố
            {
                return false; // Trả về false nếu num chia hết cho i
            }
        }
        return true; // Trả về true nếu không chia hết cho bất kỳ số nào
    }
}

