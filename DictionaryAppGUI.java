// VIẾT BẰNG JAVA
// Tạo ứng dụng từ điển đơn giản với giao diện người dùng (GUI) bằng Java Swing

import javax.swing.*; // Thư viện giao diện
import java.awt.*; // Thư viện giao diện
import java.awt.event.ActionEvent; // Thư viện xử lý sự kiện
import java.awt.event.ActionListener; // Thư viện xử lý sự kiện
import java.util.HashMap; // Thư viện HashMap

public class DictionaryAppGUI extends JFrame // Kế thừa từ JFrame để tạo giao diện
{
    private HashMap<String, String> dictionary;     // HashMap để lưu từ điển
    private JTextField inputField;                  // TextField để nhập từ
    private JTextField outputField;                // TextField để hiển thị kết quả
    private JButton translateButton;              // Button dịch từ
    private JButton addWordButton;              // Button thêm từ mới

    public DictionaryAppGUI()  // Hàm khởi tạo của lớp DictionaryAppGUI
    {
        // Khởi tạo từ điển HashMap
        dictionary = new HashMap<>(); // HashMap<kiểu key, kiểu value> tênHashMap = new HashMap<>();
        dictionary.put("hello", "xin chào"); // dictionary.put(key, value)
        dictionary.put("goodbye", "tạm biệt"); // dictionary.put(key, value)
        dictionary.put("book", "quyển sách"); // dictionary.put(key, value)
        dictionary.put("computer", "máy tính"); // dictionary.put(key, value)

        // Cài đặt cửa sổ chính
        setTitle("Ứng dụng Từ Điển"); // Tiêu đề cửa sổ
        setSize(600, 300); // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Khi đóng cửa sổ thì kết thúc chương trình
        setLocationRelativeTo(null); // Căn giữa cửa sổ khi chạy
        setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để căn giữa các thành phần
        getContentPane().setBackground(new Color(240, 248, 255)); // Nền màu xanh nhạt

        // Tạo đối tượng GridBagConstraints để quản lý bố cục
        GridBagConstraints gbc = new GridBagConstraints(); // Tạo đối tượng GridBagConstraints
        gbc.insets = new Insets(10, 10, 10, 10); // Căn lề giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL; // Căn các thành phần theo chiều ngang
        gbc.gridwidth = 1; // Số ô chiếm trên lưới là 1  

        // Label nhập từ
        JLabel inputLabel = new JLabel("Nhập từ:"); // Tạo Label "Nhập từ:"
        inputLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Font chữ Arial, đậm, kích thước 16
        inputLabel.setForeground(new Color(25, 25, 112)); // Màu xanh đậm (RGB: 25, 25, 112)
        gbc.gridx = 0; // Vị trí cột 0 
        gbc.gridy = 0; // Vị trí dòng 0
        add(inputLabel, gbc); // Thêm Label vào JFrame

        // TextField để nhập từ
        inputField = new JTextField(15); // TextField có chiều dài 15 ký tự
        inputField.setFont(new Font("Arial", Font.PLAIN, 16)); // Font chữ Arial, bình thường, kích thước 16
        inputField.setBackground(new Color(255, 255, 224)); // Màu vàng nhạt
        gbc.gridx = 1; // Vị trí cột 1 
        gbc.gridy = 0; // Vị trí dòng 0
        gbc.gridwidth = 2; // Số ô chiếm trên lưới là 2
        add(inputField, gbc); // Thêm TextField vào JFrame

        // Button dịch
        translateButton = new JButton("Dịch"); // Tạo Button "Dịch"
        translateButton.setFont(new Font("Arial", Font.BOLD, 16)); // Font chữ Arial, đậm, kích thước 16
        translateButton.setBackground(new Color(60, 179, 113)); // Màu xanh lá cây nhạt
        translateButton.setForeground(Color.WHITE); // Màu chữ trắng 
        gbc.gridx = 1; // Vị trí cột 1
        gbc.gridy = 1; // Vị trí dòng 1
        gbc.gridwidth = 1; // Số ô chiếm trên lưới là 1
        add(translateButton, gbc); // Thêm Button vào JFrame

        // TextField để hiển thị kết quả
        outputField = new JTextField(15); // TextField có chiều dài 15 ký tự
        outputField.setFont(new Font("Arial", Font.PLAIN, 16)); // Font chữ Arial, bình thường, kích thước 16
        outputField.setEditable(false); // Không cho phép chỉnh sửa
        outputField.setBackground(new Color(255, 228, 196)); // Màu kem
        gbc.gridx = 1; // Vị trí cột 1
        gbc.gridy = 2; // Vị trí dòng 2
        gbc.gridwidth = 2; // Số ô chiếm trên lưới là 2
        add(outputField, gbc); // Thêm TextField vào JFrame

        // Button để thêm từ mới vào từ điển
        addWordButton = new JButton("Thêm từ"); // Tạo Button "Thêm từ"
        addWordButton.setFont(new Font("Arial", Font.BOLD, 16)); // Font chữ Arial, đậm, kích thước 16
        addWordButton.setBackground(new Color(100, 149, 237)); // Màu xanh dương nhạt
        addWordButton.setForeground(Color.WHITE);
        gbc.gridx = 1; // Vị trí cột 1
        gbc.gridy = 3;  // Vị trí dòng 3
        gbc.gridwidth = 1; // Số ô chiếm trên lưới là 1
        add(addWordButton, gbc); // Thêm Button vào JFrame

        // Xử lý sự kiện cho nút "Dịch"
        translateButton.addActionListener(new ActionListener()  // Sự kiện khi click vào Button "Dịch"
        {
            @Override
            public void actionPerformed(ActionEvent e)  // Hàm xử lý sự kiện
            {
                String inputWord = inputField.getText().toLowerCase(); // Lấy từ nhập vào và chuyển thành chữ thường
                String meaning = dictionary.get(inputWord); // Lấy nghĩa từ từ HashMap
                if (meaning != null)  // Nếu từ có nghĩa
                {
                    outputField.setText(meaning); // Hiển thị nghĩa từ
                } 
                else    // Nếu từ không có nghĩa trong từ điển
                {
                    outputField.setText("Không tìm thấy từ này"); // Hiển thị thông báo
                }
            }
        });

        // Xử lý sự kiện cho nút "Thêm từ"
        addWordButton.addActionListener(new ActionListener()  // Sự kiện khi click vào Button "Thêm từ"
        {
            @Override
            public void actionPerformed(ActionEvent e)  // Hàm xử lý sự kiện 
            {
                String newEnglishWord = JOptionPane.showInputDialog("Nhập từ tiếng Anh mới:"); // Hiển thị hộp thoại để nhập từ mới
                String newVietnameseWord = JOptionPane.showInputDialog("Nhập nghĩa tiếng Việt:"); // Hiển thị hộp thoại để nhập nghĩa từ mới
                if (newEnglishWord != null && newVietnameseWord != null)  // Nếu từ và nghĩa không rỗng thì thêm vào từ điển
                {
                    dictionary.put(newEnglishWord.toLowerCase(), newVietnameseWord.toLowerCase()); // Thêm từ mới vào từ điển
                    JOptionPane.showMessageDialog(null, "Đã thêm từ mới!"); // Hiển thị thông báo
                }
            }
        });
    }

    public static void main(String[] args)   // Hàm main để chạy chương trình
    {
        // Tạo đối tượng ứng dụng và hiển thị giao diện
        DictionaryAppGUI app = new DictionaryAppGUI(); // Tạo đối tượng ứng dụng
        app.setVisible(true);
    }
}


// TẠO CHI TIẾT GIAO DIỆN
// 1. Tạo JFrame với tiêu đề "Ứng dụng Từ Điển" và kích thước 500x250 pixel.
// 2. Đặt layout của JFrame là null để có thể tự điều chỉnh vị trí và kích thước của các thành phần.
// 3. Đặt màu nền cho JFrame là màu sáng màu (RGB: 250, 250, 240).
// 4. Tạo JLabel với nội dung "Nhập từ:" và đặt vị trí 30, 30, kích thước 100x25 pixel, font chữ Arial, đậm, kích thước 14, màu đen.

