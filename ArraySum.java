// VIẾT BẰNG JAVA
// 1. Tính tổng các số trong mảng

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class ArraySum 
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng phần tử của mảng
        System.out.print("Nhập số lượng phần tử của mảng: "); 
        int n = scanner.nextInt();

        // Khởi tạo mảng với kích thước n
        int[] array = new int[n];

        // Nhập các phần tử của mảng
        System.out.println("Nhập các phần tử của mảng:"); // 
        for (int i = 0; i < n; i++) // Duyệt qua từng phần tử của mảng
        {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt(); // Nhận giá trị từ bàn phím và lưu vào mảng
        }

        // Tính tổng các phần tử trong mảng
        int sum = 0;
        for (int i = 0; i < n; i++) // Duyệt qua từng phần tử của mảng
        {
            sum += array[i]; // Cộng giá trị của phần tử vào biến sum
        }

        // Hiển thị kết quả
        System.out.println("Tổng các phần tử trong mảng là: " + sum);
    }
}
