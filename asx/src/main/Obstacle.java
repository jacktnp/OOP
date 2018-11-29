package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import static main.RunnerGamePanel.BASEY;

import shapes.Drawable;
import shapes.Square;
/**
 * 
 * @author Yalchin ALIYEV
 * @version 1.0 26.03.2016
 *
 */
public class Obstacle extends Square implements ImageObserver
{

private ImageIcon item1  = new ImageIcon(new ImageIcon(getClass().getResource("/star.png")).getImage());
	
	public Obstacle( int x, int y) {
		
		super( 50);
		setLocation(x, y);
		
           //  item1 = new ImageIcon(new ImageIcon(getClass().getResource("/star.png")).getImage());
		
	}
	
	public void draw(Graphics2D g) {

                g.drawImage(item1.getImage(), getX(), getY(), 50, 50, (ImageObserver) this);
                
		//g.fillRect(getX(), getY(), 50, 50);
	}

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        throw new UnsupportedOperationException(" "); //To change body of generated methods, choose Tools | Templates.
    }
}
