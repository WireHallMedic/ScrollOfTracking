package ScrollOfTracking;

import javax.swing.*;
import java.awt.*;

// simple label extension for consistent appearance
public class SoTLabel extends JLabel
{
   public SoTLabel(){this("", SwingConstants.CENTER);}
   public SoTLabel(String str){this(str, SwingConstants.CENTER);}
   
   // initializer
   SoTLabel(String str, int horizAlign)
   {
      super(str, horizAlign);
      setForeground(Color.WHITE);
      setBackground(Color.BLACK);
      setOpaque(true);
   }
}