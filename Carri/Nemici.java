import javax.swing.*;

public class Nemici extends Thread
{
    int posizioneCarroX=1612;
    int posizioneCarroY=490;
    String direzione="";
    int spostamentoX=148;
    int spostamentoY=120;
    JLabel carro1;
    JLabel carro2;
    Mappa mappa;
    JLabel esplosione;
    boolean bandieraPresa=false;
    public Nemici(Mappa mappa, int posizioneCarroX,int posizioneCarroY){
        this.mappa=mappa;
        carro1=new JLabel(new ImageIcon("Nemico1.png"));
        carro2=new JLabel(new ImageIcon("Nemico2.png"));
        mappa.add(carro2);
        carro2.setSize(350, 100);
        carro2.setLocation(posizioneCarroX-100, posizioneCarroY);
        mappa.add(carro1);
        carro1.setSize(181, 100);
        carro1.setLocation(posizioneCarroX, posizioneCarroY);
    }
    public void muoviCarro(String direzione){
        this.direzione=direzione;
    }
    public void aggiungiStaEsplosione(JLabel esplosione){
        this.esplosione=esplosione;
    }
    public void run(){
        suspend();
        while(true){
            //NON TOCCARE E NON TOGLIERE LA LINEA SOTTO O NON FUNZIONA IL MOVIMENTO
            System.out.println(direzione);
            switch(direzione){
                case "N":
                    //ruota
                    for(int i=0;i<spostamentoY;i++){
                        posizioneCarroY--;
                        carro1.setLocation(posizioneCarroX, posizioneCarroY);
                        carro2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
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
                    for(int i=0;i<spostamentoX;i++){
                        posizioneCarroX++;
                        carro1.setLocation(posizioneCarroX, posizioneCarroY);
                        carro2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
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
                    for(int i=0;i<spostamentoY;i++){
                        posizioneCarroY++;
                        carro1.setLocation(posizioneCarroX, posizioneCarroY);
                        carro2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
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
                    for(int i=0;i<spostamentoX;i++){
                        posizioneCarroX--;
                        carro1.setLocation(posizioneCarroX, posizioneCarroY);
                        carro2.setLocation(posizioneCarroX-100, posizioneCarroY-3);
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
            direzione="";
            if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="m"){
                Esplosione esplo=new Esplosione(esplosione);
                esplo.dammiXY(posizioneCarroX+15,posizioneCarroY-10);
                try
                {
                    sleep(1200);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }else if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="B"){
                bandieraPresa= true;
                mappa.bandiera1.setVisible(false);
            }else if(bandieraPresa && mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="BN"){
                mappa.perso();
            }
            if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]!="B"){
                mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]="-";
            }
            suspend();
        }
    }
}
