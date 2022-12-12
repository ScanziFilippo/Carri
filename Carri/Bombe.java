import javax.swing.*;

public class Bombe extends Thread
{
    Mappa mappa;
    JLabel[] bombe;
    public Bombe(Mappa mappa,JLabel[] bombe)
    {
        this.mappa=mappa;
        this.bombe=bombe;
    }
    public void run(){
        for(int i=0;i<10;i++){
            int x=(int)(Math.random()*1624)+148;
            int y=(int)(Math.random()*840)+120;
            System.out.println(x + " "+y);
            new Esplosione(bombe[i]).dammiXY(x, y);
            try
            {
                sleep(500);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();   
            }
        }
    }
}