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
    JLabel carro1;
    JLabel carro2;
    String direzione="";
    Mappa mappa;
    boolean bandieraPresa=false;
    JLabel b29;
    JLabel esplosione;
    JLabel[] bombe;
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
    public void muoviTorretta(){
            BufferedImage image=null;
            try
            {
                image = ImageIO.read(new File("carro2.png"));
            }
            catch (java.io.IOException ioe)
            {
                ioe.printStackTrace();
            }
            // crea una trasformazione affine per ruotare l'immagine
            AffineTransform transform = AffineTransform.getRotateInstance(
                Math.toRadians(45), // angolo di rotazione in radianti
                image.getWidth() / 2, // x del punto centrale di rotazione
                image.getHeight() / 2 // y del punto centrale di rotazione
            );
    
            // applica la trasformazione affine all'immagine
            BufferedImage rotatedImage = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_ARGB
            );
            Graphics2D g2d = rotatedImage.createGraphics();
            g2d.setTransform(transform);
            g2d.drawImage(image, 0, 0, null);
            g2d.dispose();
            carro2=new JLabel(new ImageIcon(rotatedImage));
            /*try {
                // retrieve image
                File outputfile = new File("saved.png");
                ImageIO.write(rotatedImage, "png", outputfile);
            } catch (java.io.IOException ioe) {
            }*/
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
            if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="p"){
                B29 pilotaB29=new B29(b29,mappa,bombe);
                pilotaB29.start();
            }else if(mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]=="m"){
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
            }
            mappa.matrice[(posizioneCarroX+15)/148][(posizioneCarroY-10)/120]="-";
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
