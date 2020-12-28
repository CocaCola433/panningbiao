import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class PlayMouse extends Thread {
    //创建窗口
    private JFrame jf;

    //计时器组件
    private JLabel timer;

    //背景图组件
    private JLabel bgImg;

    //分数组件
    private JLabel score;

    //背景图片
    private ImageIcon imageIcon;

    //分数
    private int num;

    //计时器
    private int time = 60;

    //锤子图片
    private Image cz;

    //锤子图片2
    private Image czz;

    //存放地鼠的数组
    private JLabel[] mouses;

    //地鼠图片
    private ImageIcon mouseBefore;

    //被击打后地鼠的图片
    private ImageIcon mouseAfter;

    private JApplet jApplet;

    public PlayMouse() {
        jApplet = new JApplet();
        // 设置背景音乐
        jApplet.newAudioClip(this.getClass().getResource("music/bgm.wav")).play();
        // 初始化窗口
        jf = new JFrame();
        // 初始化背景图
        bgImg = new JLabel();
        imageIcon = new ImageIcon(this.getClass().getResource("img/background.gif"));
        bgImg.setIcon(imageIcon);


        // 初始化分数
        score = new JLabel();
        // 设置分数显示
        score.setText("分数："+num+"分");
        // 设置分数的字体颜色
        score.setForeground(Color.white);
        // 设置分数字体格式和大小
        score.setFont(new Font("微软雅黑",0,20));
        // 设置分数显示的坐标和宽高
        score.setBounds(870,90,120,40);

        // 初始化计时器
        timer = new JLabel();
        // 设置时间显示
        timer.setText("时间："+time+"秒");
        // 设置时间的字体颜色
        timer.setForeground(Color.WHITE);
        // 设置时间的字体格式和大小
        timer.setFont(new Font("微软雅黑",0,20));
        // 设置时间显示的坐标和大小
        timer.setBounds(870,40,120,40);

        // 设置Windows鼠标
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        cz = new ImageIcon(this.getClass().getResource("img/hammer.png")).getImage();
        Cursor cursor = toolkit.createCustomCursor(cz, new Point(), "锤子");

        // 初始化地鼠图片
        mouseBefore = new ImageIcon(this.getClass().getResource("img/mouse.gif"));
        // 创建显示地鼠的标签数组
        mouses = new JLabel[9];
        // 遍历数组
        for (int i = 0; i < 9; i++) {
            // 初始化每个数组
            mouses[i] = new JLabel();
            // 设置标签与地鼠图片同样的大小
            mouses[i].setSize(mouseBefore.getIconWidth(),mouseBefore.getIconHeight());
            // 为标签添加鼠标事件监听适配器
            mouses[i].addMouseListener(new MouseAdapter() {
                // 添加鼠标点击事件
                @Override
                public void mouseClicked(MouseEvent e) {
                       // 获取事件源，即地鼠标签
                        Object source = e.getSource();
                        if (source instanceof JLabel){
                            JLabel label = (JLabel) source;
                            // 判断是否为空
                            if (label.getIcon() != null){
                                // 显示被击中后的地鼠图片
                                mouseAfter = new ImageIcon(this.getClass().getResource("img/mouses.gif"));
                                label.setIcon(mouseAfter);
                                // 击中后的音效
                                JApplet.newAudioClip(this.getClass().getResource("music/strike.wav")).play();
                                // 击中加分
                                num+=10;
                                // 显示得分
                                score.setText("分数："+num+"分");
                            }
                        }

                }
                // 鼠标动效设置
                // 按下
                @Override
                public void mousePressed(MouseEvent e) {
                    czz = new ImageIcon(this.getClass().getResource("img/hammers.png")).getImage();
                    Cursor cursor = toolkit.createCustomCursor(czz, new Point(), "锤子");
                    jf.setCursor(cursor);
                }
                // 释放
                @Override
                public void mouseReleased(MouseEvent e) {
                    jf.setCursor(cursor);
                }
            });
            jf.add(mouses[i]);
        }

        // 给每一个地鼠设置坐标
        mouses[0].setLocation(180,140);
        mouses[1].setLocation(420,140);
        mouses[2].setLocation(680,150);
        mouses[3].setLocation(150,280);
        mouses[4].setLocation(140,426);
        mouses[5].setLocation(422,290);
        mouses[6].setLocation(422,440);
        mouses[7].setLocation(680,280);
        mouses[8].setLocation(700,440);

        // 将各个组件添加到面板中
        jf.setCursor(cursor);
        jf.add(score);
        jf.add(timer);
        jf.add(bgImg);

        // 设置标题
        jf.setTitle("简易打地鼠游戏");
        // 设置图标
        jf.setIconImage(mouseBefore.getImage());
        // 设置窗体的宽高
        jf.setBounds(200,100,1024,768);
        // 设置显示窗口
        jf.setVisible(true);
        // 设置窗口不可拉伸
        jf.setResizable(false);
        // 设置关闭窗口 结束线程
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * 线程的核心方法
     */
    @Override
    public void run() {
        while(true){
            // 生成随机的地鼠索引
            int i = new Random().nextInt(9);
            JLabel mouse = mouses[i];
            // 如果地鼠索引没有设置图片
            if (mouse.getIcon() == null){
                try {
                    // 使线程休眠0.5秒
                    Thread.sleep(500);
                    // 为该标签添加地鼠图片
                    mouse.setIcon(mouseBefore);
                    // 地鼠出现的速度（可以根据自己的反应设置）
                    Thread.sleep(1000);
                    // 如果在显示中 设置为空
                    if (mouse.isShowing()){
                        mouse.setIcon(null);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 时间倒计时
                time--;
                timer.setText("时间："+time+"秒");
                // 当时间到达0秒时，弹出窗口，得到相应分数
                if (time == 0){
                    //游戏结束音乐
                    JApplet.newAudioClip(this.getClass().getResource("music/end.wav")).play();
                    JOptionPane.showMessageDialog(null,"恭喜您，您获得了"+num+"分","游戏结束",2);
                    break;

                }
            }
        }
    }

}

