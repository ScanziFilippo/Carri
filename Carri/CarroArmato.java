import javax.swing.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

public class CarroArmato extends Thread
{
    int posizioneCarroX=133;
    int posizioneCarroY=490;
    int spostamentoX=148;
    int spostamentoY=120;
    int vita=6;
    JLabel carro1;
    JLabel carro2;
    String direzione="";
    Mappa mappa;
    boolean bandieraPresa=false;
    JLabel b29;
    JLabel esplosione;
    JLabel[] bombe;
    String direzioneSparo="";
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
        this.direzione=direzione;
    }
    public void aggiungiStaMappa(Mappa mappa){
        this.mappa=mappa;
    }
    public void aggiungiStoB29(JLabel b29){
        this.b29=b29;
    }
    public void aggiungiStaEsplosione(JLabel esplosione){
        this.esplosione=esplosione;
    }
    public void aggiungiSteBombe(JLabel[] bombe){
        this.bombe=bombe;
    }
    public void sparaA(String direzioneSparo, JLabel carroDaMuovereGraficamente1, JLabel carroDaMuovereGraficamente2){
        this.direzioneSparo=direzioneSparo;
        System.out.println("Sparo a "+ direzioneSparo);
        switch(direzioneSparo){
            case "N":
                for(int y=1;y<=3;y++){
                    if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120-y]=="N"){
                        mappa.trovaCarro((posizioneCarroX+15)/148, (posizioneCarroY-10)/120-y);
                        break;
                    }
                }
                break;
            case "E":
                for(int x=1;x<=3;x++){
                    if(mappa.matrice[(posizioneCarroX+15)/148+x][(posizioneCarroY-10)/120]=="N"){
                        mappa.trovaCarro((posizioneCarroX+15)/148+x, (posizioneCarroY-10)/120);
                        break;
                    }
                }
                break;
            case "S":
                for(int y=1;y<=3;y++){
                    if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120+y]=="N"){
                        mappa.trovaCarro((posizioneCarroX+15)/148, (posizioneCarroY-10)/120+y);
                        break;
                    }
                }
                break;
            case "O":
                for(int x=1;x<=3;x++){
                    if(mappa.matrice[(posizioneCarroX+15)/148-x][(posizioneCarroY-10)/120]=="N"){
                        mappa.trovaCarro((posizioneCarroX+15)/148-x, (posizioneCarroY-10)/120);
                        break;
                    }
                }
                break;
        }
        resume();
    }
    public void muoviTorretta(){
    }
    public void run(){
        suspend();
        while(true){
            //NON TOCCARE E NON TOGLIERE LA LINEA SOTTO O NON FUNZIONA IL MOVIMENTO
            System.out.println(direzione);
            int xDelCarro=(posizioneCarroX+15)/148;
            int yDelCarro=(posizioneCarroY-10)/120;
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
                    mappa.matrice[xDelCarro][yDelCarro]="-";
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
                    mappa.matrice[xDelCarro][yDelCarro]="-";
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
                    mappa.matrice[xDelCarro][yDelCarro]="-";
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
                    mappa.matrice[xDelCarro][yDelCarro]="-";
                    break;
            }
            direzione="";
            if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="p"){
                B29 pilotaB29=new B29(b29,mappa,bombe);
                pilotaB29.start();
            }else if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="m"){
                Esplosione esplo=new Esplosione(esplosione);
                esplo.dammiXY(posizioneCarroX+15,posizioneCarroY-10);
                vita--;
                try
                {
                    sleep(1200);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                if(vita==0){
                    mappa.sconfitta();
                }
            }else if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="BN"){
                bandieraPresa=true;
                mappa.bandiera2.setVisible(false);
            }else if(bandieraPresa && mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="B"){
                mappa.vittoria();
            }
            if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]!="B"){
                mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]="-";
            }
            mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]="C";
            for(int i=0;i<3;i++){
                xDelCarro=(mappa.nemici[i].posizioneCarroX+16)/148;
                yDelCarro=(mappa.nemici[i].posizioneCarroY-10)/120;
                //System.out.println((mappa.nemici[i].posizioneCarroX+16)/148+" "+(mappa.nemici[i].posizioneCarroY-10)/120);
                if(mappa.nemici[i].bandieraPresa){
                    if((mappa.nemici[i].posizioneCarroX+16)/148!=12){
                        if(mappa.matrice[xDelCarro+1][yDelCarro]!="N" && mappa.matrice[xDelCarro+1][yDelCarro]!="C" || mappa.matrice[xDelCarro][yDelCarro-1]!="mN"){
                            mappa.nemici[i].muoviCarro("E");
                        }
                    }else{
                        if((mappa.nemici[i].posizioneCarroY-10)/120<4){
                            if(mappa.matrice[xDelCarro][yDelCarro+1]!="N" && mappa.matrice[xDelCarro][yDelCarro+1]!="C" || mappa.matrice[xDelCarro][yDelCarro-1]!="mN"){
                                mappa.nemici[i].muoviCarro("S");
                            }
                        }else if((mappa.nemici[i].posizioneCarroY-10)/120<4){
                            if(mappa.matrice[xDelCarro][yDelCarro-1]!="N" && mappa.matrice[xDelCarro][yDelCarro-1]!="C" || mappa.matrice[xDelCarro][yDelCarro-1]!="mN"){
                                mappa.nemici[i].muoviCarro("N");
                            }
                        }
                    }
                }else{
                    if((mappa.nemici[i].posizioneCarroX+16)/148!=0){
                        if(mappa.matrice[xDelCarro-1][yDelCarro]!="N" && mappa.matrice[xDelCarro-1][yDelCarro]!="C" || mappa.matrice[xDelCarro][yDelCarro-1]!="mN"){
                            mappa.nemici[i].muoviCarro("O");
                        }
                    }else{
                        if((mappa.nemici[i].posizioneCarroY-10)/120<4){
                            if(mappa.matrice[xDelCarro][yDelCarro+1]!="N" && mappa.matrice[xDelCarro][yDelCarro+1]!="C" || mappa.matrice[xDelCarro][yDelCarro-1]!="mN"){
                                mappa.nemici[i].muoviCarro("S");
                            }
                        }else{
                            if(mappa.matrice[xDelCarro][yDelCarro-1]!="N" && mappa.matrice[xDelCarro][yDelCarro-1]!="C" || mappa.matrice[xDelCarro][yDelCarro-1]!="mN"){
                                mappa.nemici[i].muoviCarro("N");
                            }
                        }
                    }
                }
                mappa.nemici[i].resume();
            }
            /*for(int y=0;y<9;y++){
            for(int x=0; x<13; x++){
                System.out.print(mappa.matrice[x][y]+" ");
            }
            System.out.println();
        }*/
            suspend();
            /*try
            {
                sleep(500);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }*/
        }
    }
}
