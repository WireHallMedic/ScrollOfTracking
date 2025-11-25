package ScrollOfTracking;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// panel that keeps track of torch timer. Time is stored as an int of seconds
public class TimerPanel extends SoTPanel implements ActionListener, MouseListener
{
	private int curTime;
	private int maxTime;
	private boolean runF;
	private JTextField timeF;
	private JButton runB;
	private JButton resetB;
   private javax.swing.Timer timer;
   private static final int BASE_RED = 0xFF;//0xFF;
   private static final int BASE_GREEN = 0xFF;//0xD7;
   private static final int BASE_BLUE = 0xFF;//0x00;
   private SoTFrame parentFrame;


	public int getCurTime(){return curTime;}
	public int getMaxTime(){return maxTime;}
	public boolean isRunF(){return runF;}
	public JTextField getTimeF(){return timeF;}
	public JButton getRunB(){return runB;}
	public JButton getResetB(){return resetB;}


	public void setCurTime(int c){curTime = c;}
	public void setMaxTime(int m){maxTime = m;}
	public void setRunF(boolean r){runF = r;}
	public void setTimeF(JTextField t){timeF = t;}
	public void setRunB(JButton r){runB = r;}
	public void setResetB(JButton r){resetB = r;}

   // initializer
   public TimerPanel(javax.swing.Timer t, SoTFrame parentF)
   {
      super();
      parentFrame = parentF;
      maxTime = 60*60;
      runF = false;
      timeF = new JTextField("");
      timeF.setHorizontalAlignment(SwingConstants.CENTER);
      timeF.addMouseListener(this);
      runB = new JButton("Start");
      resetB = new JButton("Reset");
      add(timeF);
      add(runB);
      runB.addActionListener(this);
      add(resetB);
      resetB.addActionListener(this);
      arrangeElements();
      timer = t;
      timer.addActionListener(this);
      resetTime();
      displayTime();
   }
   
   // reset time to its base value
   public void resetTime()
   {
      curTime = maxTime;
   }
   
   // do stuff when timer or button triggers
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == timer)
      {
         if(runF)
         {
            curTime = Math.max(curTime - 1, 0);
         }
      }
      if(ae.getSource() == runB)
      {
         togglePause();
      }
      if(ae.getSource() == resetB)
      {
         resetTime();
         displayTime();
      }
      if(runF)
         displayTime();
   }
   
   // pause timer if running, run if paused
   private void togglePause()
   {
      runF = !runF;
      if(runF)
      {
         curTime = getTimeInt();
         runB.setText("Pause");
      }
      else
         runB.setText("Start");
   }
   
   // display remaining time
   public void displayTime()
   {
      timeF.setText(getTimeString());
      setColor();
   }
   
   // set color based on time remaining, and alert parent to pass that to other components
   public void setColor()
   {
      Color lightColor = getLightColor();
      setBackground(lightColor);
      parentFrame.setPanelBackgrounds(lightColor);
   }
   
   // stay at 100% for first quarter, smoothly scale down to 25% over next three quarters, then drop to 0%
   public Color getLightColor()
   {
      double timeRemaining = (double)curTime / (double)maxTime;
      double intensity = 0.0;
      if(timeRemaining >= .75)
         intensity = 1.0;
      else if(timeRemaining > 0.0)
         intensity = 1.0 - (1.0 - (timeRemaining + .25));
      int r = (int)(BASE_RED * intensity);
      int g = (int)(BASE_GREEN * intensity);
      int b = (int)(BASE_BLUE * intensity);
      return new Color(r, g, b);
   }
   
   // arrange the container elements; implementation of abstract class in SoTPanel
   public void arrangeElements()
   {
      arrangeElement(timeF, .2, 0.1, .1, .8);
      arrangeElement(runB, .4, 0.1, .2, .8);
      arrangeElement(resetB, .65, 0.1, .2, .8);
   }
   
   // get time as a string from variables
   public String getTimeString()
   {
      int min = curTime / 60;
      int sec = curTime % 60;
      return String.format("%d:%02d", min, sec);
   }
   
   // get time as an int from time field
   public int getTimeInt()
   {
      try
      {
         int min = Integer.parseInt(timeF.getText().split(":")[0]);
         int sec = Integer.parseInt(timeF.getText().split(":")[1]);
         return (min * 60) + sec;
      }
      catch(Exception ex){}
      return maxTime;
   }
   
   // mouseListener stuff
   public void mouseClicked(MouseEvent e)
   {
      if(runF && e.getSource() == timeF)
      {
         togglePause();
      }
   }
   public void mousePressed(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}

   // stringify for saving
   public String serialize()
   {
      return "" + getTimeInt();
   }
   
   // set values from string
   public void deserialize(String str)
   {
      curTime = Integer.parseInt(str);
      displayTime();
   }
}