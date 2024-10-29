import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

public class VendingMachineGUICompact extends JFrame {
    private HashMap<String, Integer> products;
    private HashMap<String, Integer> productCounts;
    private int totalMoney;
    private int totalCost;
    private DefaultTableModel tableModel;

    private JLabel totalMoneyLabel;
    private JLabel totalCostLabel;
    private JTextField moneyField;
    private JTable productTable;

    public VendingMachineGUICompact() {
        products = createProductList();
        productCounts = new HashMap<>();
        totalMoney = 0;
        totalCost = 0;

        setupUI();
    }

    // Tạo danh sách sản phẩm và giá
    private HashMap<String, Integer> createProductList() {
        HashMap<String, Integer> productMap = new HashMap<>();
        productMap.put("Coke", 12000);
        productMap.put("Pepsi", 12000);
        productMap.put("Water", 5000);
        productMap.put("Snack", 8000);
        productMap.put("7up", 12000);
        productMap.put("Sting", 12000);
        productMap.put("RedBull", 15000);
        productMap.put("O'Start", 11000);
        return productMap;
    }

    // Thiết lập giao diện người dùng
    private void setupUI() {
        setTitle("Máy bán hàng tự động");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel productPanel = createProductPanel();
        JPanel moneyPanel = createMoneyPanel();

        String[] columnNames = {"Sản phẩm", "Giá (VND)", "Số lượng"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(tableModel);

        add(productPanel, BorderLayout.NORTH);
        add(moneyPanel, BorderLayout.CENTER);
        add(new JScrollPane(productTable), BorderLayout.SOUTH);
    }

    // Tạo panel chứa các nút sản phẩm
    private JPanel createProductPanel() {
        JPanel productPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        for (String product : products.keySet()) {
            JButton productButton = new JButton(product + " (" + products.get(product) + " VND)");
            productButton.addActionListener(e -> addProductToCart(product));
            productPanel.add(productButton);
        }
        return productPanel;
    }

    // Tạo panel chứa phần nạp tiền và hoàn tất mua hàng
    private JPanel createMoneyPanel() {
        JPanel moneyPanel = new JPanel(new BorderLayout());

        moneyField = new JTextField(10);
        JButton insertMoneyButton = new JButton("Nạp tiền");
        insertMoneyButton.addActionListener(e -> handleInsertMoney());

        JButton completePurchaseButton = new JButton("Hoàn tất mua hàng");
        completePurchaseButton.addActionListener(e -> completePurchase());

        moneyPanel.add(new JLabel("Nhập số tiền (VND):"), BorderLayout.NORTH);
        moneyPanel.add(moneyField, BorderLayout.CENTER);
        moneyPanel.add(insertMoneyButton, BorderLayout.EAST);
        moneyPanel.add(completePurchaseButton, BorderLayout.SOUTH);

        totalMoneyLabel = new JLabel("Số tiền đã nạp: 0 VND ");
        moneyPanel.add(totalMoneyLabel, BorderLayout.WEST);

        totalCostLabel = new JLabel("Tổng giá: 0 VND ");
        moneyPanel.add(totalCostLabel, BorderLayout.SOUTH);

        return moneyPanel;
    }

    // Thêm sản phẩm vào giỏ hàng
    private void addProductToCart(String product) {
        int price = products.get(product);
        productCounts.put(product, productCounts.getOrDefault(product, 0) + 1);
        totalCost += price;

        updateProductTable();
        updateTotalCostLabel();
    }

    // Cập nhật bảng hiển thị các sản phẩm đã chọn
    private void updateProductTable() {
        tableModel.setRowCount(0);
        for (String product : productCounts.keySet()) {
            int count = productCounts.get(product);
            int price = products.get(product);
            tableModel.addRow(new Object[]{product, price, count});
        }
    }

    // Cập nhật tổng giá sản phẩm
    private void updateTotalCostLabel() {
        totalCostLabel.setText("Tổng giá: " + totalCost + " VND");
    }

    // Xử lý khi người dùng nạp tiền
    private void handleInsertMoney() {
        try {
            int money = Integer.parseInt(moneyField.getText());
            insertMoney(money);
        } catch (NumberFormatException ex) {
            showMessage("Vui lòng nhập số hợp lệ.");
        }
    }

    // Nạp tiền vào máy
    private void insertMoney(int money) {
        totalMoney += money;
        updateTotalMoneyLabel();
        showMessage("Bạn đã nạp: " + money + " VND");
        moneyField.setText("");
    }

    // Xử lý hoàn tất mua hàng
    private void completePurchase() {
        if (totalMoney >= totalCost) {
            int change = totalMoney - totalCost;
            showMessage("Giao dịch hoàn tất! Tổng giá: " + totalCost + " VND. Tiền thừa: " + change + " VND.");
            resetTransaction(); // Reset giao dịch
        } else {
            int deficit = totalCost - totalMoney;
            int option = JOptionPane.showConfirmDialog(this,
                    "Số tiền không đủ để hoàn tất giao dịch. Cần thêm " + deficit + " VND.\n" +
                    "Bạn có muốn nạp thêm tiền không?",
                    "Thiếu tiền",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                // Người dùng chọn nạp thêm tiền
                showMessage("Vui lòng nạp thêm tiền.");
            } else {
                // Người dùng chọn không nạp thêm tiền, yêu cầu bỏ bớt sản phẩm
                showMessage("Vui lòng bỏ bớt sản phẩm hoặc nạp thêm tiền.");
            }
        }
    }

    // Reset giao dịch sau khi hoàn tất
    private void resetTransaction() {
        totalCost = 0;
        productCounts.clear();
        updateProductTable();
        updateTotalCostLabel();
        totalMoney = 0;
        updateTotalMoneyLabel();
    }

    // Cập nhật số tiền đã nạp
    private void updateTotalMoneyLabel() {
        totalMoneyLabel.setText("Số tiền đã nạp: " + totalMoney + " VND");
    }

    // Hiển thị thông báo
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VendingMachineGUICompact vendingMachine = new VendingMachineGUICompact();
            vendingMachine.setVisible(true);
        });
    }
}

