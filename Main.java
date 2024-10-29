// VIẾT BẰNG JAVA
// 1. Tạo lớp cho học sinh

class Student
{
    // Thuộc tính của học sinh
    private String name;
    private int age;
    private String studentClass;
    private double averageGrade;

    // Constructor (Hàm khởi tạo) để tạo đối tượng học sinh
    public Student(String name, int age, String studentClass, double averageGrade) 
    // Constructor (Hàm khởi tạo) để tạo đối tượng học sinh
    {
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
        this.averageGrade = averageGrade;
    }

    // Phương thức để hiển thị thông tin học sinh
    public void displayInfo() // Phương thức để hiển thị thông tin học sinh
    {
        System.out.println("Tên học sinh: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Lớp: " + studentClass);
        System.out.println("Điểm trung bình: " + averageGrade);
    }

    // Phương thức kiểm tra xem học sinh có đạt hay không
    public boolean isPassed() // Phương thức kiểm tra xem học sinh có đạt hay không
    {
        return averageGrade >= 5.0;
    }

    // Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    public String getName() //  Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    {
        return name;
    }

    public void setName(String name) //  Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    {
        this.name = name;
    }

    public int getAge() //  Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    {
        return age;
    }

    public void setAge(int age) //  Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    {
        this.age = age;
    }

    public String getStudentClass() //  Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    {
        return studentClass;
    }

    public void setStudentClass(String studentClass) //  Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    {
        this.studentClass = studentClass;
    }

    public double getAverageGrade() //  Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) //  Getter và Setter cho các thuộc tính (tùy chọn, không bắt buộc)
    {
        this.averageGrade = averageGrade;
    }
}

public class Main // Main class để chạy chương trình
{
    public static void main(String[] args) // Main class để chạy chương trình 
    {
        // Tạo đối tượng học sinh mới
        Student student1 = new Student("Nguyễn Văn A", 16, "10A1", 7.5);

        // Hiển thị thông tin học sinh
        student1.displayInfo(); // Hiển thị thông tin học sinh

        // Kiểm tra xem học sinh có đạt hay không
        if (student1.isPassed()) // Kiểm tra xem học sinh có đạt hay không
        {
            System.out.println(student1.getName() + " đã đạt.");
            // Kiểm tra xem học sinh có đạt hay không
        } 
        else 
        {
            System.out.println(student1.getName() + " chưa đạt.");
            // Kiểm tra xem học sinh có đạt hay không
        }
    }
}

// Kết quả:
// Tên học sinh: Nguyễn Văn A
// Tuổi: 16
// Lớp: 10A1
// Điểm trung bình: 7.5
// Nguyễn Văn A đã đạt.
