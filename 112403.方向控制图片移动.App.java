import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class App {
    JPanel myPanel=new JPanel();
    JLabel label_bg=new JLabel();
    JLabel label_plane=new JLabel();
    JTextArea jTextArea_A = new JTextArea();
    int x = 200, y = 500;
    //构造方法
    public App() {
        jTextArea_A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    y -= 10;
                    label_plane.setBounds(x, y, 64, 64);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    y += 10;
                    label_plane.setBounds(x, y, 64, 64);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    x -= 10;
                    label_plane.setBounds(x, y, 64, 64);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    x += 10;
                    label_plane.setBounds(x, y, 64, 64);
                }

            }
        });

    }
    //显示窗体方法
    void go(){
        JFrame frame = new JFrame("飞机大战");

        jTextArea_A.setBounds(0, 0, 512, 720);
        java.net.URL imgURL1= App.class.getResource("plane3.png");
        label_plane.setIcon(new ImageIcon(imgURL1));
        label_plane.setBounds(200,500,128,128);

        java.net.URL imgURL2= App.class.getResource("bg.jpg");
        label_bg.setIcon(new ImageIcon(imgURL2));
        label_bg.setBounds(0,0,512,720);



        myPanel.add(label_plane);
        myPanel.add(label_bg);
        myPanel.add(jTextArea_A);

        myPanel.setLayout(null);//显示布局为空


        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,512,720);
        //frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args)
    {
        new App().go();
    }
}
