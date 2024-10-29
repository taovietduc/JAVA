// VIẾT BẰNG JAVA
// 26. Tạo game đoán số

import java.util.Random;  // Import thư viện để tạo số ngẫu nhiên
import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class GuessingGame // Class chính của chương trình GuessingGame
{
    public static void main(String[] args) // Phương thức main chính của chương trình GuessingGame
    {
        // Khởi tạo đối tượng Random để tạo số ngẫu nhiên
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Tạo số ngẫu nhiên từ 1 đến 100

        // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);

        int userGuess = 0; // Biến để lưu số người chơi đoán
        int numberOfTries = 0; // Đếm số lần đoán

        // In lời chào và hướng dẫn trò chơi
        System.out.println("Chào mừng bạn đến với trò chơi đoán số!");
        System.out.println("Tôi đã nghĩ ra một số từ 1 đến 100. Bạn hãy đoán số đó nhé!");

        // Vòng lặp đoán số
        while (userGuess != numberToGuess) // Nếu số đoán khác số ngẫu nhiên thì tiếp tục vòng lặp
        {
            // Yêu cầu người dùng nhập số
            System.out.print("Nhập số bạn đoán: ");
            userGuess = scanner.nextInt(); // Nhận số đoán từ người dùng
            numberOfTries++; // Tăng số lần đoán

            // Kiểm tra số đoán với số ngẫu nhiên
            if (userGuess < numberToGuess) // Nếu số đoán nhỏ hơn số ngẫu nhiên
            {
                System.out.println("Số bạn đoán nhỏ quá!"); // Thông báo số nhỏ
            } 
            else if (userGuess > numberToGuess) // Nếu số đoán lớn hơn số ngẫu nhiên
            {
                System.out.println("Số bạn đoán lớn quá!"); // Thông báo số lớn
            }
            else // Nếu số đoán bằng số ngẫu nhiên
            {
                System.out.println("Chúc mừng! Bạn đã đoán đúng sau " + numberOfTries + " lần đoán."); // Thông báo chiến thắng
            }
        }
    }
}

// // Ví dự:
// Chào mừng bạn đến với trò chơi đoán số!
// Tôi đã nghĩ ra một số từ 1 đến 100. Bạn hãy đoán số đó nhé!
// Nhập số bạn đoán: 50
// Số bạn đoán nhỏ quá!
// Nhập số bạn đoán: 75
// Số bạn đoán lớn quá!
// Nhập số bạn đoán: 60
// Chúc mừng! Bạn đã đoán đúng sau 3 lần đoán.

