import javax.swing.JLabel;

public class Proiettile extends Thread
{
    int x,y;
    String direzioneSparo;
    RotateLabel proiettile;
    int caselle;
    public Proiettile(RotateLabel proiettile)
    {
        this.proiettile=proiettile;
        this.proiettile.dammiCoordinate(50,50);
    }
    public void dammiXY(int x, int y,String direzioneSparo, int caselle){
        this.x=x+40;
        this.y=y-2;
        this.direzioneSparo=direzioneSparo;
        this.caselle=caselle;
        start();
    }
    public void run()
    {
        proiettile.setVisible(true);
        proiettile.setLocation(x,y);
        for(int j=0;j<caselle;j++){
            switch(direzioneSparo){
                case "N":
                    proiettile.dammiAngolo(0);
                    for(int i=1;i<=80;i++){
                            proiettile.setLocation(x, y-i-130-(j*80));
                            try
                            {
                                sleep(3);
                            }
                            catch (InterruptedException ie)
                            {
                                ie.printStackTrace();
                            }
                        }
                    break;
                case "E":
                    proiettile.dammiAngolo(1.57);
                    for(int i=1;i<=120;i++){
                            proiettile.setLocation(x+i+130+(j*120), y);
                            try
                            {
                                sleep(3);
                            }
                            catch (InterruptedException ie)
                            {
                                ie.printStackTrace();
                            }
                        }
                    break;
                case "S":
                    proiettile.dammiAngolo(3.13);
                    for(int i=1;i<=80;i++){
                            proiettile.setLocation(x, y+i+130+(j*80));
                            try
                            {
                                sleep(3);
                            }
                            catch (InterruptedException ie)
                            {
                                ie.printStackTrace();
                            }
                        }
                    break;
                case "O":
                    proiettile.dammiAngolo(-1.57);
                    for(int i=1;i<=120;i++){
                            proiettile.setLocation(x-i-130-(j*120), y);
                            try
                            {
                                sleep(3);
                            }
                            catch (InterruptedException ie)
                            {
                                ie.printStackTrace();
                            }
                        }
                    break;
            }
        }
        proiettile.setVisible(false);
        stop();
    }
}
