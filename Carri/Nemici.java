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
    int vita=3;
    String direzioneSparo;
    String puntando="O";
    public Nemici(Mappa mappa, int posizioneCarroX,int posizioneCarroY){
        this.mappa=mappa;
        carro1=new JLabel(new ImageIcon("Nemico1.png"));
        carro2=new RotateLabel(new ImageIcon("Nemico2.png"),mappa);
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
            Esplosione esplo=new Esplosione(esplosione);
            esplo.dammiXY(posizioneCarroX+15,posizioneCarroY-10);
            mappa.carro.carro1.setVisible(false);
            mappa.carro.carro2.setVisible(false);
            mappa.sconfitta();
        }
        resume();
    }
    public void punta0() {
              mappa.angolo=-1.57;
              carro2.repaint();
       }
       
       public void punta90() {
              mappa.angolo=0;
              carro2.repaint();
       }
       
       public void punta180() {
              mappa.angolo=1.57;
              carro2.repaint();
       }
       
       public void punta270() {
              mappa.angolo=3.13;
              carro2.repaint();
       }
    public String ciSonoNemici(){
        for(int y=1;y<=3;y++){
            try{
                if(mappa.matrice[(posizioneCarroX+16)/148][(posizioneCarroY-10)/120-y]=="C"){
                    return "N";
                }
            }catch(ArrayIndexOutOfBoundsException exception){
                y=4;
            }
        }
        for(int x=1;x<=3;x++){
            try{
                if(mappa.matrice[(posizioneCarroX+16)/148+x][(posizioneCarroY-10)/120]=="C"){
                    return "E";
                }
            }catch(ArrayIndexOutOfBoundsException exception){
                x=4;
            }
        }
        for(int y=1;y<=3;y++){
            try{
                if(mappa.matrice[(posizioneCarroX+16)/148][(posizioneCarroY-10)/120+y]=="C"){
                    return "S";
                }
            }catch(ArrayIndexOutOfBoundsException exception){
                y=4;
            }
        }
        for(int x=1;x<=3;x++){
            try{
                if(mappa.matrice[(posizioneCarroX+16)/148-x][(posizioneCarroY-10)/120]=="C"){
                    return "O";
                }
            }catch(ArrayIndexOutOfBoundsException exception){
                x=4;
            }
        }
        return "";
    }
    public void run(){
        suspend();
        while(true){
            int xDelCarro=(posizioneCarroX+16)/148;
            int yDelCarro=(posizioneCarroY-10)/120;
            if(vita==0){
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
                    carro1.setVisible(false);
                    carro2.setVisible(false);
                    mappa.matrice[xDelCarro][yDelCarro]="-";
                    vita--;
                    stop();
            }
            switch(direzione){
                case "N":
                    //ruota
                    if(mappa.matrice[xDelCarro][yDelCarro-1]!="C" && mappa.matrice[xDelCarro][yDelCarro-1]!="N"){
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
                    }
                    break;
                case "E":
                    if(mappa.matrice[xDelCarro+1][yDelCarro]!="C" && mappa.matrice[xDelCarro+1][yDelCarro]!="N"){
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
                    }
                    break;
                case "S":
                    if(mappa.matrice[xDelCarro][yDelCarro+1]!="C" && mappa.matrice[xDelCarro][yDelCarro+1]!="N"){
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
                    }
                    break;
                case "O":
                    if(mappa.matrice[xDelCarro-1][yDelCarro]!="C" && mappa.matrice[xDelCarro-1][yDelCarro]!="N"){
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
                    mappa.matrice[xDelCarro][yDelCarro]="-";
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
