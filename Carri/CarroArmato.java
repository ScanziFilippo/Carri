import javax.swing.*;
public class CarroArmato extends Thread
{
    int posizioneCarroX=-15;
    int posizioneCarroY=490;
    int spostamentoX=148;
    int spostamentoY=120;
    JLabel carro1;
    JLabel carro2;
    public CarroArmato(Mappa mappa){
        carro1=new JLabel(new ImageIcon("Carro1.png"));
        carro2=new JLabel(new ImageIcon("Carro2.png"));
        mappa.add(carro2);
        carro2.setSize(350, 100);
        carro2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
        mappa.add(carro1);
        carro1.setSize(181, 100);
        carro1.setLocation(posizioneCarroX, posizioneCarroY);
    }
    public int daiPosizioneX(){
        return posizioneCarroX;
    }
    public int daiPosizioneY(){
        return posizioneCarroY;
    }
    public void muoviCarro(String direzione, JLabel carroDaMuovereGraficamente1, JLabel carroDaMuovereGraficamente2){
        switch(direzione){
            case "N":
                //ruota
                for(int i=0;i<spostamentoY;i++){
                    posizioneCarroY--;
                    System.out.println(posizioneCarroX);
                    carroDaMuovereGraficamente1.setLocation(posizioneCarroX, posizioneCarroY);
                    carroDaMuovereGraficamente2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
                }
                break;
            case "E":
                for(int i=0;i<spostamentoX;i++){
                    posizioneCarroX++;
                    System.out.println(posizioneCarroX);
                    carroDaMuovereGraficamente1.setLocation(posizioneCarroX, posizioneCarroY);
                    carroDaMuovereGraficamente2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
                }
                break;
            case "S":
                for(int i=0;i<spostamentoY;i++){
                    posizioneCarroY++;
                    System.out.println(posizioneCarroX);
                    carroDaMuovereGraficamente1.setLocation(posizioneCarroX, posizioneCarroY);
                    carroDaMuovereGraficamente2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
                }
                break;
            case "O":
                for(int i=0;i<spostamentoX;i++){
                    posizioneCarroX--;
                    carroDaMuovereGraficamente1.setLocation(posizioneCarroX, posizioneCarroY);
                    carroDaMuovereGraficamente2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
                }
                break;
        }
    }
}
