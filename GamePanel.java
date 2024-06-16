import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    
    Thread thread;
    boolean running;
    int x1,y1;
    int x2, y2;


     public GamePanel(){
       
        super();
         this.setBackground(Color.BLACK);
         this.setPreferredSize( new Dimension(500,500));
        this.x1 = 0;
        this.y1 = 200;
        this.x2 = 400;
        this.y2 = 200;

     }

       public void paintComponent(Graphics g){

           super.paintComponent(g);
           g.setColor(Color.GRAY);
           g.fillRect(x1, y1, 100, 100);
           g.setColor(Color.BLUE);
           g.fillRect(x2, y2, 100, 100);
       }  



       public void stop(){

        // running = false;


         try {
            thread.join();
         } catch (Exception e) {
            e.printStackTrace();
         }
      

       }

        public void startGame(){
          
             thread = new Thread(this);
              thread.start();
            
        } 
        public void update(){
         
            x1 +=1;
            x2 -=1;

            if(x1 +100 >= x2){

             stop();
            }

  
        }
       
        public void run(){
            
           
         double drawInterval = 1000000000/60;
         double deltaTime = 0;
         long lastPassedTime = System.nanoTime();
         long currentTime = 0;
        
         while (thread!=null) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime -lastPassedTime)/drawInterval;
            lastPassedTime = currentTime;
          

            if(deltaTime >=1){

                 update();
                 repaint();
             
                 deltaTime--;
            }
            

        }

    }}
