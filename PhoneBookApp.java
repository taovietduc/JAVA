// VIẾT BẰNG JAVA
// 1. Quản lý danh bạ điện thoại

import java.util.ArrayList; // Import ArrayList để sử dụng danh sách động
import java.util.Scanner;   // Import Scanner để nhập dữ liệu từ bàn phím

// Lớp Contact đại diện cho một liên hệ trong danh bạ
class Contact 
{
    private String name;   // Tên liên hệ
    private String phone;  // Số điện thoại

    // Constructor để khởi tạo liên hệ
    public Contact(String name, String phone)  // Constructor với tham số tên và số điện thoại
    {
        this.name = name;  // Gán tên liên hệ
        this.phone = phone; // Gán số điện thoại
    }

    // Getter cho tên liên hệ
    public String getName()  // Phương thức trả về tên liên hệ
    {
        return name; // Trả về tên liên hệ
    }

    // Getter cho số điện thoại
    public String getPhone()  // Phương thức trả về số điện thoại
    {
        return phone; // Trả về số điện thoại
    }

    // Phương thức hiển thị thông tin liên hệ
    public void displayContact()  // Phương thức hiển thị thông tin liên hệ
    {
        System.out.println("Tên: " + name); // Hiển thị tên
        System.out.println("Số điện thoại: " + phone); // Hiển thị số điện thoại
    }
}

// Lớp PhoneBook để quản lý danh bạ
class PhoneBook  // Lớp PhoneBook để quản lý danh bạ
{
    private ArrayList<Contact> contacts; // Danh sách liên hệ

    // Constructor để khởi tạo danh bạ
    public PhoneBook()   // Constructor để khởi tạo danh bạ
    {
        contacts = new ArrayList<>(); // Khởi tạo danh sách liên hệ
    }

    // Phương thức thêm liên hệ mới
    public void addContact(Contact contact) // Phương thức thêm liên hệ mới    
    {
        contacts.add(contact); // Thêm liên hệ vào danh sách
        System.out.println("Đã thêm liên hệ thành công."); // Hiển thị thông báo
    }

    // Phương thức xóa liên hệ theo tên
    public void deleteContact(String name) // Phương thức xóa liên hệ theo tên
    {
        boolean found = false; // Biến kiểm tra xem liên hệ có tồn tại không
        for (int i = 0; i < contacts.size(); i++)  // Duyệt qua danh sách liên hệ
        {
            if (contacts.get(i).getName().equalsIgnoreCase(name))  // Nếu tìm thấy liên hệ cần xóa
            {
                contacts.remove(i); // Xóa liên hệ khỏi danh sách
                System.out.println("Đã xóa liên hệ thành công.");
                found = true; // Đánh dấu là đã tìm thấy liên hệ
                break;
            }
        }
        if (!found)  // Nếu không tìm thấy liên hệ cần xóa
        {
            System.out.println("Không tìm thấy liên hệ có tên: " + name);
        }
    }

    // Phương thức tìm kiếm liên hệ theo tên
    public void searchContact(String name)  // Phương thức tìm kiếm liên hệ theo tên
    {
        boolean found = false; // Biến kiểm tra xem liên hệ có tồn tại không
        for (Contact contact : contacts)  // Duyệt qua danh sách liên hệ
        {
            if (contact.getName().equalsIgnoreCase(name))  // Nếu tìm thấy liên hệ cần tìm
            {
                contact.displayContact(); // Hiển thị thông tin liên hệ
                found = true;
                break;
            }
        }
        if (!found)  // Nếu không tìm thấy liên hệ cần tìm
        {
            System.out.println("Không tìm thấy liên hệ có tên: " + name); // Hiển thị thông báo
        }
    }

    // Phương thức hiển thị tất cả các liên hệ trong danh bạ
    public void displayAllContacts()  // Phương thức hiển thị tất cả các liên hệ trong danh bạ
    {
        if (contacts.isEmpty())  // Nếu danh bạ trống
        {
            System.out.println("Danh bạ trống."); // Hiển thị thông báo
        } 
        else  // Nếu danh bạ không trống
        {
            System.out.println("Danh sách liên hệ:"); // Hiển thị thông báo
            for (Contact contact : contacts)  // Duyệt qua danh sách liên hệ
            {
                contact.displayContact(); // Hiển thị thông tin liên hệ
                System.out.println(); // Xuống dòng sau mỗi liên hệ
            }
        }
    }
}

// Lớp chính để chạy chương trình
public class PhoneBookApp  // Lớp chính để chạy chương trình
{
    public static void main(String[] args)  // Phương thức main để chạy chương trình
    {
        PhoneBook phoneBook = new PhoneBook(); // Khởi tạo danh bạ
        Scanner scanner = new Scanner(System.in); // Đối tượng Scanner để nhập dữ liệu từ bàn phím
        boolean running = true; // Biến kiểm tra chương trình đang chạy hay không

        while (running)  // Vòng lặp chính của chương trình
        {
            System.out.println("Quản lý danh bạ điện thoại:"); // Hiển thị menu chính
            System.out.println("1. Thêm liên hệ"); // Hiển thị các lựa chọn
            System.out.println("2. Xóa liên hệ"); // Hiển thị các lựa chọn
            System.out.println("3. Tìm kiếm liên hệ"); // Hiển thị các lựa chọn
            System.out.println("4. Hiển thị tất cả liên hệ"); // Hiển thị các lựa chọn
            System.out.println("5. Thoát"); // Hiển thị các lựa chọn
            System.out.print("Chọn hành động: "); // Nhập lựa chọn từ bàn phím
            int choice = scanner.nextInt(); // Đọc số từ bàn phím
            scanner.nextLine(); // Đọc dòng mới sau khi nhập số

            switch (choice)  // Xử lý lựa chọn của người dùng
            {
                case 1:
                    // Thêm liên hệ mới
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();
                    phoneBook.addContact(new Contact(name, phone));
                    break;

                case 2:
                    // Xóa liên hệ
                    System.out.print("Nhập tên liên hệ cần xóa: ");
                    String nameToDelete = scanner.nextLine();
                    phoneBook.deleteContact(nameToDelete);
                    break;

                case 3:
                    // Tìm kiếm liên hệ
                    System.out.print("Nhập tên liên hệ cần tìm: ");
                    String nameToSearch = scanner.nextLine();
                    phoneBook.searchContact(nameToSearch);
                    break;

                case 4:
                    // Hiển thị tất cả liên hệ
                    phoneBook.displayAllContacts();
                    break;

                case 5:
                    // Thoát chương trình
                    running = false;
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            System.out.println(); // Xuống dòng sau mỗi lần chạy lựa chọn
        }
        scanner.close(); // Đóng đối tượng Scanner
    }
}
// HẾT

// Kết quả chạy chương trình
// Quản lý danh bạ điện thoại:
// 1. Thêm liên hệ
// 2. Xóa liên hệ
// 3. Tìm kiếm liên hệ
// 4. Hiển thị tất cả liên hệ
// 5. Thoát
// Chọn hành động: 1
// Nhập tên: Nguyễn Văn A
// Nhập số điện thoại: 0123456789
// Đã thêm liên hệ thành công.

// Quản lý danh bạ điện thoại:
// 1. Thêm liên hệ
// 2. Xóa liên hệ
// 3. Tìm kiếm liên hệ
// 4. Hiển thị tất cả liên hệ
// 5. Thoát
// Chọn hành động: 4
// Danh sách liên hệ:
// Tên: Nguyễn Văn A
// Số điện thoại: 0123456789

