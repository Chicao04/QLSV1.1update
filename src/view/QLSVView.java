package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVcontroller;
import database.JDBCUtil;
import model.QLSVModel;
import model.SinhVien;


public class QLSVView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextField textMaSV;
    public JTextField texthoTenSV;
    public JTextField texttuoi;
    public JTextField textdiaChi;
    public JTextField textdiemGPA;
    public JTable table;
    public QLSVModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QLSVView frame = new QLSVView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public QLSVView() {
        this.model = new QLSVModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 747, 473);

        Action action = new QLSVcontroller(this);
//		Action action = new QLSVcontroller(this);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);






        JLabel Bang = new JLabel("BẢNG QUẢN LÍ  SINH VIÊN ");
        Bang.setFont(new Font("Tahoma", Font.BOLD, 18));
        Bang.setBounds(234, 10, 286, 49);
        contentPane.add(Bang);

        JLabel lblMaSV = new JLabel("Mã Sinh Viên:");
        lblMaSV.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMaSV.setBounds(27, 65, 112, 29);
        contentPane.add(lblMaSV);

        textMaSV = new JTextField();
        textMaSV.setBounds(134, 69, 127, 22);
        contentPane.add(textMaSV);
        textMaSV.setColumns(10);

        JLabel lblhoTenSV = new JLabel("Họ và Tên:");
        lblhoTenSV.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblhoTenSV.setBounds(27, 103, 112, 29);
        contentPane.add(lblhoTenSV);

        texthoTenSV = new JTextField();
        texthoTenSV.setColumns(10);
        texthoTenSV.setBounds(134, 109, 127, 22);
        contentPane.add(texthoTenSV);

        JLabel lbltuoi = new JLabel("Tuổi:");
        lbltuoi.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbltuoi.setBounds(27, 142, 112, 29);
        contentPane.add(lbltuoi);

        texttuoi = new JTextField();
        texttuoi.setColumns(10);
        texttuoi.setBounds(134, 146, 127, 22);
        contentPane.add(texttuoi);

        JLabel lbldiaChi = new JLabel("Địa chỉ:");
        lbldiaChi.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbldiaChi.setBounds(27, 181, 112, 29);
        contentPane.add(lbldiaChi);

        textdiaChi = new JTextField();
        textdiaChi.setColumns(10);
        textdiaChi.setBounds(134, 186, 127, 22);
        contentPane.add(textdiaChi);

        JLabel lbldiemTB = new JLabel("Điểm GPA:");
        lbldiemTB.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbldiemTB.setBounds(27, 221, 127, 29);
        contentPane.add(lbldiemTB);

        textdiemGPA = new JTextField();
        textdiemGPA.setColumns(10);
        textdiemGPA.setBounds(134, 225, 127, 22);
        contentPane.add(textdiemGPA);

        JButton btnthemSV = new JButton("THÊM");
        btnthemSV.addActionListener(action);
        btnthemSV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnthemSV.setBackground(new Color(0, 255, 127));
        btnthemSV.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnthemSV.setBounds(42, 328, 112, 29);
        contentPane.add(btnthemSV);

        JButton btnupdate = new JButton("SỬA");
        btnupdate.addActionListener(action);
        btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnupdate.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnupdate.setBackground(new Color(0, 255, 127));
        btnupdate.setBounds(178, 328, 112, 29);
        contentPane.add(btnupdate);

        JButton btndelete = new JButton("XÓA");
        btndelete.addActionListener(action);
        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btndelete.setFont(new Font("Tahoma", Font.BOLD, 15));
        btndelete.setBackground(new Color(0, 255, 127));
        btndelete.setBounds(85, 383, 112, 29);
        contentPane.add(btndelete);

        JButton btnthoat = new JButton("THOÁT");
        btnthoat.addActionListener(action);
        btnthoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int luachon = JOptionPane.showConfirmDialog(btnthoat,"Bạn có muốn thoát không" ,"Thoát", JOptionPane.YES_NO_OPTION);
                if (luachon == JOptionPane.YES_OPTION) {
                    System.exit(3);
                }

            }
        });
        btnthoat.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnthoat.setBackground(new Color(0, 255, 127));
        btnthoat.setBounds(245, 383, 112, 29);
        contentPane.add(btnthoat);

        JButton btnluu = new JButton("LƯU");
        btnluu.addActionListener(action);
        btnluu.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnluu.setBackground(new Color(0, 255, 127));
        btnluu.setBounds(323, 328, 112, 29);
        contentPane.add(btnluu);

        JLabel lblNewLabel = new JLabel("Danh sách sinh viên");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(419, 65, 151, 29);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "ID", "NAME", "AGE", "ADDRESS", "GPA"
                }
        ));


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(271, 91, 452, 195);
        contentPane.add(scrollPane);

        JButton btnSpXpGpa = new JButton("SẮP XẾP GPA");
        btnSpXpGpa.addActionListener(action);
        btnSpXpGpa.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSpXpGpa.setBackground(new Color(0, 255, 127));
        btnSpXpGpa.setBounds(408, 383, 151, 29);
        contentPane.add(btnSpXpGpa);

        JButton btnSpXpTn = new JButton("SẮP XẾP TÊN");
        btnSpXpTn.addActionListener(action);
        btnSpXpTn.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSpXpTn.setBackground(new Color(0, 255, 127));
        btnSpXpTn.setBounds(483, 328, 151, 29);
        contentPane.add(btnSpXpTn);
        this.setVisible(true);
    }

    public void xoaFrom() {
        textMaSV.setText("");
        texthoTenSV.setText("");
        texttuoi.setText("");
        textdiaChi.setText("");
        textdiemGPA.setText("");


    }

    public void thucHienThemSinhVien() {
        int id = Integer.valueOf(this.textMaSV.getText());
        String name = this.texthoTenSV.getText();
        int age = Integer.valueOf(this.texttuoi.getText());
        String address = this.textdiaChi.getText();
        double  gpa = Double.valueOf(this.textdiemGPA.getText());
        SinhVien sv = new SinhVien(id, name, age, address, gpa);
        this.themSinhVien(sv);
        JDBCUtil.insertSinhVien(sv); // Insert into database
    }

    public void themSinhVien(SinhVien sv) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if(!this.model.kiemTraTonTai(sv)) {
            this.model.insert(sv);
            model_table.addRow(new Object[]{
                    sv.getId()+"",
                    sv.getName()+"",
                    sv.getAge()+"",
                    sv.getAddress()+"",
                    sv.getGpa()+""
                    ,});
        }else {
            this.model.update(sv);
            int soLuongDong = model_table.getRowCount();
            for (int i = 0 ; i < soLuongDong;i++) {
                String id = model_table.getValueAt(i, 0)+"";
                if(id.equals(sv.getId()+"")) {
                    model_table.setValueAt(sv.getId()+"",i,0);
                    model_table.setValueAt(sv.getName()+"",i,1);
                    model_table.setValueAt(sv.getAge()+"",i,2);
                    model_table.setValueAt(sv.getAddress()+"",i,3);
                    model_table.setValueAt(sv.getGpa()+"",i,4);
                }

            }
        }
    }


    public SinhVien getSinhVienDangChon(){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();

        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sinh viên nào!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int id = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
        String name = model_table.getValueAt(i_row, 1) + "";
        int age = Integer.valueOf(model_table.getValueAt(i_row, 2) + "");
        String address = model_table.getValueAt(i_row, 3) + "";
        double gpa = Double.valueOf(model_table.getValueAt(i_row, 4) + "");
        SinhVien sv = new SinhVien(id, name, age, address, gpa) ;
        return sv;
    }
    public void hienthisinhviensaukhisua() {
        SinhVien sv = getSinhVienDangChon();

        this.textMaSV.setText(sv.getId()+"");
        this.texthoTenSV.setText(sv.getName()+"");
        this.texttuoi.setText(sv.getAge()+"");
        this.textdiaChi.setText(sv.getAddress()+"");
        this.textdiemGPA.setText(sv.getGpa()+"");
    }

    public void thucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa dòng đã chọn","XÓA",JOptionPane.YES_NO_OPTION);
        if(luaChon == JOptionPane.YES_OPTION) {
            SinhVien sv = getSinhVienDangChon();
            this.model.delete(sv);
            JDBCUtil.deleteSinhVien(sv.getId()); // Delete from database
            model_table.removeRow(i_row);
        }

    }


    public void sapXepGPA() {

        this.model.sapXepSinhVienGiamtheodiem();
        capNhatBang();

    }

    private void capNhatBang() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);

        for(SinhVien sv: this.model.getDsSinhVien()) {
            model_table.addRow(new Object[] {
                    sv.getId(),sv.getName(),sv.getAge(),sv.getAddress(),sv.getGpa()
            });

        }

    }

    public void sapXepTen() {
        this.model.sapXepSinhVienGiamtheoten();
        capnhapBangTen();

    }

    private void capnhapBangTen() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.setRowCount(0);
        for (SinhVien sv : this.model.getDsSinhVien()) {
            model_table.addRow(new Object[] {
                    sv.getId(),sv.getName(),sv.getAge(),sv.getAddress(),sv.getGpa()
            });

        }
    }








}

