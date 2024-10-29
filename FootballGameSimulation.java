// VIẾT BẰNG JAVA
// 9. Tạo trò chơi đá bóng mô phỏng đơn giản

import java.util.Random; // Import Random từ gói java.util để sử dụng Random
import java.util.Scanner; // Import Scanner từ gói java.util để sử dụng Scanner

// Lớp Player đại diện cho người chơi
class Player 
{
    private String name;          // Tên người chơi
    private int skillLevel;       // Cấp độ kỹ năng

    // Constructor để khởi tạo người chơi
    public Player(String name, int skillLevel)  // Constructor với tham số tên người chơi và cấp độ kỹ năng
    {
        this.name = name; // Gán tên người chơi từ tham số
        this.skillLevel = skillLevel; // Gán cấp độ kỹ năng từ tham số
    }

    // Phương thức để thực hiện hành động sút bóng
    public boolean shoot()  // Phương thức để thực hiện hành động sút bóng
    {
        Random random = new Random(); // Tạo một đối tượng Random
        int chance = random.nextInt(100); // Tạo số ngẫu nhiên từ 0 đến 99
        return chance < skillLevel; // Thành công nếu số ngẫu nhiên nhỏ hơn cấp độ kỹ năng
    }

    // Phương thức để thực hiện hành động chuyền bóng
    public boolean pass()  // Phương thức để thực hiện hành động chuyền bóng
    {
        Random random = new Random(); // Tạo một đối tượng Random
        int chance = random.nextInt(100);
        return chance < skillLevel; // Thành công nếu số ngẫu nhiên nhỏ hơn cấp độ kỹ năng
    }

    // Phương thức để thực hiện hành động phòng thủ
    public boolean defend()  // Phương thức để thực hiện hành động phòng thủ
    {
        Random random = new Random(); // Tạo một đối tượng Random
        int chance = random.nextInt(100); // Tạo số ngẫu nhiên từ 0 đến 99
        return chance < skillLevel; // Thành công nếu số ngẫu nhiên nhỏ hơn cấp độ kỹ năng
    }

    // Getter cho tên người chơi
    public String getName()  // Phương thức trả về tên người chơi
    {
        return name;
    }
}

// Lớp Game để điều khiển trò chơi
class Game  // Lớp Game để điều khiển trò chơi
{
    private Player player1; // Người chơi 1
    private Player player2; // Người chơi 2

    // Constructor để khởi tạo trò chơi với hai người chơi
    public Game(Player player1, Player player2)  // Constructor với tham số người chơi 1 và người chơi 2
    {
        this.player1 = player1; // Gán người chơi 1 từ tham số
        this.player2 = player2; // Gán người chơi 2 từ tham số
    }

    // Phương thức bắt đầu trò chơi
    public void start()  // Phương thức bắt đầu trò chơi
    {
        Scanner scanner = new Scanner(System.in); // Tạo một đối tượng Scanner để đọc dữ liệu từ bàn phím
        boolean playing = true; // Biến để kiểm tra trạng thái trò chơi

        while (playing)  // Vòng lặp chính của trò chơi
        {
            System.out.println("Chọn hành động: ");
            System.out.println("1. Sút bóng");
            System.out.println("2. Chuyền bóng");
            System.out.println("3. Phòng thủ");
            System.out.println("4. Thoát trò chơi");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            switch (choice)  // Xử lý lựa chọn của người chơi
            {
                case 1:
                    if (player1.shoot())  
                    {
                        System.out.println(player1.getName() + " đã sút thành công!");
                    } 
                    else 
                    {
                        System.out.println(player1.getName() + " đã sút hỏng!");
                    }
                    break;
                case 2:
                    if (player1.pass()) 
                    {
                        System.out.println(player1.getName() + " đã chuyền thành công!");
                    } 
                    else 
                    {
                        System.out.println(player1.getName() + " đã chuyền hỏng!");
                    }
                    break;
                case 3:
                    if (player2.defend()) 
                    {
                        System.out.println(player2.getName() + " đã phòng thủ thành công!");
                    } 
                    else 
                    {
                        System.out.println(player2.getName() + " đã phòng thủ hỏng!");
                    }
                    break;
                case 4:
                    playing = false;
                    System.out.println("Thoát trò chơi.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            System.out.println();
        }
        scanner.close();
    }
}

// Lớp chính để thử nghiệm chương trình
public class FootballGameSimulation 
{
    public static void main(String[] args)      // Phương thức main để thực thi chương trình
    {
        // Tạo hai người chơi
        Player player1 = new Player("Nguyen Van A", 70); // Cấp độ kỹ năng 70%
        Player player2 = new Player("Le Thi B", 50);     // Cấp độ kỹ năng 50%

        // Tạo trò chơi
        Game game = new Game(player1, player2); // Tạo trò chơi với hai người chơi

        // Bắt đầu trò chơi
        game.start(); // Bắt đầu trò chơi
    }
}

// Kết quả bài 9
// Chọn hành động: 
// 1. Sút bóng
// 2. Chuyền bóng
// 3. Phòng thủ
// 4. Thoát trò chơi
// Lựa chọn của bạn: 1
// Nguyen Van A đã sút thành công!

// Chọn hành động: 
// 1. Sút bóng
// 2. Chuyền bóng
// 3. Phòng thủ
// 4. Thoát trò chơi
// Lựa chọn của bạn: 2
// Nguyen Van A đã chuyền thành công!

// Chọn hành động: 
// 1. Sút bóng
// 2. Chuyền bóng
// 3. Phòng thủ
// 4. Thoát trò chơi
// Lựa chọn của bạn: 3
// Le Thi B đã phòng thủ thành công!

// Chọn hành động: 
// 1. Sút bóng
// 2. Chuyền bóng
// 3. Phòng thủ
// 4. Thoát trò chơi
// Lựa chọn của bạn: 4
// Thoát trò chơi.
