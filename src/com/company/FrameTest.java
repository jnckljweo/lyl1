package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameTest extends JFrame {
    public FrameTest() {
        //设置窗体大小
        this.setSize(800,600);
        this.setTitle("添加页面");
        //设置网格布局
        GridLayout gridLayout = new GridLayout(5, 2);
        this.setLayout(gridLayout);
        //设置标签
        JLabel jlabelweb=new JLabel("网站:");
        JLabel jLabelaccount=new JLabel("账号:");
        JLabel jLabelpassword=new JLabel("密码:");
        JLabel jLabelremark=new JLabel("备注:");
       //设置文本框
        JTextField txtweb = new JTextField(20);
        JTextField txtaccount = new JTextField(20);
        JTextField txtpassword = new JTextField(20);
        JTextField txtremark = new JTextField(20);
        //设置按钮
        JButton buttonYes=new JButton("确定");
        JButton buttonNo=new JButton("取消");
        //创建事件监听
        buttonYes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        // TODO Auto-generated method stub
                        JOptionPane.showMessageDialog(null,""+txtweb.getText()+","+txtaccount.getText()+","+txtpassword.getText()+","+txtremark.getText());
                    }
                });

        //在面板中添加标签、文本框、按钮
        this.add(jlabelweb);
        this.add(txtweb);
        this.add(jLabelaccount);
        this.add(txtaccount);
        this.add(jLabelpassword);
        this.add(txtpassword);
        this.add(jLabelremark);
        this.add(txtremark);
        this.add(buttonYes);
        this.add(buttonNo);

        //显示面板
        this.setVisible(true);
        }

    public static void main(String args[]) {
        new FrameTest();
    }
}