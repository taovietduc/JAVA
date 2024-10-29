// VIẾT BẰNG JAVA
// 6. Quản lý tài khoản ngân hàng

import java.util.Scanner;

// Lớp BankAccount đại diện cho một tài khoản ngân hàng
class BankAccount 
{
    // Các thuộc tính của tài khoản
    private String accountHolder;  // Tên chủ tài khoản
    private String accountNumber;  // Số tài khoản
    private double balance;        // Số dư tài khoản

    // Constructor để khởi tạo tài khoản với tên chủ tài khoản, số tài khoản và số dư ban đầu
    public BankAccount(String accountHolder, String accountNumber, double initialBalance)  // Constructor để khởi tạo tài khoản
    {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Phương thức kiểm tra số dư
    public void checkBalance()  // Phương thức kiểm tra số dư
    {
        System.out.println("Số dư tài khoản hiện tại là: " + balance + " VND");
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
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Bạn đã rút " + amount + " VND.");
            checkBalance();
        } else if (amount > balance) 
        {
            System.out.println("Số dư không đủ để rút.");
        } 
        else 
        {
            System.out.println("Số tiền rút phải lớn hơn 0.");
        }
    }

    // Phương thức hiển thị thông tin tài khoản
    public void displayAccountInfo() 
    {
        System.out.println("Chủ tài khoản: " + accountHolder);
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Số dư: " + balance + " VND");
    }

    // Getter cho tên chủ tài khoản
    public String getAccountHolder()  // Getter cho tên chủ tài khoản
    {
        return accountHolder;
    }

    // Getter cho số tài khoản
    public String getAccountNumber()  // Getter cho số tài khoản
    {
        return accountNumber;
    }
}

public class BankManagementSystem 
{
    public static void main(String[] args)  // Hàm main để chạy chương trình BankManagementSystem
    {
        Scanner scanner = new Scanner(System.in); // Tạo đối tượng Scanner để nhận dữ liệu từ bàn phím

        // Tạo mảng các tài khoản ngân hàng
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount("Nguyen Van A", "1234567890", 10000000);
        accounts[1] = new BankAccount("Le Thi B", "0987654321", 5000000);
        accounts[2] = new BankAccount("Tran Van C", "1122334455", 7500000);

        int choice;
        do  // Vòng lặp để hiển thị menu chính và xử lý lựa chọn của người dùng
        {
            System.out.println("\n--- Quản lý tài khoản ngân hàng ---");
            System.out.println("1. Hiển thị danh sách tài khoản");
            System.out.println("2. Chọn tài khoản để giao dịch");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice)  // Xử lý lựa chọn của người dùng
            {
                case 1:
                    // Hiển thị danh sách các tài khoản
                    for (int i = 0; i < accounts.length; i++) 
                    {
                        System.out.println((i + 1) + ". " + accounts[i].getAccountHolder() + " - " + accounts[i].getAccountNumber());
                    }
                    break;
                case 2:
                    System.out.print("Nhập số thứ tự tài khoản bạn muốn giao dịch (1-3): ");
                    int accountIndex = scanner.nextInt() - 1;

                    if (accountIndex >= 0 && accountIndex < accounts.length) 
                    {
                        BankAccount selectedAccount = accounts[accountIndex];
                        int transactionChoice;
                        do {
                            System.out.println("\n--- Giao dịch tài khoản ---");
                            System.out.println("1. Kiểm tra số dư");
                            System.out.println("2. Gửi tiền");
                            System.out.println("3. Rút tiền");
                            System.out.println("4. Hiển thị thông tin tài khoản");
                            System.out.println("5. Quay lại menu chính");
                            System.out.print("Lựa chọn của bạn: ");
                            transactionChoice = scanner.nextInt();

                            switch (transactionChoice)  // Xử lý các giao dịch tài khoản
                            {
                                case 1:
                                    selectedAccount.checkBalance(); // Kiểm tra số dư tài khoản
                                    break;
                                case 2:
                                    System.out.print("Nhập số tiền muốn gửi: "); // Gửi tiền vào tài khoản
                                    double depositAmount = scanner.nextDouble();
                                    selectedAccount.deposit(depositAmount);
                                    break;
                                case 3:
                                    System.out.print("Nhập số tiền muốn rút: "); // Rút tiền từ tài khoản
                                    double withdrawAmount = scanner.nextDouble();   
                                    selectedAccount.withdraw(withdrawAmount);
                                    break;
                                case 4:
                                    selectedAccount.displayAccountInfo(); // Hiển thị thông tin tài khoản
                                    break;
                                case 5:
                                    System.out.println("Quay lại menu chính...");
                                    break;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                                    break;
                            }
                        } while (transactionChoice != 5); // Lặp lại giao dịch cho tài khoản cho đến khi người dùng chọn thoát
                    } 
                    else 
                    {
                        System.out.println("Tài khoản không hợp lệ."); // Thông báo nếu tài khoản không hợp lệ
                    }
                    break;
                case 3:
                    System.out.println("Cảm ơn đã sử dụng dịch vụ."); // Thoát khỏi chương trình
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại."); // Thông báo nếu lựa chọn không hợp lệ
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}

// KET QUA CHUONG TRINH
// --- Quản lý tài khoản ngân hàng ---
// 1. Hiển thị danh sách tài khoản
// 2. Chọn tài khoản để giao dịch
// 3. Thoát
// Lựa chọn của bạn: 1
// 1. Nguyen Van A - 1234567890
// 2. Le Thi B - 0987654321
// 3. Tran Van C - 1122334455

// --- Quản lý tài khoản ngân hàng ---
// 1. Hiển thị danh sách tài khoản
// 2. Chọn tài khoản để giao dịch
// 3. Thoát
// Lựa chọn của bạn: 2
// Nhập số thứ tự tài khoản bạn muốn giao dịch (1-3): 1

// --- Giao dịch tài khoản ---
// 1. Kiểm tra số dư
// 2. Gửi tiền
// 3. Rút tiền
// 4. Hiển thị thông tin tài khoản
// 5. Quay lại menu chính
// Lựa chọn của bạn: 1
// Số dư tài khoản hiện tại là: 10000000.0 VND
