// VIẾT BẰNG JAVA
// 2. Tạo lớp hình chữ nhật (Rectangle) và tính diện tích, chu vi

class Rectangle // Tạo lớp hình chữ nhật (Rectangle) và tính diện tích, chu vi
{
    // Thuộc tính của hình chữ nhật
    private double length;
    private double width;

    // Constructor (Hàm khởi tạo) để tạo đối tượng hình chữ nhật
    public Rectangle(double length, double width) 
    // Constructor (Hàm khởi tạo) để tạo đối tượng hình chữ nhật
    {
        this.length = length;
        this.width = width;
    }

    // Phương thức tính diện tích
    public double calculateArea() // Phương thức tính diện tích
    {
        return length * width;
    }

    // Phương thức tính chu vi
    public double calculatePerimeter() // Phương thức tính chu vi
    {
        return 2 * (length + width);
    }

    // Getter và Setter cho chiều dài và chiều rộng (nếu cần)
    public double getLength() // Getter và Setter cho chiều dài và chiều rộng (nếu cần)
    {
        return length;
    }

    public void setLength(double length) // Getter và Setter cho chiều dài và chiều rộng (nếu cần)
    {
        this.length = length;
    }

    public double getWidth() // Getter và Setter cho chiều dài và chiều rộng (nếu cần)
    {
        return width;
    }

    public void setWidth(double width) // Getter và Setter cho chiều dài và chiều rộng (nếu cần)
    {
        this.width = width;
    }
}

public class Main_Class
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Tạo đối tượng hình chữ nhật với chiều dài và chiều rộng
        Rectangle rectangle1 = new Rectangle(5.0, 3.0); 
        // Tạo đối tượng hình chữ nhật với chiều dài và chiều rộng

        // Tính và hiển thị diện tích và chu vi
        double area = rectangle1.calculateArea(); // Tính và hiển thị diện tích và chu vi
        double perimeter = rectangle1.calculatePerimeter(); // Tính và hiển thị diện tích và chu vi

        System.out.println("Chiều dài: " + rectangle1.getLength()); // Hiển thị chiều dài
        System.out.println("Chiều rộng: " + rectangle1.getWidth()); // Hiển thị chiều rộng
        System.out.println("Diện tích hình chữ nhật: " + area); // Hiển thị diện tích
        System.out.println("Chu vi hình chữ nhật: " + perimeter); // Hiển thị chu vi
    }
}

// Kết quả:
// Chiều dài: 5.0
// Chiều rộng: 3.0
// Diện tích hình chữ nhật: 15.0
// Chu vi hình chữ nhật: 16.0

