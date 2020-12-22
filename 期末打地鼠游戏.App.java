package com.pnb;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class App extends JFrame implements Runnable {
	private JPanel myPanel=new JPanel();
    private int num=0;
	private JLabel label_background;
	private JLabel [] mouses;
	private ImageIcon label_imgMouse;
	private JLabel label_score;
	public App(){
		this.setResizable(false);//不能够修改大小
		this.getContentPane().setLayout(null);
		this.setTitle("打地鼠");
		this.setBounds(100,100,1024,700);
		label_background=new JLabel();
	    ImageIcon icon=new ImageIcon(this.getClass().getResource("bg.gif"));
		label_background.setIcon(icon);
		label_background.setBounds(0,0,1024,700);
	    this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("src/com/pnb/cz.gif"), new Point(),"self"));
		label_imgMouse=new ImageIcon(this.getClass().getResource("shu.gif"));


	    mouses=new JLabel[9];
	    for(int i=0;i<9;i++){
	    	mouses[i]=new JLabel();
	    	mouses[i].setSize(label_imgMouse.getIconWidth(),label_imgMouse.getIconHeight());
	    	//mouses[i].setIcon(imgMouse);
	    	mouses[i].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					Object object=e.getSource();
					if(object instanceof JLabel){
						JLabel label=(JLabel)object;
						if(label.getIcon()!=null){
							num++;
							label_score.setText("您的得分是："+num+"分");//加分功能
							if(num==3){
								JOptionPane.showMessageDialog(myPanel,"恭喜通关！你太棒了！");
								//关闭所有窗口
								System.exit(0);

							}
						}
						label.setIcon(null);
					}
					
				}
			});

	    	this.getContentPane().add(mouses[i]);
	    }

		label_score=new JLabel();
		label_score.setBounds(360, 10,230,50);
		label_score.setFont(new Font("", 20, 25));
		label_score.setForeground(Color.RED);
		label_score.setText("您的得分是：分");
	    
	    mouses[0].setLocation(200,200);
	    mouses[1].setLocation(440,190);
	    mouses[2].setLocation(700,190);
	    mouses[3].setLocation(170,320);
	    mouses[4].setLocation(160,466);
	    mouses[5].setLocation(442,330);
	    mouses[6].setLocation(442,480);
	    mouses[7].setLocation(700,320);
	    mouses[8].setLocation(720,480);

	    this.getContentPane().add(label_score);
	    this.getContentPane().add(label_background);
		this.setVisible(true);
	}

	
   public void run(){
	   while(true){
		  try {
			Thread.sleep(500);
			int index=(int)(Math.random()*9);
			if(mouses[index].getIcon()==null){
				mouses[index].setIcon(label_imgMouse);
				Thread.sleep(900);//老鼠出现的速度,根据反应时间
				if(mouses[index].isShowing()){
					mouses[index].setIcon(null);
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	   }
   }
   public static void main(String [] args){
	   App p1=new App();
	   Thread t1=new Thread(p1);
	   t1.start();
   }
 
}
