import javax.swing.*;

public class Nemici extends Thread
{
    int posizioneCarroX=1612;
    int posizioneCarroY=490;
    public Nemici(Mappa mappa){
        JLabel carro1=new JLabel(new ImageIcon("Nemico1.png"));
        JLabel carro2=new JLabel(new ImageIcon("Nemico2.png"));
        mappa.add(carro2);
        carro2.setSize(350, 100);
        carro2.setLocation(posizioneCarroX-100, posizioneCarroY);
        mappa.add(carro1);
        carro1.setSize(181, 100);
        carro1.setLocation(posizioneCarroX, posizioneCarroY);
    }
    public void muoviCarro(String direzione, JLabel carroDaMuovereGraficamente1, JLabel carroDaMuovereGraficamente2){
        switch(direzione){
            case "N":
                //ruota
                break;
            case "E":
                for(int i=0;i<128;i++){
                    posizioneCarroX++;
                    carroDaMuovereGraficamente1.setLocation(posizioneCarroX, posizioneCarroY);
                    carroDaMuovereGraficamente2.setLocation(posizioneCarroX-100, posizioneCarroY);
                    try
                    {
                        Thread.sleep(4);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                }
                break;
            case "S":
                //ruota
                break;
            case "O":
                for(int i=0;i<128;i++){
                    posizioneCarroX--;
                    carroDaMuovereGraficamente1.setLocation(posizioneCarroX, posizioneCarroY);
                    carroDaMuovereGraficamente2.setLocation(posizioneCarroX-100, posizioneCarroY);
                    try
                    {
                        Thread.sleep(4);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                }
                break;
        }
    }
}
