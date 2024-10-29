// VIẾT BẰNG JAVA
// 2. Mô phỏng đồng hồ đếm ngược

import javax.swing.*; // Import các lớp Swing để tạo giao diện
import java.awt.*;   // Import các lớp AWT để tạo giao diện
import java.awt.event.*; // Import các lớp event để xử lý sự kiện
import java.util.Timer; // Import Timer để sử dụng đồng hồ đếm ngược
import java.util.TimerTask; // Import TimerTask để sử dụng đồng hồ đếm ngược

public class AdvancedCountdownTimer extends JFrame 
{
    // Các biến thành phần của giao diện
    private JTextField hoursField; // Trường nhập liệu giờ
    private JTextField minutesField; // Trường nhập liệu phút
    private JTextField secondsField; // Trường nhập liệu giây
    private JLabel timeDisplay; // Nhãn hiển thị thời gian
    private JButton startButton; // Nút bắt đầu
    private JButton pauseButton; // Nút tạm dừng
    private JButton resetButton; // Nút đặt lại

    // Biến đếm ngược
    private int totalSeconds; // Tổng số giây
    private Timer timer; // Đồng hồ đếm ngược
    private boolean isPaused = false; // Biến kiểm tra xem đồng hồ đang tạm dừng hay không

    public AdvancedCountdownTimer()  // Constructor của lớp AdvancedCountdownTimer
    {
        // Thiết lập giao diện
        setTitle("Đồng Hồ Đếm Ngược Nâng Cao"); // Đặt tiêu đề cửa sổ
        setSize(400, 200); // Đặt kích thước cửa sổ
        setLocationRelativeTo(null); // Đặt vị trí cửa sổ
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tạo các thành phần giao diện
        hoursField = new JTextField(2); // Trường nhập liệu giờ
        minutesField = new JTextField(2); // Trường nhập liệu phút
        secondsField = new JTextField(2); // Trường nhập liệu giây
        timeDisplay = new JLabel("00:00:00", SwingConstants.CENTER); // Nhãn hiển thị thời gian
        timeDisplay.setFont(new Font("Arial", Font.BOLD, 40)); // Đặt font cho nhãn hiển thị thời gian

        startButton = new JButton("Bắt đầu"); // Nút bắt đầu
        pauseButton = new JButton("Tạm dừng"); // Nút tạm dừng
        resetButton = new JButton("Đặt lại"); // Nút đặt lại

        // Tạo panel cho nhập thời gian
        JPanel inputPanel = new JPanel(); // Panel cho trường nhập liệu
        inputPanel.add(new JLabel("Giờ:")); // Nhãn "Giờ"
        inputPanel.add(hoursField);
        inputPanel.add(new JLabel("Phút:")); // Nhãn "Phút"
        inputPanel.add(minutesField);
        inputPanel.add(new JLabel("Giây:")); // Nhãn "Giây"
        inputPanel.add(secondsField);

        // Tạo panel cho các nút điều khiển
        JPanel controlPanel = new JPanel(); // Panel cho các nút điều khiển
        controlPanel.add(startButton);
        controlPanel.add(pauseButton);
        controlPanel.add(resetButton);

        // Thêm các thành phần vào cửa sổ chính
        setLayout(new BorderLayout()); // Đặt layout cho cửa sổ
        add(inputPanel, BorderLayout.NORTH);
        add(timeDisplay, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Thêm sự kiện cho các nút
        startButton.addActionListener(new StartButtonListener()); // Sự kiện cho nút bắt đầu
        pauseButton.addActionListener(new PauseButtonListener()); // Sự kiện cho nút tạm dừng
        resetButton.addActionListener(new ResetButtonListener()); // Sự kiện cho nút đặt lại

        // Vô hiệu hóa nút pause và reset ban đầu
        pauseButton.setEnabled(false); // Vô hiệu hóa nút tạm dừng
        resetButton.setEnabled(false); // Vô hiệu hóa nút đặt lại
    }

    // Lớp lắng nghe sự kiện cho nút Start
    private class StartButtonListener implements ActionListener  // Lớp lắng nghe sự kiện cho nút Start
    {
        public void actionPerformed(ActionEvent e)  // Phương thức xử lý sự kiện khi nhấn nút Start
        {
            // Kiểm tra và lấy dữ liệu nhập vào
            try  // Bắt ngoại lệ khi nhập liệu không hợp lệ
            {
                int hours = Integer.parseInt(hoursField.getText()); // Lấy giờ từ trường nhập liệu
                int minutes = Integer.parseInt(minutesField.getText()); // Lấy phút từ trường nhập liệu
                int seconds = Integer.parseInt(secondsField.getText()); // Lấy giây từ trường nhập liệu

                if (hours < 0 || minutes < 0 || seconds < 0 || minutes >= 60 || seconds >= 60) 
                {
                    throw new NumberFormatException(); // Ném ngoại lệ nếu nhập liệu không hợp lệ
                }

                totalSeconds = hours * 3600 + minutes * 60 + seconds; // Tính tổng số giây

                if (totalSeconds <= 0)    // Nếu thời gian nhập vào nhỏ hơn hoặc bằng 0
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập thời gian lớn hơn 0.");
                    return;
                }

                // Cập nhật hiển thị thời gian
                updateDisplay(); // Cập nhật hiển thị thời gian

                // Vô hiệu hóa các trường nhập liệu và nút Start
                hoursField.setEditable(false); // Vô hiệu hóa trường nhập liệu giờ
                minutesField.setEditable(false); // Vô hiệu hóa trường nhập liệu phút
                secondsField.setEditable(false); // Vô hiệu hóa trường nhập liệu giây
                startButton.setEnabled(false); // Vô hiệu hóa nút Start
                pauseButton.setEnabled(true); // Kích hoạt nút Pause
                resetButton.setEnabled(true); // Kích hoạt nút Reset

                // Bắt đầu đếm ngược
                isPaused = false; // Đặt biến tạm dừng về false
                timer = new Timer(); // Khởi tạo đồng hồ đếm ngược
                timer.scheduleAtFixedRate(new TimerTask()  // Lập lịch cho đồng hồ đếm ngược
                {
                    public void run()  // Phương thức chạy khi đồng hồ đếm ngược hoạt động
                    {
                        if (!isPaused)  // Nếu đồng hồ không tạm dừng
                        {
                            if (totalSeconds > 0)  // Nếu thời gian còn
                            {
                                totalSeconds--; // Giảm số giây đi 1
                                SwingUtilities.invokeLater(new Runnable()  // Cập nhật hiển thị thời gian
                                {
                                    public void run()  // Phương thức chạy
                                    {
                                        updateDisplay(); // Cập nhật hiển thị thời gian
                                    }
                                });
                            } 
                            else  // Nếu hết giờ thì hiển thị thông báo
                            {
                                timer.cancel(); // Hủy đồng hồ đếm ngược
                                SwingUtilities.invokeLater(new Runnable()  // Hiển thị thông báo
                                {
                                    public void run()   // Phương thức chạy
                                    {
                                        JOptionPane.showMessageDialog(null, "Hết giờ!");
                                        resetTimer(); // Đặt lại đồng hồ đếm ngược
                                    }
                                });
                            }
                        }
                    }
                }, 0, 1000); // Đặt thời gian chạy sau mỗi 1 giây
            } 
            catch (NumberFormatException ex)  // Bắt ngoại lệ khi nhập liệu không hợp lệ
            {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thời gian hợp lệ.\nGiờ, phút, giây phải là số nguyên dương.\nPhút và giây từ 0 đến 59.");
            }
        }
    }

    // Lớp lắng nghe sự kiện cho nút Pause
    private class PauseButtonListener implements ActionListener  // Lớp lắng nghe sự kiện cho nút Pause
    {
        public void actionPerformed(ActionEvent e)  // Phương thức xử lý sự kiện khi nhấn nút Pause
        {
            if (isPaused)  // Nếu đồng hồ đang tạm dừng
            {
                isPaused = false; // Đặt biến tạm dừng về false
                pauseButton.setText("Tạm dừng"); // Đổi chữ trên nút Pause
            } 
            else  // Nếu đồng hồ đang chạy
            {
                isPaused = true; // Đặt biến tạm dừng về true
                pauseButton.setText("Tiếp tục"); // Đổi chữ trên nút Pause
            }
        }
    }

    // Lớp lắng nghe sự kiện cho nút Reset
    private class ResetButtonListener implements ActionListener  // Lớp lắng nghe sự kiện cho nút Reset
    {
        public void actionPerformed(ActionEvent e)  // Phương thức xử lý sự kiện khi nhấn nút Reset
        {
            resetTimer(); // Đặt lại đồng hồ đếm ngược
        }
    }

    // Phương thức cập nhật hiển thị thời gian
    private void updateDisplay()  // Phương thức cập nhật hiển thị thời gian
    {
        int hours = totalSeconds / 3600; // Tính số giờ
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60; // Tính số giây

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeDisplay.setText(timeString); // Hiển thị thời gian
    }

    // Phương thức đặt lại đếm ngược
    private void resetTimer()  // Phương thức đặt lại đồng hồ đếm ngược
    {
        if (timer != null)  // Nếu đồng hồ đếm ngược đang chạy
        {
            timer.cancel(); // Hủy đồng hồ đếm ngược
        }
        totalSeconds = 0; // Đặt tổng số giây về 0
        isPaused = false; // Đặt biến tạm dừng về false
        timeDisplay.setText("00:00:00"); // Đặt hiển thị thời gian về 00:00:00

        // Kích hoạt lại các trường nhập liệu và nút Start
        hoursField.setEditable(true); // Kích hoạt trường nhập liệu giờ
        minutesField.setEditable(true); // Kích hoạt trường nhập liệu phút
        secondsField.setEditable(true); // Kích hoạt trường nhập liệu giây
        startButton.setEnabled(true); // Kích hoạt nút Start
        pauseButton.setEnabled(false); // Vô hiệu hóa nút Pause
        resetButton.setEnabled(false); // Vô hiệu hóa nút Reset
        pauseButton.setText("Tạm dừng"); // Đặt lại chữ trên nút Pause
    }

    public static void main(String[] args)  // Phương thức main để chạy chương trình
    {
        SwingUtilities.invokeLater(new Runnable()  // Chạy chương trình
        {
            public void run()  // Phương thức chạy
            {
                new AdvancedCountdownTimer().setVisible(true); // Hiển thị cửa sổ chính
            }
        });
    }
}
