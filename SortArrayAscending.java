// VIẾT BẰNG JAVA
// 6. Sắp xếp mảng theo thứ tự tăng dần

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class SortArrayAscending 
{
    public static void main(String[] args) 
    {
        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in); // System.in là một luồng đầu vào từ bàn phím

        // Nhập số lượng phần tử của mảng
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt(); // Đọc số nguyên từ bàn phím

        // Khởi tạo mảng với kích thước n
        int[] array = new int[n]; // Khai báo mảng với kích thước n

        // Nhập các phần tử của mảng
        System.out.println("Nhập các phần tử của mảng:"); 
        for (int i = 0; i < n; i++) // Vòng lặp để nhập từng phần tử của mảng
        {
            System.out.print("Phần tử thứ " + (i + 1) + ": "); // Hiển thị thông báo để nhập
            array[i] = scanner.nextInt(); // Đọc phần tử của mảng từ bàn phím
        }

        // Sắp xếp mảng theo thứ tự tăng dần bằng Bubble Sort
        for (int i = 0; i < n - 1; i++) // Vòng lặp ngoài để duyệt qua từng phần tử của mảng
        {
            for (int j = 0; j < n - i - 1; j++) // Vòng lặp trong để so sánh và sắp xếp các phần tử
            {
                if (array[j] > array[j + 1]) // Nếu phần tử trước lớn hơn phần tử sau
                {
                    // Hoán đổi hai phần tử nếu phần tử trước lớn hơn phần tử sau
                    int temp = array[j]; // Sử dụng biến tạm để hoán đổi giá trị của hai phần tử
                    array[j] = array[j + 1]; // Gán giá trị của phần tử sau cho phần tử trước
                    array[j + 1] = temp; // Gán giá trị của biến tạm cho phần tử sau
                }
            }
        }

        // Hiển thị mảng sau khi sắp xếp
        System.out.println("Mảng sau khi sắp xếp theo thứ tự tăng dần:");
        for (int i = 0; i < n; i++) // Vòng lặp để in từng phần tử của mảng
        {
            System.out.print(array[i] + " "); // In từng phần tử của mảng
        }
    }
}

