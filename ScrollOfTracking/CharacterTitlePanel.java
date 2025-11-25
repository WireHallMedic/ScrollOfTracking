package ScrollOfTracking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// titles for characterPanels
public class CharacterTitlePanel extends SoTPanel
{
   public static final double SMALL_ELEMENT_WIDTH = CharacterPanel.SMALL_ELEMENT_WIDTH;
   public static final double MEDIUM_ELEMENT_WIDTH = CharacterPanel.MEDIUM_ELEMENT_WIDTH;
   
   private SoTLabel nameL;
   private SoTLabel luckL;
   private SoTLabel initL;
   private SoTLabel actedL;
   
   // initializer
   public CharacterTitlePanel()
   {
      super();
      nameL = new SoTLabel("Name");
      add(nameL);
      luckL = new SoTLabel("Luck");
      add(luckL);
      initL = new SoTLabel("Init");
      add(initL);
      actedL = new SoTLabel("Acted");
      add(actedL);
      setBackground(Color.BLACK);
      
      arrangeElements();
   }
   
   // arrange the container elements; implementation of abstract class in SoTPanel
   public void arrangeElements()
   {
      double xInset = 0.0;
      double nameFWidth = 1.0 - ((SMALL_ELEMENT_WIDTH + MEDIUM_ELEMENT_WIDTH) * 2) - MEDIUM_ELEMENT_WIDTH;
      xInset += SMALL_ELEMENT_WIDTH;
      arrangeElement(nameL,         xInset, 0.0, nameFWidth, 1.0);
      xInset += nameFWidth;
      arrangeElement(luckL,         xInset, 0, MEDIUM_ELEMENT_WIDTH + SMALL_ELEMENT_WIDTH, 1.0);
      xInset += MEDIUM_ELEMENT_WIDTH + SMALL_ELEMENT_WIDTH;
      arrangeElement(initL,         xInset, 0, MEDIUM_ELEMENT_WIDTH, 1.0);
      xInset += MEDIUM_ELEMENT_WIDTH;
      arrangeElement(actedL,        xInset, 0.0, MEDIUM_ELEMENT_WIDTH, 1.0);
   }

}