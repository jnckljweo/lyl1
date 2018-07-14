package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
   public MyFrame() {
       this.setSize(300,200);
       this.setTitle("Frist frame");
       //BorderLayout borderLayout=new BorderLayout;
       //this.setLayout(borderLayout);
       GridLayout gridLayout=new GridLayout(3,2);
       this.setLayout(gridLayout);
       JButton btnNorth = new JButton("北方");
       JButton btnSouth = new JButton("南方");
       JButton btnWest = new JButton("西方");
       JButton btnEast = new JButton("东方");
       JButton btnCenter = new JButton("中间");

//设置事件命令标识
       btnSouth.setActionCommand("south");
       btnEast.setActionCommand("east");
       btnWest.setActionCommand("west");
       btnCenter.setActionCommand("center");

       btnNorth.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
          JButton button=(JButton) e.getSource();
          button.setBackground(Color.red);
           }
       });

       //new一个事件监听器，实现接口里的方法


      //将按钮添加到界面中
       this.add(btnNorth);
       this.add(btnSouth);
       this.add(btnWest);
       this.add(btnEast);
       this.add(btnCenter);
       //this.add(btnNorth,BorderLayout.NORTH);
       //this.add(btnSouth,BorderLayout.SOUTH);
       //this.add(btnEast,BorderLayout.EAST);
       //this.add(btnWest,BorderLayout.WEST)
       //this.add(btnCenter,BorderLayout.CENTER);


       //在屏幕上显示这个插件
       this.setVisible(true);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

    public static void main(String args[]) {
        new MyFrame();
    }
}
