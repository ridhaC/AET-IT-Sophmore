

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;

    public class Hangman extends JPanel {
   
      int errorCount=0;
      String answer;
      String currentState="";
     
      final int TOP_PERCENT = 10;
      final int HEAD_PERCENT = 15;
      final int TORSO_PERCENT = 35;
      final int LEGS_PERCENT = 20;
     
     
     
       public Hangman(String str)
      {
	    	answer = str;
	   		errorCount = 0;
	   		for(int i = 0; i<answer.length(); i++)	{
	   			currentState += " _ ";
	   		}
      }
     
       public String getString()
      {
         return currentState;
      }
       public void reset(String str)
      {
    	   currentState = "";
    	   answer = str;
	   		for(int i = 0; i<answer.length(); i++)	{
	   			currentState += " _ ";
	   		}
    	   
      }
       public boolean tryCharacter(char letter)
      {
   		boolean retur = false;
   		for(int i = 0; i < answer.length(); i++)	{
   			if (answer.charAt(i) == letter)	{
   				currentState = currentState.substring(0, i) + letter + currentState.substring(i+3);
   				retur = true;
   			}
    	}
   		if(retur == false)
   			errorCount++;
         repaint();
         return retur;
      }
   
   /*
   *  All methods below deal with drawing the Hangman image
   *  You do not need to modify them, but can if you want....
   */
   
       public void drawFace(Graphics g, int midX)
      {
         int height = getHeight();
        
         int diameter = (int)(HEAD_PERCENT * height/100.0);
         int start_y = (int)(TOP_PERCENT * (height/100.0));
         g.fillOval(midX-diameter/2, start_y, diameter, diameter); 
      }
       public void drawTorso(Graphics g, int midX)
      {
         int height = getHeight();
        
         int start_y = (int)((TOP_PERCENT + HEAD_PERCENT)* (height/100.0));
         int end_y = (int)((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT)* (height/100.0));
         g.drawLine(midX, start_y, midX, end_y); 
      }
       public void drawRightArm(Graphics g, int midX)
      {
         int angle = 315;
         int length = (int)(( TORSO_PERCENT/2)* (getHeight()/100.0));
         int start_y = (int)((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT/4)* (getHeight()/100.0));
         int end_x = (int)(midX + length * Math.cos(angle * Math.PI / 180));
         int end_y = (int)(start_y - length * Math.sin(angle * Math.PI / 180));
         g.drawLine(midX, start_y, end_x, end_y);
      }
       public void drawLeftArm(Graphics g, int midX)
      {
         int angle = 225;
         int length = (int)(( TORSO_PERCENT/2)* (getHeight()/100.0));
         int start_y = (int)((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT/4)* (getHeight()/100.0));
         int end_x = (int)(midX + length * Math.cos(angle * Math.PI / 180));
         int end_y = (int)(start_y - length * Math.sin(angle * Math.PI / 180));
         g.drawLine(midX, start_y, end_x, end_y);
      }
       public void drawRightLeg(Graphics g, int midX)
      {
         int angle = 315;
         int length = (int)(( TORSO_PERCENT/2)* (getHeight()/100.0));
         int start_y = (int)((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT)* (getHeight()/100.0));
         int end_x = (int)(midX + length * Math.cos(angle * Math.PI / 180));
         int end_y = (int)(start_y - length * Math.sin(angle * Math.PI / 180));
         g.drawLine(midX, start_y, end_x, end_y);
      }
       public void drawLeftLeg(Graphics g, int midX)
      {
         int angle = 225;
         int length = (int)(( TORSO_PERCENT/2)* (getHeight()/100.0));
         int start_y = (int)((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT)* (getHeight()/100.0));
         int end_x = (int)(midX + length * Math.cos(angle * Math.PI / 180));
         int end_y = (int)(start_y - length * Math.sin(angle * Math.PI / 180));
         g.drawLine(midX, start_y, end_x, end_y);
      }
     
       public void paintComponent(Graphics g)
      {
         int width=getWidth();
         int height = getHeight();
        
         g.setColor(Color.gray);
         g.fillRect(0,0,width, height);
        
         g.setColor(Color.red);
         if (errorCount > 0)
            drawFace(g, width/2);
        
         if (errorCount > 1)
            drawTorso(g, width/2);
        
         if (errorCount > 2)
            drawRightArm(g, width/2);
        
         if (errorCount > 3)
            drawLeftArm(g, width/2);
        
         if (errorCount > 4)
            drawRightLeg(g, width/2);
        
         if (errorCount > 5)
            drawLeftLeg(g, width/2);
      }
    
   }
