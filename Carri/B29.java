import javax.swing.*;

public class B29 extends Thread
{
    public JLabel b29;
    Mappa mappa;
    JLabel[] bombe;
    public B29(JLabel b29, Mappa mappa, JLabel[] bombe)
    {
        this.b29=b29;
        this.mappa=mappa;
        this.bombe=bombe;
    }
    public void run(){
        for(int i=-800;i<2600;i++){
            //System.out.println(i);
            b29.setLocation(i,85);
            try
            {
                sleep(1);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            if(i==1800){
                Bombe bombardamento=new Bombe(mappa, bombe);
                bombardamento.start();
            }
        }
        for(int i=0;i<3;i++){
            mappa.nemici[i].vita--;
            Esplosione esplo=new Esplosione(mappa.esplosione);
            esplo.dammiXY(mappa.nemici[i].posizioneCarroX+16,mappa.nemici[i].posizioneCarroY-10);
            try
            {
                sleep(1200);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            if(mappa.nemici[i].vita==0){
                mappa.nemici[i].carro1.setVisible(false);
                mappa.nemici[i].carro2.setVisible(false);
            }
        }
    }
}