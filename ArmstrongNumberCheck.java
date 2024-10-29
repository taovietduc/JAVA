// VIẾT BẰNG JAVA
// 3. Kiểm tra số Armstrong

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class ArmstrongNumberCheck // Tên class phải trùng với tên file
{
    public static void main(String[] args) 
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số cần kiểm tra từ người dùng
        System.out.print("Nhập một số nguyên: ");
        int number = scanner.nextInt();

        // Gọi phương thức kiểm tra số Armstrong và in kết quả
        if (isArmstrong(number)) // Nếu trả về true
        {
            System.out.println(number + " là số Armstrong.");
        }
        else // Nếu trả về false
        {
            System.out.println(number + " không phải là số Armstrong.");
        }
    }

    // Phương thức kiểm tra số Armstrong
    public static boolean isArmstrong(int num) 
    {
        int originalNumber = num; // Lưu giá trị ban đầu của số
        int result = 0;
        int digits = String.valueOf(num).length(); // Số lượng chữ số

        // Tính tổng lũy thừa của các chữ số
        while (num != 0) // Lặp cho đến khi num = 0
        {
            int remainder = num % 10;
            result += Math.pow(remainder, digits); // Cộng lũy thừa của chữ số vào tổng
            num /= 10; // Giảm số để tiếp tục tính chữ số tiếp theo
        }

        // Kiểm tra nếu tổng bằng với số ban đầu
        return result == originalNumber; // Trả về true hoặc false
    }
}
