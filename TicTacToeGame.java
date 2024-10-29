// VIẾT BẰNG JAVA
// 27. Tạo game Tic-Tac-Toe

import java.util.Scanner; // Import thư viện để lấy input từ người dùng

public class TicTacToeGame // Class chính của chương trình TicTacToeGame
{
    private static char[][] board = new char[3][3]; // Bảng 3x3 cho trò chơi
    private static char currentPlayer = 'X'; // Người chơi hiện tại (X bắt đầu trước)

    public static void main(String[] args) // Phương thức main chính của chương trình TicTacToeGame
    {
        initializeBoard(); // Khởi tạo bảng chơi
        printBoard(); // In bảng trống ban đầu

        while (true) {
            playerMove(); // Nhận lượt chơi từ người chơi
            printBoard(); // In bảng sau khi điền
            if (checkWinner()) // Kiểm tra nếu có người chiến thắng
            {
                System.out.println("Chúc mừng! Người chơi " + currentPlayer + " đã thắng!");
                break;
            }
            if (isBoardFull()) // Kiểm tra nếu bảng đầy
            {
                System.out.println("Trò chơi hòa!");
                break;
            }
            switchPlayer(); // Chuyển lượt cho người chơi khác
        }
    }

    // Khởi tạo bảng với các ô trống
    public static void initializeBoard() // Phương thức khởi tạo bảng
    {
        for (int i = 0; i < 3; i++) // Duyệt qua hàng
        {
            for (int j = 0; j < 3; j++) // Duyệt qua cột
            {
                board[i][j] = '-'; // Đặt mỗi ô thành dấu gạch ngang
            }
        }
    }

    // In bảng ra màn hình
    public static void printBoard() // Phương thức in bảng
    {
        System.out.println("Bảng trò chơi:"); // In tiêu đề bảng
        for (int i = 0; i < 3; i++) // Duyệt qua hàng
        {
            for (int j = 0; j < 3; j++) //  Duyệt qua cột
            {
                System.out.print(board[i][j] + " "); // In giá trị của ô
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }
    }

    // Nhận lượt chơi từ người chơi
    public static void playerMove() // Phương thức lượt chơi của người chơi
    {
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng Scanner để nhận input từ người dùng
        int row, col;

        while (true) // Vòng lặp để nhận input hợp lệ
        {
            System.out.println("Người chơi " + currentPlayer + ", nhập hàng (1-3) và cột (1-3): ");
            row = scanner.nextInt() - 1; // Chuyển từ 1-3 sang chỉ số 0-2
            col = scanner.nextInt() - 1; // Chuyển từ 1-3 sang chỉ số 0-2

            // Kiểm tra ô đã được đánh dấu hay chưa
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') // Nếu ô hợp lệ
            {
                board[row][col] = currentPlayer; // Đánh dấu ô với người chơi hiện tại
                break;
            } 
            else // Nếu ô không hợp lệ
            {
                System.out.println("Vị trí này không hợp lệ. Hãy thử lại."); // Thông báo lỗi
            }
        }
    }

    // Kiểm tra nếu có người chiến thắng
    public static boolean checkWinner() // Phương thức kiểm tra người chiến thắng
    {
        // Kiểm tra các hàng
        for (int i = 0; i < 3; i++) // Duyệt qua hàng
        {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) // Nếu cả 3 ô cùng dấu
            {
                return true; // Nếu có hàng nào đó có cùng dấu thì trả về true
            }
        }

        // Kiểm tra các cột
        for (int i = 0; i < 3; i++) // Duyệt qua cột
        {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) // Nếu cả 3 ô cùng dấu
            {
                return true; // Nếu có cột nào đó có cùng dấu thì trả về true
            }
        }

        // Kiểm tra hai đường chéo
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) // Kiểm tra đường chéo chính
        {
            return true; // Nếu đường chéo chính có cùng dấu thì trả về true
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) // Kiểm tra đường chéo phụ
        {
            return true; // Nếu đường chéo phụ có cùng dấu thì trả về true
        }

        return false;
    }

    // Kiểm tra nếu bảng đầy (hòa)
    public static boolean isBoardFull() // Phương thức kiểm tra bảng đầy
    {
        for (int i = 0; i < 3; i++) // Duyệt qua hàng
        {
            for (int j = 0; j < 3; j++) // Duyệt qua cột
            {
                if (board[i][j] == '-') // Nếu còn ô trống
                {
                    return false; // Nếu còn ô trống thì trả về false
                }
            }
        }
        return true;
    }

    // Chuyển đổi người chơi
    public static void switchPlayer() // Phương thức chuyển lượt chơi
    {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Chuyển lượt chơi cho người chơi khác
    }
}

// Ví dụ:
// Bảng trò chơi:
// - - -
// - - -
// - - -
// Người chơi X, nhập hàng (1-3) và cột (1-3): 1 1
// Bảng trò chơi:
// X - -
// - - -
// - - -
// Người chơi O, nhập hàng (1-3) và cột (1-3): 1 2
// Bảng trò chơi:
// X O -
// - - -
// - - -
// ...

