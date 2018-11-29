package main;

import java.applet.*;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class sound {
    URL url = sound.class.getResource("jump.wav");
    URL url1 = sound.class.getResource("background.wav");
    AudioClip clip = Applet.newAudioClip(url);
    AudioClip clip1 = Applet.newAudioClip(url1);
    AudioClip clip2 = Applet.newAudioClip(url1);
    public sound(){

//		AudioClip clip = Applet.newAudioClip(url);
//		clip.play();
//                clip.play();
//                Thread.sleep(3000);
//                AudioClip clip2 = Applet.newAudioClip(url);
//		Thread.sleep(1000);
//		clip.loop();
//		Thread.sleep(20000);
//		clip2.stop();
		      System.out.println("jumpppppppppppppppppppppppppppppppppppppppp");
		System.out.println("sound : start");
    
    
    }
    public static void main(String[] args) throws InterruptedException {
//                sound sound = new sound();
//                sound.background();
//        
		
		System.out.println("end");
                
    }    

    public void jump(){

		clip.play();
                System.out.println("....");
    }
    public void background1(){
		clip1.play();
                System.out.println("....");

    }
        public void background2(){
                clip1.stop();
		clip2.play();
                System.out.println("....");

    }
    
    
    
}
