// VIẾT BẰNG JAVA
// 3. Tạo lớp quản lý sinh viên với các thuộc tính

import java.util.ArrayList; // Import thư viện ArrayList
import java.util.Scanner; // Import thư viện Scanner

// Lớp SinhVien để quản lý thông tin sinh viên
class SinhVien // Lớp SinhVien để quản lý thông tin sinh viên
{
    private String maSinhVien; // Thuộc tính của sinh viên
    private String tenSinhVien; // Thuộc tính của sinh viên
    private int tuoi; // Thuộc tính của sinh viên
    private String lopHoc; // Thuộc tính của sinh viên
    private double diemTrungBinh; // Thuộc tính của sinh viên

    // Constructor
    public SinhVien(String maSinhVien, String tenSinhVien, int tuoi, String lopHoc, double diemTrungBinh) 
    // Constructor để tạo đối tượng sinh viên với các thông tin
    {
        this.maSinhVien = maSinhVien; 
        this.tenSinhVien = tenSinhVien;  
        this.tuoi = tuoi; 
        this.lopHoc = lopHoc;
        this.diemTrungBinh = diemTrungBinh;
    }

    // Phương thức hiển thị thông tin sinh viên
    public void hienThiThongTin() // Phương thức hiển thị thông tin sinh viên
    {
        System.out.println("Mã sinh viên: " + maSinhVien);
        System.out.println("Tên sinh viên: " + tenSinhVien);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Lớp học: " + lopHoc);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
        System.out.println("----------------------------");
    }

    // Getter cho maSinhVien
    public String getMaSinhVien() // Getter cho maSinhVien 
    {
        return maSinhVien;
    }
}

// Lớp QuanLySinhVien để quản lý danh sách sinh viên
class QuanLySinhVien // Lớp QuanLySinhVien để quản lý danh sách sinh viên
{
    private ArrayList<SinhVien> danhSachSinhVien;

    // Constructor
    public QuanLySinhVien() // Constructor để tạo danh sách sinh viên
    {
        danhSachSinhVien = new ArrayList<>();
    }

    // Phương thức thêm sinh viên vào danh sách
    public void themSinhVien(SinhVien sinhVien) // Phương thức thêm sinh viên vào danh sách
    {
        danhSachSinhVien.add(sinhVien);
    }

    // Phương thức hiển thị danh sách sinh viên
    public void hienThiDanhSachSinhVien() // Phương thức hiển thị danh sách sinh viên
    {
        for (SinhVien sinhVien : danhSachSinhVien) 
        {
            sinhVien.hienThiThongTin();
        }
    }

    // Phương thức tìm sinh viên theo mã sinh viên
    public SinhVien timSinhVienTheoMa(String maSinhVien) // Phương thức tìm sinh viên theo mã sinh viên
    {
        for (SinhVien sinhVien : danhSachSinhVien) // Duyệt từng sinh viên trong danh sách
        {
            if (sinhVien.getMaSinhVien().equals(maSinhVien)) // So sánh mã sinh viên
            {
                return sinhVien;
            }
        }
        return null;
    }
}

public class Main_QLSV 
{
    public static void main(String[] args) // Hàm main để chạy chương trình
    {
        Scanner scanner = new Scanner(System.in); // Khai báo đối tượng scanner để nhập dữ liệu
        QuanLySinhVien quanLySinhVien = new QuanLySinhVien();

        // Thêm một số sinh viên vào danh sách
        quanLySinhVien.themSinhVien(new SinhVien("SV001", "Nguyễn Văn A", 20, "CNTT1", 7.8));
        quanLySinhVien.themSinhVien(new SinhVien("SV002", "Trần Thị B", 21, "CNTT2", 8.5));
        quanLySinhVien.themSinhVien(new SinhVien("SV003", "Phạm Văn C", 19, "CNTT3", 6.9));

        // Hiển thị danh sách sinh viên
        System.out.println("Danh sách sinh viên:"); // Hiển thị danh sách sinh viên
        quanLySinhVien.hienThiDanhSachSinhVien();

        // Tìm sinh viên theo mã sinh viên
        System.out.print("Nhập mã sinh viên cần tìm: "); // Tìm sinh viên theo mã sinh viên
        String maSinhVien = scanner.nextLine();
        SinhVien sinhVienTimThay = quanLySinhVien.timSinhVienTheoMa(maSinhVien);

        if (sinhVienTimThay != null) // Kiểm tra xem sinh viên có tồn tại không
        {
            System.out.println("Thông tin sinh viên tìm thấy:");
            sinhVienTimThay.hienThiThongTin();
        } 
        else // Nếu không tìm thấy sinh viên
        {
            System.out.println("Không tìm thấy sinh viên với mã: " + maSinhVien);
        }
    }
}

// Kết quả:
// Danh sách sinh viên:
// Mã sinh viên: SV001
// Tên sinh viên: Nguyễn Văn A
// Tuổi: 20
// Lớp học: CNTT1
// Điểm trung bình: 7.8
// ----------------------------
// Mã sinh viên: SV002
// Tên sinh viên: Trần Thị B
// Tuổi: 21
// Lớp học: CNTT2
// Điểm trung bình: 8.5
// ----------------------------
// Mã sinh viên: SV003
// Tên sinh viên: Phạm Văn C
// Tuổi: 19
// Lớp học: CNTT3
// Điểm trung bình: 6.9
// ----------------------------
// Nhập mã sinh viên cần tìm: SV002
// Thông tin sinh viên tìm thấy:
// Mã sinh viên: SV002
// Tên sinh viên: Trần Thị B
// Tuổi: 21
// Lớp học: CNTT2
// Điểm trung bình: 8.5
// ----------------------------

