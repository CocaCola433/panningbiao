import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class App {
    private JPanel myPanel =new JPanel();
    private JLabel label_img=new JLabel();
    private JLabel label_score=new JLabel();
    int score,score1,score2,score3;

    //构造方法
    public App() {
        myPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
		//输出坐标
                System.out.printf(e.getX()+","+e.getY()+"\n");
		//判断三个点不同地方的坐标,获取x和y的范围
                if((e.getX()>=4&&e.getX()<=31)&&(e.getY()>=722&&e.getY()<=738)){
                    score1=1;
                    score=score1+score2+score3;
                    label_score.setText("分数："+String.valueOf(score));
                }
                if((e.getX()>=579&&e.getX()<=582)&&(e.getY()>=713&&e.getY()<=719)){
                    score2=1;
                    score=score1+score2+score3;
                    label_score.setText("分数："+String.valueOf(score));
                }
                if((e.getX()>=507&&e.getX()<=509)&&(e.getY()>=504&&e.getY()<=523)){
                    score3=1;
                    score=score1+score2+score3;
                    label_score.setText("分数："+String.valueOf(score));
                }
		 //满3分时，显示弹窗
                if(score==3){
                  JOptionPane.showMessageDialog(myPanel,"恭喜通关！你太棒了！");

                }

            }
        });

    }

    void go(){
        //创建一个JFrame窗体，名为找不同
        JFrame frame = new JFrame("找不同");
        //是把MyPanel设置为内容面板
        frame.setContentPane(myPanel);
        //设置用户在此窗体上发起 “close” 时默认执行的操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体距离显示器坐标100.100.宽度642，高度900
        frame.setBounds(100,100,642,900);


        //设置图片
        java.net.URL imgURL1= App.class.getResource("img.png");
        //图片写入imgURL里面
        label_img.setIcon(new ImageIcon(imgURL1));


        //设置分数显示内容
        label_score.setText("分数：0");
        //设置分数显示距屏幕坐标50，20，宽100，高100
        label_score.setBounds(20,0,100,100);
        //设置分数显示的颜色
        label_score.setForeground(Color.green);
        //设置分数的字体和大小
        label_score.setFont(new Font("serif",Font.PLAIN,20));


        //设置图片距屏幕坐标0，0，宽642，高865
        label_img.setBounds(0,0,642,865);
        myPanel.add(label_score);
        //为在窗体面板添加label图片的组件、分数
        myPanel.add(label_img);
        //显示布局为空
        myPanel.setLayout(null);
        //把图形界面设置为可见
        frame.setVisible(true);



    }

    public static void main(String[] args) throws InterruptedException {
        new App().go();

    }
}
