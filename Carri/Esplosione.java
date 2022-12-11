import javax.swing.JLabel;

public class Esplosione extends Thread
{
    int x,y;
    JLabel esplosione;
    public Esplosione(JLabel esplosione)
    {
        this.esplosione=esplosione;
    }
    public void dammiXY(int x, int y){
        this.x=x;
        this.y=y;
        start();
    }
    public void run(){
        esplosione.repaint();
        esplosione.setSize(200,282);
        esplosione.setLocation(x-10, y-80);
        try
        {
            Thread.sleep(1200);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        esplosione.setSize(0,0);
        stop();
    }
}
