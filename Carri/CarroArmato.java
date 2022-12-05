import javax.swing.*;
public class CarroArmato extends Thread
{
    int posizioneCarroX=200;
    int posizioneCarroY=200;
    int spostamento=128;
    public CarroArmato(Mappa mappa){
        JLabel carro1=new JLabel(new ImageIcon("Carro1.png"));
        JLabel carro2=new JLabel(new ImageIcon("Carro2.png"));
        mappa.add(carro2);
        carro2.setSize(350, 100);
        carro2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
        mappa.add(carro1);
        carro1.setSize(181, 100);
        carro1.setLocation(posizioneCarroX, posizioneCarroY);
        muoviCarro("E", carro1, carro2);
        muoviCarro("O", carro1, carro2);
    }
    public void muoviCarro(String direzione, JLabel carroDaMuovereGraficamente1, JLabel carroDaMuovereGraficamente2){
        switch(direzione){
            case "N":
                //ruota
                break;
            case "E":
                for(int i=0;i<spostamento;i++){
                    posizioneCarroX++;
                    carroDaMuovereGraficamente1.setLocation(posizioneCarroX, posizioneCarroY);
                    carroDaMuovereGraficamente2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
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
                for(int i=0;i<spostamento;i++){
                    posizioneCarroX--;
                    carroDaMuovereGraficamente1.setLocation(posizioneCarroX, posizioneCarroY);
                    carroDaMuovereGraficamente2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
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
