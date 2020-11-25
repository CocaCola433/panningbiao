import javax.swing.*;//表示引用javax文件夹下的swing文件夹中的所有类和接口
import java.awt.*;//*表示包里全部的文件，导入可以调用里面的方法
import java.awt.event.MouseAdapter;//导入java鼠标监听事件
import java.awt.event.MouseEvent;;//导入鼠标MouseEvent按下的时间

public class App { //一个私有的App方法
    private JPanel myPanel=new JPanel();//为swing主面板命名为MyPanel Jpanel为中间层容器，可显示文字、图像等等
    private JLabel label_img=new JLabel();//创建了一个label组件标签，用来显示地鼠图片
    private JLabel label_background=new JLabel();//创建了一个label组件标签，显示背景图
    private JLabel lebel_score=new JLabel();//创建了一个label组件标签，显示分数
    int i=0;//创建一个int变量 用来定义分数的值
    int arr[][]={//创建二维数组 设置老鼠出现的坐标值
            {200,200},
            {440,190},
            {700,190},
            {170,320},
            {160,466},
            {442,330},
            {442,480},
            {700,320},
            {720,480},
    };
    public App()  {//这个是App方法体
         myPanel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("src/com/pnb/cz.gif"), new Point(),"self"));//添加锤子
        label_img.addMouseListener(new MouseAdapter() {//提交按钮事件监听
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                while(true) {//加循环语句 让他每次点击换不同坐标位置
                    int rdm=(int)(Math.random()*10%9);//产生随机数
                    label_img.setBounds(arr[rdm][0],arr[rdm][1],100,100);//利用二维数组让地鼠随机到不同位置
                    if(true)
                    {
                        break;//跳出循环
                    }
                }
                i++;//让每次点击地鼠图片一次相加一个分数
                lebel_score.setText("得分："+String.valueOf(i));//将分数组件String转int
            }
        });
    }
    void go(){
        
        java.net.URL imgURL1= App.class.getResource("shu.gif");//设置地鼠的图片
        label_img.setIcon(new ImageIcon(imgURL1));//地鼠图片写入imgURL里面
        java.net.URL imgURL2= App.class.getResource("bg.gif");//设置背景的图片
        label_background.setIcon(new ImageIcon(imgURL2));//背景图片写入imgURL里面
        lebel_score.setText("得分：0");//显示分数
        label_img.setBounds(720,480,100,100);//设置地鼠图片距屏幕坐标100，100，宽720，搞480
        lebel_score.setBounds(200,100,300,100);//设置分数显示距屏幕坐标100，200，宽100，高300
        lebel_score.setForeground(Color.yellow);//设置分数显示的颜色
        lebel_score.setFont(new Font("serif",Font.PLAIN,30)); //设置分数的字体，跟大小
        label_background.setBounds(0,0,1024,720);//设置背景图片的宽度为1024，高度为720
        //为在窗体面板添加label图片的组件、分数、背景图
        myPanel.add(label_img);//老鼠图片在第一层
        myPanel.add(lebel_score);//分数显示在第二层
        myPanel.add(label_background);//背景图片第三层
        myPanel.setLayout(null);//显示布局为空

        JFrame frame = new JFrame("打地鼠game");//创建一个JFrame窗体，名为App
        frame.setContentPane(myPanel);//是把MyPanel设置为内容面板
        //是设置用户在此窗体上发起 “close” 时默认执行的操作。
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体距离显示器坐标100.100.宽度1024，高度720
        frame.setBounds(100,100,1024,720);
        frame.setVisible(true);//把图形界面设置为可见
    }
    public static void main(String[] args)  {//这个是java类中的main主方法
        new App().go();//加载用户定义的go方法
    }
}
