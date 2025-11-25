package ScrollOfTracking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// row with titles for rowPanels; contains a characterTitlePanel and a label for conditions
public class RowTitlePanel extends SoTPanel
{
   private CharacterTitlePanel characterTitlePanel;
   private SoTLabel conditionL;
   public static final double CHARACTER_PANEL_WIDTH = RowPanel.CHARACTER_PANEL_WIDTH;
   
   // initializer
   public RowTitlePanel()
   {
      super();
      characterTitlePanel = new CharacterTitlePanel();
      add(characterTitlePanel);
      conditionL = new SoTLabel("Conditions, Notes, Etc.");
      add(conditionL);
      setBackground(Color.BLACK);
   }
   
   // arrange the container elements; implementation of abstract class in SoTPanel
   public void arrangeElements()
   {
      arrangeElement(characterTitlePanel, 0.0, 0.0, CHARACTER_PANEL_WIDTH, 1.0);
      arrangeElement(conditionL, CHARACTER_PANEL_WIDTH, 0.0, 1.0 - CHARACTER_PANEL_WIDTH, 1.0);
   }
   
}