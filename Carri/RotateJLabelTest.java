import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class LabelRuotata{ 
    JLabel label;
    public double angolo=0;
    
   public RotateJLabelTest() {
      label = new RotateLabel(new ImageIcon("muss.png"));
      add(label);
   }
   
   private class RotateLabel extends JLabel {
      public RotateLabel(Icon x) {
         super(x);
         setBounds(0, 0, 100, 100);
      }
      
      @Override
      public void paintComponent(Graphics g) {
         Graphics2D gx = (Graphics2D) g;
         gx.rotate(angolo,500,480);
         super.paintComponent(g);
      }
   }

   public static void RotazioneMeno90() {
      RotateJLabelTest abc=new RotateJLabelTest();
      while(abc.angolo>-1.55){
          abc.angolo-=0.01;
          try
          {
              Thread.sleep(10);
          }
          catch (InterruptedException ie)
          {
              ie.printStackTrace();
          }
          abc.label.repaint();
        }
   }
   
   public static void RotazionePiù90() {
      RotateJLabelTest abc=new RotateJLabelTest();
      while(abc.angolo<1.55){
          abc.angolo+=0.01;
          try
          {
              Thread.sleep(10);
          }
          catch (InterruptedException ie)
          {
              ie.printStackTrace();
          }
          abc.label.repaint();
        }
   }
   
   public static void Rotazione180() {
      RotateJLabelTest abc=new RotateJLabelTest();
      while(abc.angolo<3.1){
          abc.angolo+=0.01;
          try
          {
              Thread.sleep(10);
          }
          catch (InterruptedException ie)
          {
              ie.printStackTrace();
          }
          abc.label.repaint();
        }
   }
}


