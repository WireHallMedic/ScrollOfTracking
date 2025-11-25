package ScrollOfTracking;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// panel at the bottom of the application with general controls
public class ControlPanel extends SoTPanel implements ActionListener
{
   private JButton newRoundB;
   private JButton clearAllB;
   private JButton saveB;
   private JButton loadB;
   private SoTFrame parentFrame;
   
   // initializer
   public ControlPanel(SoTFrame pf)
   {
      super();
      parentFrame = pf;
      newRoundB = new JButton("New Round");
      newRoundB.addActionListener(this);
      add(newRoundB);
      clearAllB = new JButton("Clear All");
      clearAllB.addActionListener(this);
      add(clearAllB);
      saveB = new JButton("Save");
      saveB.addActionListener(this);
      add(saveB);
      loadB = new JButton("Load");
      loadB.addActionListener(this);
      add(loadB);
   }
   
   // arrange the container elements; implementation of abstract class in SoTPanel
   public void arrangeElements()
   {
      arrangeElement(newRoundB, .025, 0.1, .2, .8);
      arrangeElement(clearAllB, .275, 0.1, .2, .8);
      arrangeElement(saveB, .515, 0.1, .2, .8);
      arrangeElement(loadB, .775, 0.1, .2, .8);
   }
   
   // react when button is pressed
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == clearAllB)
      {
         parentFrame.clearAll();
      }
      if(ae.getSource() == newRoundB)
      {
         parentFrame.newRound();
      }
      if(ae.getSource() == saveB)
      {
         parentFrame.save();
      }
      if(ae.getSource() == loadB)
      {
         parentFrame.load();
      }
   }
}