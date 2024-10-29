// VIẾT BẰNG JAVA
// 28. Tạo bảng nhân bằng mảng 2D

public class MultiplicationTable_2D // Tạo class MultiplicationTable_2D
{
    public static void main(String[] args) // Hàm main để chạy chương trình Java
    {
        // Khởi tạo mảng 2D để lưu bảng nhân từ 1 đến 10
        int[][] table = new int[10][10]; // Mảng 2 chiều 10x10

        // Điền giá trị vào mảng 2D
        for (int i = 0; i < 10; i++) // Duyệt từ 0 đến 9
        {
            for (int j = 0; j < 10; j++) // Duyệt từ 0 đến 9
            {
                table[i][j] = (i + 1) * (j + 1); // Tính giá trị của bảng nhân
            }
        }

        // In bảng nhân ra màn hình
        System.out.println("Bảng nhân từ 1 đến 10:"); // In ra dòng chữ "Bảng nhân từ 1 đến 10:"
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++) // Duyệt từ 0 đến 9 để in ra bảng nhân từng hàng
            {
                System.out.print(table[i][j] + "\t"); // \t để tạo khoảng cách giữa các giá trị
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }
    }
}

// Kết quả:
Bảng nhân từ 1 đến 10:
1	2	3	4	5	6	7	8	9	10	
2	4	6	8	10	12	14	16	18	20	
3	6	9	12	15	18	21	24	27	30	
4	8	12	16	20	24	28	32	36	40	
5	10	15	20	25	30	35	40	45	50	
6	12	18	24	30	36	42	48	54	60	
7	14	21	28	35	42	49	56	63	70	
8	16	24	32	40	48	56	64	72	80	
9	18	27	36	45	54	63	72	81	90	
10	20	30	40	50	60	70	80	90	100

