package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountFrame extends JFrame {
    //上部放置查询相关组件的面板
    private JPanel panelSearch= new JPanel();
    //下部提供add、del、modify操作的面板
    private  JPanel panelProcess = new JPanel();
    //搜索框
    private  JTextField txtSearch=new JTextField();
    //搜索按钮
    private  JButton buttonSearch=new JButton("Search");
    //添加按钮
    private  JButton buttonadd = new JButton("add");
    //添加面板，包含多个组件
    private  JPanel panelAdd = new JPanel();
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

    //
    private  JButton buttondel = new JButton("delect");
    //
    private  JButton buttonmodify = new JButton("modify");
   //中间添加一个文本框
    private  JTextField txtCenter = new JTextField("hahha",20);


    public AccountFrame() {
        //初始化组件
        this.add(panelSearch,BorderLayout.NORTH);//添加搜索板面道顶部
        panelSearch.setLayout(new BorderLayout());//设置搜索板面布局
        panelSearch.add(txtSearch);//添加搜索框道中间部分
        panelSearch.add(buttonSearch,BorderLayout.EAST);//添加搜索按钮到右边

        this.add(panelProcess,BorderLayout.SOUTH);//添加操作板面道底部
        panelProcess.setLayout(new FlowLayout());//设置操作板面布局
        panelProcess.add(buttonadd);//添加添加按钮
        panelProcess.add(buttondel);//添加   按钮
        panelProcess.add(buttonmodify);//添加   按钮

        //添加组件到添加面板
        GridLayout gridLayout = new GridLayout(4, 2);
        panelAdd.setLayout(gridLayout);
        panelAdd.add(jlabelweb);
        panelAdd.add(txtweb);
        panelAdd.add(jLabelaccount);
        panelAdd.add(txtaccount);
        panelAdd.add(jLabelpassword);
        panelAdd.add(txtpassword);
        panelAdd.add(jLabelremark);
        panelAdd.add(txtremark);

        //添加文本框到窗口
        this.add(txtCenter);

        //搜索按钮事件监听，弹出对话框，显示搜索框中输入的内容
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,""+txtSearch.getText());
            }
        });
        //add按钮事件监听
        buttonadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //一个按钮实现两个功能
                String text = buttonadd.getText();
                if (text.equals("add")) {
                    //AccountFrame.this.remove(panelSearch);//移除搜索组件
                    AccountFrame.this.remove(txtCenter);//移除中间文本框组件
                    AccountFrame.this.add(panelAdd);//添加添加板面
                    buttondel.setText("cancel");
                    buttonmodify.setVisible(false);
                    text = "save";
                } else {//还原初始状态
                    text = "add";
                    AccountFrame.this.remove(panelAdd);
                    txtCenter.setText("保存成功！");
                    //AccountFrame.this.add(panelSearch);
                    AccountFrame.this.add(txtCenter);
                    buttondel.setText("delect");
                    buttonmodify.setVisible(true);//显示modify按钮
                }
                buttonadd.setText(text);
                //类似于页面刷新重绘
                AccountFrame.this.setVisible(false);
                AccountFrame.this.setVisible(true);
            }
        });

     buttondel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             String text =buttondel.getText();
             if (text.equals("delect")){
                 AccountFrame.this.remove(panelAdd);
                 AccountFrame.this.add(txtCenter);
                 txtCenter.setText("");
                // AccountFrame.this.add(panelSearch);
             }
         }
     });



//        //添加按钮事件监听，弹出一个新的窗口
//        buttonadd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               JFrame jFrameAdd = new JFrame();//新的窗口
//                jFrameAdd.setTitle("添加");//新窗口的相关属性
//                jFrameAdd.setSize(800,600);
//                jFrameAdd.add(panelAdd);//添加面板到新窗口
//                jFrameAdd.setVisible(true);
//            }
//        });


        //设置窗口的相关属性
        this.setSize(800,600);
        this.setTitle("账号首页");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new AccountFrame();
    }

}
