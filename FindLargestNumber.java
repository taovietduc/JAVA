// VIẾT BẰNG JAVA
// 3. Tìm số lớn nhất trong mảng

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class FindLargestNumber 
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng Scanner để nhận input từ người dùng

        // Nhập số lượng phần tử của mảng
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();// Đọc số lượng phần tử từ bàn phím

        // Khởi tạo mảng với kích thước n
        int[] array = new int[n];// Khởi tạo mảng với kích thước n

        // Nhập các phần tử của mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) // Duyệt qua từng phần tử của mảng
        {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt(); // Nhận giá trị từ bàn phím và lưu vào mảng
        }

        // Tìm phần tử lớn nhất trong mảng
        int max = array[0]; // Giả sử phần tử đầu tiên là lớn nhất
        for (int i = 1; i < n; i++) // Duyệt qua các phần tử còn lại của mảng
        {
            if (array[i] > max) // So sánh phần tử hiện tại với phần tử lớn nhất
            {
                max = array[i]; // Nếu phần tử hiện tại lớn hơn, gán lại giá trị lớn nhất
            }
        }

        // Hiển thị kết quả
        System.out.println("Số lớn nhất trong mảng là: " + max);
    }
}
