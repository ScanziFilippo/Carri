import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RotateLabel extends JLabel {
    Mappa mappa;
      public RotateLabel(Icon x,Mappa mappa) {
         super(x);
         this.mappa=mappa;
      }
      
      @Override
      public void paintComponent(Graphics g) {
         Graphics2D gx = (Graphics2D) g;
         gx.rotate(mappa.angolo,500,500);
         super.paintComponent(g);
      }
   }