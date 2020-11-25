import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class App {
	private JPanel myPanel =new JPanel();
	private JLabel label_img1=new JLabel();
	private JLabel label_img2=new JLabel();
	private JLabel score=new JLabel();
	
	
	void go(){
	//创建一个JFrame窗体，名为找不同
	JFrame frame = new JFrame("找不同");
	//是把MyPanel设置为内容面板
    frame.setContentPane(myPanel);
    //设置用户在此窗体上发起 “close” 时默认执行的操作
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //设置窗体距离显示器坐标100.100.宽度1000，高度1600
    frame.setBounds(100,100,1000,1600);
    
	
    //设置图片1
    java.net.URL imgURL1= App.class.getResource("trees.gif");
    //图片1写入imgURL里面
    label_img1.setIcon(new ImageIcon(imgURL1));
    //设置图片2
    java.net.URL imgURL2= App.class.getResource("trees.gif");
    //图片2写入imgURL里面
    label_img2.setIcon(new ImageIcon(imgURL2));

    //设置分数显示内容
    score.setText("得分:0");
    //设置分数显示距屏幕坐标50，20，宽100，高100
    score.setBounds(50,20,100,100);
    //设置分数显示的颜色
    score.setForeground(Color.yellow);
    //设置分数的字体和大小
    score.setFont(new Font("serif",Font.PLAIN,20));

    
    //设置图片1距屏幕坐标200，200，宽500高800
    label_img1.setBounds(500,0,500,800);
    //设置图片2距屏幕坐标200，200，宽500，高度为800
    label_img2.setBounds(0,0,500,800);
    //为在窗体面板添加label图片的组件、分数
    myPanel.add(label_img1);
    myPanel.add(score);
    myPanel.add(label_img2);
    //显示布局为空
    myPanel.setLayout(null);
    //把图形界面设置为可见
    frame.setVisible(true);

    

}

public static void main(String[] args) throws InterruptedException {
    new App().go();
    
	}
}
