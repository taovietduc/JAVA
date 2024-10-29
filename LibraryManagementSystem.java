// VIẾT BẰNG JAVA
// 8. Tạo lớp Sách và quản lý thư viện

import java.util.ArrayList; // Import ArrayList từ gói java.util để sử dụng ArrayList
import java.util.Scanner;   // Import Scanner từ gói java.util để sử dụng Scanner

// Lớp Sách
class Book 
{
    private String title;       // Tên sách
    private String author;      // Tác giả
    private String isbn;        // Mã ISBN
    private int year;           // Năm xuất bản

    // Constructor để khởi tạo sách
    public Book(String title, String author, String isbn, int year)  
    // Constructor với tham số tên sách, tác giả, mã ISBN và năm xuất bản
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    // Getter cho tên sách
    public String getTitle()    // Phương thức trả về tên sách
    {
        return title;          // Trả về tên sách
    }

    // Phương thức hiển thị thông tin sách
    public void displayInfo()  // Phương thức hiển thị thông tin sách
    {
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Mã ISBN: " + isbn);
        System.out.println("Năm xuất bản: " + year);
        System.out.println();
    }
}

// Lớp Thư viện để quản lý sách
class Library  // Lớp Thư viện để quản lý sách
{
    private ArrayList<Book> books;  // Danh sách sách

    // Constructor để khởi tạo thư viện
    public Library()  // Constructor để khởi tạo thư viện với danh sách sách rỗng
    {
        books = new ArrayList<>(); // Khởi tạo danh sách sách
    }

    // Phương thức thêm sách vào thư viện
    public void addBook(Book book)  // Phương thức thêm sách vào thư viện
    {
        books.add(book); // Thêm sách vào danh sách sách
        System.out.println("Đã thêm sách: " + book.getTitle());
    }

    // Phương thức hiển thị danh sách sách trong thư viện
    public void displayBooks()  // Phương thức hiển thị danh sách sách trong thư viện
    {
        System.out.println("Danh sách sách trong thư viện:");
        for (Book book : books)  // Duyệt qua danh sách sách
        {
            book.displayInfo(); // Hiển thị thông tin sách
        }
    }

    // Phương thức tìm kiếm sách theo tên
    public void searchBookByTitle(String title)  // Phương thức tìm kiếm sách theo tên
    {
        boolean found = false; // Biến kiểm tra sách có được tìm thấy hay không
        for (Book book : books)  // Duyệt qua danh sách sách
        {
            if (book.getTitle().equalsIgnoreCase(title))  // So sánh tên sách 
            {
                System.out.println("Sách tìm thấy:"); // Hiển thị thông báo sách tìm thấy
                book.displayInfo(); // Hiển thị thông tin sách
                found = true;
                break;
            }
        }
        if (!found)  // Nếu sách không được tìm thấy thì hiển thị thông báo
        {
            System.out.println("Không tìm thấy sách với tên: " + title);
        }
    }
}

// Lớp chính để thử nghiệm chương trình
public class LibraryManagementSystem  // Lớp chính để thử nghiệm chương trình
{
    public static void main(String[] args)  // Phương thức main để thực thi chương trình
    {
        Library library = new Library();  // Khởi tạo thư viện
        Scanner scanner = new Scanner(System.in);

        // Thêm sách vào thư viện
        library.addBook(new Book("Java Programming", "John Doe", "123456789", 2020));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "987654321", 2018));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "456789123", 2008));

        // Hiển thị danh sách sách trong thư viện
        library.displayBooks(); // Hiển thị danh sách sách trong thư viện

        // Tìm kiếm sách theo tên
        System.out.print("Nhập tên sách để tìm kiếm: "); // Nhập tên sách để tìm kiếm
        String searchTitle = scanner.nextLine(); // Đọc tên sách từ bàn phím
        library.searchBookByTitle(searchTitle); // Tìm kiếm sách theo tên

        scanner.close(); // Đóng Scanner
    }
}

// Kết quả bài 8
// Đã thêm sách: Java Programming
// Đã thêm sách: Effective Java
// Đã thêm sách: Clean Code
// Danh sách sách trong thư viện:
// Tên sách: Java Programming
// Tác giả: John Doe
// Mã ISBN: 123456789
// Năm xuất bản: 2020

// Tên sách: Effective Java
// Tác giả: Joshua Bloch
// Mã ISBN: 987654321
// Năm xuất bản: 2018

// Tên sách: Clean Code
// Tác giả: Robert C. Martin
// Mã ISBN: 456789123
// Năm xuất bản: 2008

// Nhập tên sách để tìm kiếm: Effective Java
// Sách tìm thấy:
// Tên sách: Effective Java
// Tác giả: Joshua Bloch
// Mã ISBN: 987654321
// Năm xuất bản: 2018
