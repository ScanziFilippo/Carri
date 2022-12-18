import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class LabelRuotata{ 
    JLabel carro2;
    public double angolo=0;
    JLabel icona;
   public LabelRuotata(JLabel icona) {
       this.icona=icona;
      carro2 = icona;
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

   public void RotazioneMeno90() {
      LabelRuotata abc=new LabelRuotata(icona);
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
          abc.carro2.repaint();
        }
   }
   
   public void RotazionePiù90() {
      LabelRuotata abc=new LabelRuotata(icona);
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
          abc.carro2.repaint();
        }
   }
   
   public void Rotazione180() {
      LabelRuotata abc=new LabelRuotata(icona);
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
          abc.carro2.repaint();
        }
   }
}


