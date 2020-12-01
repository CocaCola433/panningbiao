import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class App {
    JPanel myPanel=new JPanel();
    JLabel label_bg=new JLabel();
    JLabel label_plane=new JLabel();
    private JLabel label_score=new JLabel();
    int column,row;
    int CELL=64;
    int score;
    //构造方法
    public App() {
        myPanel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
               //输出坐标
         System.out.printf("x坐标："+e.getX() + "," +"Y坐标为："+e.getY() + "\n");
             }
        });



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

                if((column*CELL>=400&&column*CELL<=600)&&(row*CELL>=700&&row*CELL<=896)){
                    score=1;

                    label_score.setText("分数："+String.valueOf(score));

                }



            }
        });

    }
    //显示窗体方法
    void go(){
        JFrame frame = new JFrame("篮球大战");

        //篮球图片
        java.net.URL imgURL2= App.class.getResource("img/ball.gif");
        label_plane.setIcon(new ImageIcon(imgURL2));
        label_plane.setBounds(0,0,64,64);
        //背景图片
        java.net.URL imgURL3= App.class.getResource("img/background.jpg");
        label_bg.setIcon(new ImageIcon(imgURL3));
        label_bg.setBounds(0,0,1000,1000);

        //设置分数显示内容
        label_score.setText("分数：0");
        //设置分数显示距屏幕坐标50，20，宽100，高100
        label_score.setBounds(20,0,100,100);
        //设置分数显示的颜色
        label_score.setForeground(Color.green);
        //设置分数的字体和大小
        label_score.setFont(new Font("serif",Font.PLAIN,20));


        myPanel.add(label_score);
        myPanel.add(label_plane);
        myPanel.add(label_bg);
        myPanel.setLayout(null);//显示布局为空


        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1000,1000);
        frame.setVisible(true);
        myPanel.setFocusable(true);//面板获取焦点
    }



    public static void main(String[] args)
    {

        new App().go();
    }
}
