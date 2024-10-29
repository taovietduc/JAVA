// VIẾT BẰNG JAVA
// 10. Tạo ma trận vuông đơn giản

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class SquareMatrix // Class SquareMatrix
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Khởi tạo đối tượng Scanner để nhận input từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước của ma trận vuông từ người dùng
        System.out.print("Nhập kích thước ma trận vuông: ");
        int size = scanner.nextInt();

        // Khởi tạo ma trận vuông với kích thước size x size
        int[][] matrix = new int[size][size];

        // Nhập các phần tử của ma trận
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < size; i++) // Duyệt qua từng hàng
        {
            for (int j = 0; j < size; j++) // Duyệt qua từng cột
            {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                // Nhập phần tử tại vị trí i, j
                matrix[i][j] = scanner.nextInt(); // Lưu phần tử vào ma trận
            }
        }

        // Hiển thị ma trận
        System.out.println("Ma trận vuông:");
        for (int i = 0; i < size; i++) // Duyệt qua từng hàng
        {
            for (int j = 0; j < size; j++) // Duyệt qua từng cột
            {
                System.out.print(matrix[i][j] + "\t");
                // Hiển thị phần tử tại vị trí i, j
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }
    }
}

