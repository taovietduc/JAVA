// VIẾT BẰNG JAVA
// 29. Tính số lần xuất hiện của một số trong mảng

import java.util.Scanner; // Import thư viện Scanner để sử dụng lớp Scanner

public class CountOccurrences // Tạo class CountOccurrences để tính số lần xuất hiện của một số trong mảng
{
    public static void main(String[] args) // Hàm main để chạy chương trình Java
    {
        // Khởi tạo mảng ví dụ
        int[] array = {1, 2, 3, 4, 5, 2, 2, 6, 7, 2, 8, 9, 10};

        // Nhập số cần tìm số lần xuất hiện
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        System.out.print("Nhập số cần tìm: "); // In ra dòng chữ "Nhập số cần tìm: "
        int numberToFind = scanner.nextInt(); // Đọc số cần tìm từ bàn phím

        // Biến để đếm số lần xuất hiện
        int count = 0;

        // Duyệt qua mảng và đếm số lần xuất hiện của numberToFind
        for (int i = 0; i < array.length; i++) // Duyệt qua mảng từ 0 đến hết
        {
            if (array[i] == numberToFind) // Nếu phần tử thứ i bằng với số cần tìm
            {
                count++; // Tăng biến đếm lên 1
            }
        }

        // Hiển thị kết quả
        System.out.println("Số " + numberToFind + " xuất hiện " + count + " lần trong mảng.");
    }
}

// Kết quả:
Nhập số cần tìm: 2
Số 2 xuất hiện 4 lần trong mảng.

