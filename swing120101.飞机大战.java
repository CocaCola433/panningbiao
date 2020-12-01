import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class App {
    JPanel myPanel=new JPanel();
    JLabel label_bg=new JLabel();
    JLabel label_plane=new JLabel();
    /*JTextArea jTextArea_A = new JTextArea();*/
    int column,row;
    int CELL=64;
    //构造方法
    public App() {
        myPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    row--;
                    label_plane.setBounds(column*CELL, row*CELL, CELL, CELL);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    row++;
                    label_plane.setBounds(column*CELL, row*CELL, CELL, CELL);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                   column--;
                    label_plane.setBounds(column*CELL, row*CELL, CELL, CELL);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    column++;
                    label_plane.setBounds(column*CELL, row*CELL, CELL, CELL);
                }

            }
        });

    }
    //显示窗体方法
    void go(){
        JFrame frame = new JFrame("飞机大战");
       /* jTextArea_A.setBounds(0, 0, 512, 700);*/

        //飞机图片
        java.net.URL imgURL1= App.class.getResource("img/plane4.png");
        label_plane.setIcon(new ImageIcon(imgURL1));
        label_plane.setBounds(0,0,64,64);
        //背景图片
        java.net.URL imgURL2= App.class.getResource("img/bg.jpg");
        label_bg.setIcon(new ImageIcon(imgURL2));
        label_bg.setBounds(0,0,654,667);


        myPanel.add(label_plane);
        myPanel.add(label_bg);
       /* myPanel.add(jTextArea_A);*/
        myPanel.setLayout(null);//显示布局为空


        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,654,667);
        //frame.pack();
        frame.setVisible(true);
        myPanel.setFocusable(true);//面板获取焦点
    }



    public static void main(String[] args)
    {

        new App().go();
    }
}
