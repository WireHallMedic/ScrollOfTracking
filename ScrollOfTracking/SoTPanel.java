package ScrollOfTracking;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// abstact JPanel for managing layout
public abstract class SoTPanel extends JPanel implements ComponentListener
{
   public static final double SMALL_ELEMENT_WIDTH = .05;
   public static final double TEXT_FONT_SCALE = .67;
   public static final double BUTTON_FONT_SCALE = .75;
   public static final String DELIMITER = "@@";
   private Insets insets;
   
   public void setInsets(Insets i){insets = i;}
   
   // initializer
   public SoTPanel()
   {
      super();
      insets = new Insets(2, 2, 2, 2);
      setLayout(null);
      addComponentListener(this);
   }
   
   // sets placement (x, y) and size (w, h) as proportion of this. Domain is (0.0, 1.0].
   protected void arrangeElement(JComponent c, double x, double y, double w, double h)
   {
      int width = this.getWidth();
      int height = this.getHeight();
      c.setSize((int)(width * w) - (insets.left + insets.right), (int)(height * h) - (insets.top + insets.bottom));
      c.setLocation((int)(width * x) + insets.left, (int)(height * y) + insets.bottom);
      setFontSize(c);
   }
   
   // calculate font size based on component size
   protected int calcFontSize(JComponent c)
   {
      int pixelSize = Math.min(c.getWidth(), c.getHeight());
      if(c instanceof JButton)
         pixelSize = (int)(pixelSize * BUTTON_FONT_SCALE);
      else
         pixelSize = (int)(pixelSize * TEXT_FONT_SCALE);
      return pixelSize;
   }
   
   // set font size
   private void setFontSize(JComponent c)
   {
      Font f = new Font("Serif", Font.PLAIN, calcFontSize(c));
      c.setFont(f);
   }
   
   // implemented in child classes to repeatedly call arrangeElement()
   public abstract void arrangeElements();
   
   // not used but needed by interface
   public void componentResized(ComponentEvent ce){arrangeElements();}
   public void componentMoved(ComponentEvent ce){}
   public void componentHidden(ComponentEvent ce){}
   public void componentShown(ComponentEvent ce){arrangeElements();}
}