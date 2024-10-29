// VIẾT BẰNG JAVA
// 4. Tạo lớp xe hơi với các phương thức chạy, dừng, báo hiệu

// Lớp Car để quản lý thông tin và hành vi của xe hơi
class Car 
{
    // Thuộc tính của xe hơi
    private String brand;  // Thương hiệu
    private String model;  // Mẫu xe
    private int year;      // Năm sản xuất
    private boolean isRunning;  // Trạng thái xe đang chạy hay không

    // Constructor (Hàm khởi tạo) để tạo đối tượng xe hơi
    public Car(String brand, String model, int year) // Constructor để tạo đối tượng xe hơi
    {
        this.brand = brand; 
        this.model = model;
        this.year = year;
        this.isRunning = false;  // Mặc định xe chưa chạy
    }

    // Phương thức bắt đầu chạy xe
    public void start() // Phương thức bắt đầu chạy xe
    {
        if (!isRunning) 
        {
            isRunning = true;
            System.out.println(brand + " " + model + " đã bắt đầu chạy.");
        }
        else 
        {
            System.out.println(brand + " " + model + " đã đang chạy rồi.");
        }
    }

    // Phương thức dừng xe
    public void stop() // Phương thức dừng xe
    {
        if (isRunning) 
        {
            isRunning = false;
            System.out.println(brand + " " + model + " đã dừng lại.");
        } 
        else 
        {
            System.out.println(brand + " " + model + " đang dừng, không thể dừng nữa.");
        }
    }

    // Phương thức báo hiệu bằng còi xe
    public void honk() // Phương thức báo hiệu bằng còi xe
    {
        System.out.println(brand + " " + model + " kêu: Bíp! Bíp!");
    }

    // Getter cho thông tin xe
    public String getBrand() // Getter cho thông tin xe
    {
        return brand;
    }

    public String getModel() // Getter cho thông tin xe
    {
        return model;
    }

    public int getYear() // Getter cho thông tin xe
    {
        return year;
    }

    // Phương thức hiển thị thông tin xe
    public void displayInfo() // Phương thức hiển thị thông tin xe
    {
        System.out.println("Thương hiệu: " + brand);
        System.out.println("Mẫu xe: " + model);
        System.out.println("Năm sản xuất: " + year);
        System.out.println("Trạng thái: " + (isRunning ? "Đang chạy" : "Đang dừng"));
    }
}

public class Main_CAR // Lớp Main_CAR để chạy chương trình
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        // Tạo đối tượng xe hơi với thương hiệu, mẫu xe và năm sản xuất
        Car car1 = new Car("Toyota", "Camry", 2021);

        // Hiển thị thông tin xe
        car1.displayInfo();

        // Chạy xe
        car1.start();

        // Báo hiệu bằng còi xe
        car1.honk();

        // Dừng xe
        car1.stop();

        // Thử dừng xe khi xe đã dừng
        car1.stop();
    }
}

// Kết quả:
// Thương hiệu: Toyota
// Mẫu xe: Camry
// Năm sản xuất: 2021
// Trạng thái: Đang dừng
// Toyota Camry đã bắt đầu chạy.
// Toyota Camry kêu: Bíp! Bíp!
// Toyota Camry đã dừng lại.
// Toyota Camry đang dừng, không thể dừng nữa.

