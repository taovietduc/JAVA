// VIẾT BẰNG JAVA
// 5. In số Fibonacci

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class FibonacciSequence // Class FibonacciSequence
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng Scanner để nhận input từ người dùng

        // Nhập số lượng phần tử của dãy Fibonacci từ người dùng
        System.out.print("Nhập số lượng phần tử của dãy Fibonacci: ");
        int n = scanner.nextInt(); // Đọc số từ bàn phím

        // In dãy Fibonacci
        System.out.println("Dãy số Fibonacci:"); // In ra dòng chữ "Dãy số Fibonacci:"
        for (int i = 0; i < n; i++) // Duyệt từ 0 đến n
        {
            System.out.print(fibonacci(i) + " "); // In số Fibonacci tại vị trí i
        }
    }

    // Phương thức để tính số Fibonacci tại vị trí n
    public static int fibonacci(int n) // Phương thức để tính số Fibonacci tại vị trí n
    {
        if (n == 0) //  Nếu n = 0 thì trả về 0
        {
            return 0; // Trả về 0 nếu n = 0
        }
        if (n == 1) // Nếu n = 1 thì trả về 1
        {
            return 1; // Trả về 1 nếu n = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Trả về tổng của 2 số Fibonacci trước đó
    }
}
