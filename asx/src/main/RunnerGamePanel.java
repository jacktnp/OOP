package main;

import java.applet.Applet;
import java.applet.AudioClip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import shapes.Rectangle;
import shapes.ShapeContainer;
import shapes.Square;
/**
 * 
 * @author Yalchin ALIYEV
 * @version 1.0 26.03.2016
 *
 */

public class RunnerGamePanel extends JPanel{

	// constants
	public static final int BASEY = 750;
	public static final int MINGAP = 200;
	public static final int MAXGAP = 500;
	private static int jumpCount = 0;
        
	// properties
	private ShapeContainer obstacles;

	private static int randomGapx = (int) ( Math.random() * (1))*100;
	private ArrayList<Image> runnerGif,downGif;
        private ArrayList<Image> girlrunnerGif;


	private JLabel scoreLabel;
	private Timer obstacleTimer1;
        private Timer obstacleTimer, runnerTimer, jumpTimer;
        private ImageIcon image0,image1,image3;
        private ImageIcon image2;
        private ImageIcon item1;
        private ImageIcon upGif;
	private Rectangle border;
        private int newbackground;
	private int score;
	private int obstacleSpeed;
	private int index;
	private int heightOfJump;
        private int bodysize_x = 200,bodysize_y=200, x=0 ,background = 0, yclass = 0;
        private int countdown;
        private int first;
        private int addarrow;
        private int arrow;
        private int clash = 200;
        private boolean newarrow;
        private boolean down;
        private boolean up;
        private boolean start;
        private boolean flag;
	private boolean isGameOver;  
        private int changeHero;
        private sound sound;
        private int soundstart;
        private int gamescore;
        private boolean jumpstart;
        private Font pixelMplus;
        private int backgroundplas;
	// constructors
        
	public RunnerGamePanel() throws InterruptedException {
		
		setPreferredSize( new Dimension( 1400, 800));
		setFocusable(true);
		
		scoreLabel = new JLabel();
		
		init();
		add(scoreLabel);
	//	add( new JLabel( "<html><br><h2>by Yalchin</h2></html>"));
		
		//this.addMouseListener((MouseListener) new JumpMouseListener());
		this.addKeyListener((KeyListener) new JumpKeyListener());
		
	}

	private void init()  {
                gamescore = 0;
           //     sound soundx = new sound();
                jumpstart = false;
                soundstart = 0;
                changeHero = 0;
		addarrow = 90;
                arrow = 360;
                countdown = 0;
                newbackground = 0;
		score = 0;
		scoreLabel.setText( "Score: " + gamescore);
                down = false;
                up = false;
                start = false;
                newarrow = true;
		obstacleSpeed = 1;
		index = 0;
		heightOfJump = 0;
		flag = false;
                background = 0;

                 first = 0;
                image0 =new ImageIcon(new ImageIcon(getClass().getResource("/background0"+".png")).getImage());
                image1 =new ImageIcon(new ImageIcon(getClass().getResource("/background1"+".png")).getImage());
                image3 =new ImageIcon(new ImageIcon(getClass().getResource("/backgroundwhite"+".png")).getImage());
                image2 =new ImageIcon(new ImageIcon(getClass().getResource("/arrow.png")).getImage());
                upGif = new ImageIcon(new ImageIcon(getClass().getResource("/up0.png")).getImage());

            //    Font normalFont = new Font("SM pixxa", Font.PLAIN, 28);
               
                try{
                     pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("abc2.ttf")).deriveFont(72f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("abc2.ttf")));
                        System.out.println("999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
			
		}
		catch(IOException | FontFormatException e){
			                 System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		}
                
		border = new Rectangle( 30, 30);
		border.setLocation(30, BASEY - 300 - heightOfJump);
		
		isGameOver = false;
		
                // ---------------- square size
                //----------------square born
                
		obstacles = new ShapeContainer();
                obstacles.add( new Obstacle( 0, yclass + 50));
		//obstacles.add( new Obstacle( -50, yclass + 50));
		
		runnerGif = new ArrayList<Image>();
                downGif = new ArrayList<Image>();
                girlrunnerGif = new ArrayList<Image>();
		for ( int i = 0; i < 5; i ++){
			runnerGif.add(( new ImageIcon( this.getClass().getResource( "/" + i + ".png")).getImage()));
                        downGif.add(( new ImageIcon( this.getClass().getResource( "/down" + i + ".png")).getImage()));
                        girlrunnerGif.add(( new ImageIcon( this.getClass().getResource( "/g" + i + ".png")).getImage()));
                }
		obstacleTimer = new Timer(obstacleSpeed, (ActionListener) new TimerActionListener());
		obstacleTimer1 = new Timer(obstacleSpeed, new TimerActionListener());
		jumpTimer = new Timer( 50,  new JumpActionListener());
		runnerTimer = new Timer(100, new RunnerActionListener());
                

		obstacleTimer.start();
		obstacleTimer1.start();
		runnerTimer.start();
                
		
	}
	
	public void paintComponent( Graphics g) {
		super.paintComponent(g);
		//setBackground( Color.WHITE);
		Graphics2D g2 = ( Graphics2D) g;
		
	//	g2.drawString( "by Yalchin", this.getWidth()-100, 20);

                       if(start == true){
                    backgroundplas = 2;
                    background-=backgroundplas;
                }
                        
        
        
                System.out.println("background : "+background);
            if(newbackground == 0){
                    g.drawImage(image0.getImage(), background, 0, 42000,getHeight(), this); 
                }else{
                    g.drawImage(image1.getImage(), background, 0, 42000,getHeight(), this); 
                   //g.drawImage(image1.getImage(), background, 0, 42000,getHeight(), this);
            }
            

                
                if(newarrow == true){
                    g.drawImage(image2.getImage(), 760, arrow+50, 50,70, this); 
                }
          //      System.out.println(background);
                //movex -= mx;
                if(changeHero == 0){
                    if(down == true){
                        g2.drawImage( downGif.get( index), 30, BASEY - bodysize_y - heightOfJump, bodysize_x, bodysize_y, this);
                    }else if(up == true){
                   // if(start == true){
                        g2.drawImage( upGif.getImage(), 30, BASEY - bodysize_y - heightOfJump, bodysize_x, bodysize_y, this);
                   // }
                    }else{
                        g2.drawImage( runnerGif.get( index), 30, BASEY - bodysize_y - heightOfJump, bodysize_x, bodysize_y, this);
                    }
                }else{
                       g2.drawImage( girlrunnerGif.get( index), 30, BASEY - bodysize_y - heightOfJump, bodysize_x, bodysize_y, this);
                }

             //   System.out.println(index);
	//	g2.drawRect( 50, BASEY - 80 - heightOfJump, 40, 70);
		
	//	g2.fillRect(0, BASEY, getWidth(), 8);
        // range of border square
		border.setLocation(30, BASEY - 80 - heightOfJump);
		
		Iterator i = obstacles.iterator();
		while( i.hasNext()) {
			( (Obstacle) i.next() ).draw(g2);
		}
		
					
                  //      System.out.println("background point :"+background);
                
              if(background <= -4080){
                  start = false;
                
                  g.setFont(pixelMplus);
                  g.setColor(new Color (100, 100, 103));
                 g.drawString("YOUR GRADE", 450, 350);
//                 g.drawString(""+gamescore, 850, 550);
                 
                 if(gamescore >= 10){
                    g.drawString("A", 750, 500);
                    
                 }else{
                    g.drawString("F", 750, 500);
                 }
                 
                 
                 backgroundplas = 0; 
              }
                   
                  
	}



	
	class TimerActionListener implements ActionListener {

        private int shapeX;
		public void actionPerformed( ActionEvent e) {

			                 System.out.println("run game new "+ clash);
			// obstacles.size คือพวก 4 เหลี่ยนนั้นละมมันคือจำนวนของมัน
			for ( int i = 0; i < obstacles.size(); i++) {
				Obstacle obstacle = ( (Obstacle) obstacles.getShape(i) );
                                obstacle.setLocation( obstacle.getX() - backgroundplas, obstacle.getY());
                                
                                //ถ้าตัว 4 เหลี่ยมถึง -50 เเล้วก็จะขายไปโดยเลือกอันเเรกสุด
				if ( obstacle.getX() == -50) {
					obstacle.setSelected( true);
				}
                               
          
                                
			}
                        
                        if((new java.awt.Rectangle( ( (Square) obstacles.getShape(x)).getX(),( (Square) obstacles.getShape(x)).getY(),10,10)
                                .intersects(new java.awt.Rectangle(0, BASEY - bodysize_y - heightOfJump,90,150)))& clash <= 0){ 
                                    System.out.println("clash :" + clash);
                                    if(clash == 0){
                                       clash = 300;
                                       isGameOver = true;
                                        System.out.println("game :"+isGameOver);
                                        System.out.println("clash in :"+clash);
                                    }
       
                                 }else{
                            if(clash > 0){
                                clash--;
                            }
                        }

                        
                        
                    if(start == true){
                        	if(first == 0){
                                    obstacles.add( new Obstacle( 1400, 500 + 50));
                                    first++;
                                }
			Obstacle obstacle = ( (Obstacle) obstacles.getShape( obstacles.size() - 1) );
			if ( 1200 - obstacle.getX() == randomGapx) {
				obstacles.add( new Obstacle( 1400, yclass + 50));
				randomGapx = (int) ( Math.random() * (2))*200+300;
				yclass = (int) ( Math.random() * (3))*200+400;
				score++;
                               
				scoreLabel.setText( "Score: " + gamescore);
			}
                        obstacles.remove();
                    }
		    // ตัวทำ error คือไรวะ
//                       if(( (Square) obstacles.getShape(x)).getX() <= 0){
//                            x++;
//                       }	
//			for ( int i = 0; !isGameOver && i < 50; i++) {
//
//				if ( border.contains(  ( (Square) obstacles.getShape(0)).getX() + i , ((Square) obstacles.getShape(0)).getY()) != null) {
//					isGameOver = true;
//				}
//                                System.out.println( ( (Square) obstacles.getShape(x)).getX()+" and "+""+( (Square) obstacles.getShape(x)).getY()+"----"+30+" : "+( heightOfJump + bodysize_y));
//
//			}
			
			if ( isGameOver) {
                            System.out.println("overlabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                                
				runnerTimer.stop();
                               obstacleTimer.stop();


                              jumpTimer.stop();
//				runnerTimer.removeActionListener( runnerTimer.getActionListeners()[0]);
//				obstacleTimer.removeActionListener( obstacleTimer.getActionListeners()[0]);
//				if ( jumpTimer.getActionListeners()[0] != null)
//					jumpTimer.removeActionListener( jumpTimer.getActionListeners()[0]);
                               

                          //      scoreLabel.setText( " Your Score : " + gamescore+"\n"+"\n");                               
                                // หน้าต่างเเสดงเอาไม่เอา
				int confirm = JOptionPane.showConfirmDialog(null, scoreLabel.getText() + "\n" + "1 + 1 = 2", "Quiz", 0);
				if ( confirm == 0){
                                
					//init();
                                        gamescore++;
                                }        
                                else{
					//System.exit(0);
                                }
             
                                isGameOver = false;
                                runnerTimer.start();
                                obstacleTimer.start();
                               jumpTimer.start();
                                System.out.println("isgameover : "+isGameOver);
                                
			}
			

                        
                        
                        
			repaint();
                        
                       
		}


               
	}
	
	class RunnerActionListener implements ActionListener {
		public void actionPerformed( ActionEvent e) {

			if ( index == 4){
				index = 1;
                        }
                        else{
				index++;
                        }
		}
	}
	
	class JumpMouseListener extends MouseAdapter {
		public void mouseClicked( MouseEvent e) {
			
			jumpTimer.setDelay(3);
			jumpTimer.start();
			
			
		}
		
	}

	class JumpActionListener implements ActionListener {
            sound sound = new sound();

            public void actionPerformed( ActionEvent e) {
                
			
                 if(start == true || jumpstart == true){
			
			if ( jumpCount == 160) {
				flag = true;
			}
			
			if ( flag) {
				jumpCount-=5;
				if ( jumpCount == 0) {
					jumpTimer.stop();
					flag = false;
					score += 2;
				//	scoreLabel.setText( "Score: " + score);
                                        up = false;
				}
                                if(jumpCount != 0){
                                       up = true;
                                }            
			}
			else {
				jumpCount+=5;
                               up = true;
			}
			heightOfJump = 2 * jumpCount;
                        
                        if(down == true){
                            if(countdown == 100){
                                down = false;
                                countdown = 0;
                            }else{
                                countdown++;
                            }
                            
                      //      System.out.println("count:"+countdown);
                        }
                        
                }
                 
//                 if( background <= -8000 && soundstart == 1 ){
//                     sound.background2();
//                     soundstart = 2;
//                     
//                     
//                 }else if(background <= -3000 && soundstart == 0){
//                    sound.background1();
//                    soundstart = 1;
//                 }
//                 
                 
            }
  
	}
	
	class JumpKeyListener extends KeyAdapter {

            sound sound = new sound();
            public void keyReleased(KeyEvent e) {
                    
                    if ( e.getExtendedKeyCode() == e.VK_UP) {
                        up = false;
                    }
                     if ( e.getExtendedKeyCode() == e.VK_DOWN) {
                        down = false;
                    }
        
        }

            
		public void keyPressed( KeyEvent e){
			if ( e.getExtendedKeyCode() == e.VK_UP) {
				jumpTimer.setDelay(3);
				jumpTimer.start();
                                if(arrow == 450){
                                    arrow-=addarrow;
                                    
                                }
                                if(arrow == 540){
                                    arrow-=addarrow;
                                }
                                if(start == true){
                                    up = true;
                                    //เสียงกระโดด
                                   
                                        sound.jump();

                                }
			}
			else if ( e.getExtendedKeyCode() == e.VK_DOWN) {
//				jumpTimer.stop();
//				jumpTimer.setDelay(2);
                                if(arrow == 450){
                                    arrow+=addarrow;
                                }
                                if(arrow == 360){
                                    arrow+=addarrow;
                                }
                                if(jumpstart == true){
                                    down = true;
                                }
                                
                                if(start == true ){
                                    down = true;
                               //     sound.background1();
                                }
			}
			else if ( e.getExtendedKeyCode() == e.VK_RIGHT) {
//				if ( obstacleSpeed > 1) {
//					obstacleSpeed--;
//					obstacleTimer.setDelay( obstacleSpeed);
//				}
                            if(start == false){
                               changeHero++;
                            }
			}
			else if ( e.getExtendedKeyCode() == e.VK_LEFT) {
//				if ( obstacleSpeed < 5) {
//					obstacleSpeed++;
//					obstacleTimer.setDelay( obstacleSpeed);
//				}
                            if(start == false){
                                changeHero++;
                            }
                        }
                        
                        
                        if(e.getExtendedKeyCode() == e.VK_ENTER){

                         if(newbackground == 1){ 
                          //    newbackground = 0;
                              start = true;
                          }
                            
                          if(arrow == 360){ 
                            //  addarrow = 0;
                              arrow = 0;
                              start = true;
                              newbackground = 0;
                              newarrow = false;
                              
                          }
                          if(arrow == 450){
                              arrow = 0;
                              newbackground = 1;
                              jumpstart = true;
                              newarrow = false;
                           //   addarrow = 0;
                              
                          }
                          if(arrow == 540){
                              System.exit(0);
                          }
                          

                        }
         
                        changeHero = changeHero%2;
		}
                
                
	}
}
