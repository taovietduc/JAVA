// VIẾT BẰNG JAVA
// 8.In ra bảng cửu chương


public class MultiplicationTable { // Khai báo class MultiplicationTable
    public static void main(String[] args) { // Khai báo hàm main
        // Vòng lặp để in các bảng cửu chương từ 1 đến 9
        for (int i = 1; i <= 9; i++) { // Vòng lặp từ 1 đến 9
            System.out.println("Bảng cửu chương " + i + ":");
            
            // Vòng lặp để in từng dòng của bảng cửu chương
            for (int j = 1; j <= 10; j++) { //  Vòng lặp từ 1 đến 10
                System.out.println(i + " x " + j + " = " + (i * j));
            }
            
            // In dòng trống để ngăn cách các bảng
            System.out.println();
        }
    }
}
