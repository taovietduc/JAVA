// VIẾT BẰNG JAVA
// 7. Tạo lớp nhân viên và tính lương

// Lớp cơ bản Employee đại diện cho một nhân viên
class Employee 
{
    private String name;         // Tên nhân viên
    private String id;           // Mã nhân viên
    private double salary;       // Lương cơ bản

    // Constructor để khởi tạo nhân viên với tên, mã và lương cơ bản
    public Employee(String name, String id, double salary) 
    {
        this.name = name; // Tên nhân viên
        this.id = id;// Mã nhân viên
        this.salary = salary; // Lương cơ bản
    }

    // Phương thức tính lương (có thể được override trong các lớp con)
    public double calculateSalary() 
    {
        return salary;
    }

    // Phương thức hiển thị thông tin nhân viên
    public void displayEmployeeInfo()   // Phương thức hiển thị thông tin nhân viên
    {
        System.out.println("Tên nhân viên: " + name);
        System.out.println("Mã nhân viên: " + id);
        System.out.println("Lương: " + calculateSalary() + " VND");
    }

    // Getter cho tên nhân viên
    public String getName()  // Getter cho tên nhân viên
    {
        return name;
    }

    // Getter cho mã nhân viên
    public String getId()  // Getter cho mã nhân viên
    {
        return id;
    }
}

// Lớp FullTimeEmployee đại diện cho nhân viên làm việc toàn thời gian
class FullTimeEmployee extends Employee // Kế thừa từ lớp Employee
{
    // Constructor cho nhân viên toàn thời gian
    public FullTimeEmployee(String name, String id, double salary) /// Constructor  của lớp FullTimeEmployee
    {
        super(name, id, salary);
    }

    // Nhân viên toàn thời gian hưởng lương cố định, nên không cần override phương thức calculateSalary()
}

// Lớp PartTimeEmployee đại diện cho nhân viên làm việc bán thời gian
class PartTimeEmployee extends Employee // Kế thừa từ lớp Employee
{
    private int hoursWorked;      // Số giờ làm việc
    private double hourlyRate;    // Lương theo giờ

    // Constructor cho nhân viên bán thời gian
    public PartTimeEmployee(String name, String id, double hourlyRate, int hoursWorked) 
    {
        super(name, id, 0);  // Lương cơ bản là 0 vì lương tính theo giờ
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Tính lương cho nhân viên bán thời gian dựa trên số giờ làm và lương theo giờ
    @Override
    public double calculateSalary() 
    {
        return hourlyRate * hoursWorked;
    }
}
// Lớp chính để thử nghiệm chương trình
public class EmployeeManagementSystem  // Lớp EmployeeManagementSystem để thực thi chương trình
{
    public static void main(String[] args)  // Hàm main để chạy chương trình EmployeeManagementSystem
    {
        // Tạo đối tượng nhân viên toàn thời gian
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Nguyen Van A", "FT123", 15000000);

        // Tạo đối tượng nhân viên bán thời gian
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Le Thi B", "PT456", 50000, 80);

        // Hiển thị thông tin và lương của nhân viên toàn thời gian
        System.out.println("Thông tin nhân viên toàn thời gian:");
        fullTimeEmployee.displayEmployeeInfo();

        System.out.println();

        // Hiển thị thông tin và lương của nhân viên bán thời gian
        System.out.println("Thông tin nhân viên bán thời gian:");
        partTimeEmployee.displayEmployeeInfo();
    }
}

// Kết quả khi chạy chương trình:
// Thông tin nhân viên toàn thời gian:
// Tên nhân viên: Nguyen Van A
// Mã nhân viên: FT123
// Lương: 15000000.0 VND

// Thông tin nhân viên bán thời gian:
// Tên nhân viên: Le Thi B
// Mã nhân viên: PT456
// Lương: 4000000.0 VND

