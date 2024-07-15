package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import database.JDBCUtil;
import model.SinhVien;
import view.QLSVView;

public class QLSVcontroller implements Action{
    public QLSVView view;

    public QLSVcontroller(QLSVView view) {
        super();
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: " +cm);
        if(cm.equals("THÊM")) {
            this.view.xoaFrom();
            this.view.model.setLuaChon("THÊM");
        }else if(cm.equals("LƯU")) {
            try {
                this.view.thucHienThemSinhVien();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }else if(cm.equals("SỬA")) {
            SinhVien sv = this.view.getSinhVienDangChon();
            if (sv != null) {
                this.view.hienthisinhviensaukhisua();
            }
        }else if(cm.equals("XÓA")) {
            SinhVien sv = view.getSinhVienDangChon();
//            JDBCUtil.deleteSinhVien(sv.getId()); // Delete from database
            this.view.thucHienXoa();
        }else if(cm.equals("SẮP XẾP GPA")) {
            this.view.sapXepGPA();
        }else if(cm.equals("SẮP XẾP TÊN")) {
            this.view.sapXepTen();
        }
    }

    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnabled(boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub

    }

}