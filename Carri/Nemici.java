import javax.swing.*;

public class Nemici extends Thread
{
    int posizioneCarroX;
    int posizioneCarroY;
    String direzione="";
    int spostamentoX=148;
    int spostamentoY=120;
    JLabel carro1;
    JLabel carro2;
    Mappa mappa;
    JLabel esplosione;
    boolean bandieraPresa=false;
    int vita=2;
    String direzioneSparo;
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
        this.posizioneCarroX=posizioneCarroX;
        this.posizioneCarroY=posizioneCarroY;
    }
    public void muoviCarro(String direzione){
        this.direzione=direzione;
    }
    public void aggiungiStaEsplosione(JLabel esplosione){
        this.esplosione=esplosione;
    }
    public void sparaA(String direzioneSparo){
        this.direzioneSparo=direzioneSparo;
        System.out.println("Nemico spara a "+ direzioneSparo);
        mappa.carro.vita--;
        System.out.println("Hai "+ mappa.carro.vita+"vite");
        if(mappa.carro.vita==0){
            mappa.sconfitta();
        }
        resume();
    }
    public void run(){
        suspend();
        while(true){
            int xDelCarro=(posizioneCarroX+16)/148;
            int yDelCarro=(posizioneCarroY-10)/120;
            if(vita==0){
                    Esplosione esplo=new Esplosione(esplosione);
                    esplo.dammiXY(posizioneCarroX+16,posizioneCarroY-10);
                    carro1.setVisible(false);
                    carro2.setVisible(false);
                    stop();
            }
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
            mappa.matrice[xDelCarro][yDelCarro]="-";
            direzione="";
            if(mappa.matrice[(posizioneCarroX+16)/148][(posizioneCarroY-10)/120]=="m"){
                Esplosione esplo=new Esplosione(esplosione);
                esplo.dammiXY(posizioneCarroX+16,posizioneCarroY-10);
                try
                {
                    sleep(1200);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                vita--;
                if(vita==0){
                    carro1.setVisible(false);
                    carro2.setVisible(false);
                    stop();
                }
            }else if(mappa.matrice[(posizioneCarroX+16)/148][(posizioneCarroY-10)/120]=="B"){
                bandieraPresa=true;
                mappa.bandiera1.setVisible(false);
            }else if(bandieraPresa && mappa.matrice[(posizioneCarroX+16)/148][(posizioneCarroY-10)/120]=="BN"){
                mappa.sconfitta();
            }
            if(mappa.matrice[(posizioneCarroX+16)/148][(posizioneCarroY-10)/120]!="BN"){
                mappa.matrice[(posizioneCarroX+16)/148][(posizioneCarroY-10)/120]="-";
            }
            mappa.matrice[(posizioneCarroX+16)/148][(posizioneCarroY-10)/120]="N";
            suspend();
        }
    }
}
