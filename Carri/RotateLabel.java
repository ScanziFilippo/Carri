import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RotateLabel extends JLabel {
    Mappa mappa;
    int x, y;
    double angolo;
      public RotateLabel(Icon x,Mappa mappa) {
         super(x);
         this.mappa=mappa;
      }
      public void dammiAngolo(double angolo){
          this.angolo=angolo;
      }
      public void dammiCoordinate(int x, int y){
          this.x=x;
          this.y=y;
      }
      @Override
      public void paintComponent(Graphics g) {
         Graphics2D gx = (Graphics2D) g;
         gx.rotate(angolo,x,y);
         super.paintComponent(g);
      }
   }