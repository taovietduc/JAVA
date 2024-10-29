// VIẾT BẰNG JAVA
// 5. Mô phỏng ATM đơn giản

import java.util.Scanner;

class ATM // Lớp ATM mô phỏng hệ thống máy ATM
{
    // Biến lưu trữ số dư tài khoản
    private double balance;

    // Constructor khởi tạo số dư ban đầu
    public ATM(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    // Phương thức kiểm tra số dư
    public void checkBalance()  // Phương thức kiểm tra số dư
    {
        System.out.println("Số dư tài khoản hiện tại của bạn là: " + balance + " VND");
    }

    // Phương thức gửi tiền vào tài khoản
    public void deposit(double amount)  // Phương thức gửi tiền vào tài khoản
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Bạn đã gửi " + amount + " VND vào tài khoản.");
            checkBalance();
        } 
        else 
        {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
        }
    }
    // Phương thức rút tiền từ tài khoản
    public void withdraw(double amount)  // Phương thức rút tiền từ tài khoản
    {
        if (amount > 0 && amount <= balance)  // Nếu số tiền rút lớn hơn 0 và không vượt quá số dư
        {
            balance -= amount;
            System.out.println("Bạn đã rút " + amount + " VND từ tài khoản.");
            checkBalance();
        } 
        else if (amount > balance)  // Nếu số tiền rút lớn hơn số dư
        {
            System.out.println("Số dư không đủ để rút " + amount + " VND.");
        } 
        else 
        {
            System.out.println("Số tiền rút phải lớn hơn 0.");
        }
    }

    // Phương thức thoát khỏi hệ thống
    public void exit()  // Phương thức thoát khỏi hệ thống
    {
        System.out.println("Cảm ơn đã sử dụng dịch vụ. Tạm biệt!");
    }
}

public class ATMSimulation // Main class để chạy chương trình ATM
{
    public static void main(String[] args) // Main class để chạy chương trình ATM
    {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(5000000); // Tạo tài khoản với số dư ban đầu là 5,000,000 VND

        int choice; // Biến lưu trữ lựa chọn của người dùng
        do 
        {
            // Hiển thị menu lựa chọn
            System.out.println("\n--- Mô phỏng ATM ---");
            System.out.println("1. Kiểm tra số dư");
            System.out.println("2. Gửi tiền");
            System.out.println("3. Rút tiền");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) // Xử lý lựa chọn
            {
                case 1:
                    atm.checkBalance(); // Gọi phương thức kiểm tra số dư
                    break;
                case 2:
                    System.out.print("Nhập số tiền muốn gửi: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Nhập số tiền muốn rút: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    atm.exit(); // Gọi phương thức thoát khỏi hệ thống
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } 
        while (choice != 4); // Lặp lại cho đến khi người dùng chọn thoát

        scanner.close();
    }
}
