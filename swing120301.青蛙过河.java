import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class App {
    JPanel myPanel=new JPanel();
    JLabel label_bg=new JLabel();
    JLabel label_frog1=new JLabel();
    JLabel label_frog2=new JLabel();
    JLabel label_frog3=new JLabel();
    JTextArea textArea_input=new JTextArea();
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

                textArea_input.append(String.valueOf(e.getKeyChar()));

                if (textArea_input.getText().equals("hello")){
                    label_frog1.setBounds(330,250,128,128);
                }

                if (textArea_input.getText().equals("hello2")){
                    label_frog2.setBounds(415,250,128,128);
                }

                if (textArea_input.getText().equals("hello3")){
                    label_frog3.setBounds(500,250,128,128);
                }



            }
        });

    }
    //显示窗体方法
    void go(){
        JFrame frame = new JFrame("青蛙大战");

        //青蛙图片
        java.net.URL imgURL1= App.class.getResource("img/frog.png");
        label_frog1.setIcon(new ImageIcon(imgURL1));
        label_frog1.setBounds(100,430,128,128);

        //青蛙图片
        java.net.URL imgURL2= App.class.getResource("img/frog.png");
        label_frog2.setIcon(new ImageIcon(imgURL2));
        label_frog2.setBounds(200,430,128,128);


        //青蛙图片
        java.net.URL imgURL3= App.class.getResource("img/frog.png");
        label_frog3.setIcon(new ImageIcon(imgURL3));
        label_frog3.setBounds(300,430,128,128);


        //背景图片
        java.net.URL imgURL4= App.class.getResource("img/background.png");
        label_bg.setIcon(new ImageIcon(imgURL4));
        label_bg.setBounds(0,0,1024,600);

        //设置分数显示内容
        label_score.setText("分数：0");
        //设置分数显示距屏幕坐标50，20，宽100，高100
        label_score.setBounds(150,0,100,100);
        //设置分数显示的颜色
        label_score.setForeground(Color.green);
        //设置分数的字体和大小
        label_score.setFont(new Font("serif",Font.PLAIN,20));

        //设置输入框大小
       textArea_input.setBounds(0,0,100,20);
       //隐藏输入框
       textArea_input.setVisible(false);


        myPanel.add(label_score);
        myPanel.add(textArea_input);
        myPanel.add(label_frog1);
        myPanel.add(label_frog2);
        myPanel.add(label_frog3);
        myPanel.add(label_bg);
        myPanel.setLayout(null);//显示布局为空


        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1024,630);
        frame.setVisible(true);
        myPanel.setFocusable(true);//面板获取焦点
    }



    public static void main(String[] args)
    {

        new App().go();
    }
}
