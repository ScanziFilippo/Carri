import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

public class Mappa extends JFrame implements MouseListener
{
    public CarroArmato carro;
    public JLabel b29;
    public JLabel bandiera1;
    public JLabel bandiera2;
    public int xDelCarro=1;
    public int yDelCarro=4;
    public String[][] matrice=new String[13][9];
    public Mappa()
    {
        //Mouse
        addMouseListener(this);  
        //Genera la struttura e dati del campo
        for(int x=0; x<13; x++){
            for(int y=0;y<9;y++){
                matrice[x][y]="-";
            }
        }
        for(int x=0; x<13; x++){
            if(x==0){
                matrice[0][4]="B";
                matrice[12][4]="B";
            }else if(x==1){
                matrice[1][4]="C";
            }else if(x>1 && x<11){
                for(int y=0;y<9;y++){
                    if(Math.random()<0.01){
                        matrice[x][y]="p";
                    }else if(Math.random()<0.02){
                        matrice[x][y]="m";
                    }
                }
            }else if(x==11){
                matrice[11][1]="N";
                matrice[11][3]="N";
                matrice[11][5]="N";
                matrice[11][7]="N";
            }
        }
        for(int y=0;y<9;y++){
            for(int x=0; x<13; x++){
                System.out.print(matrice[x][y]+" ");
            }
            System.out.println();
        }
        //Grafica campo, b29 e bandiere
        setLayout(null);
        setSize(1500,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setVisible(true);
        b29=new JLabel(new ImageIcon("b29.png"));
        add(b29);
        b29.setSize(650,911);
        b29.setLocation(-800,85);
        bandiera1=new JLabel(new ImageIcon("bandiera1.png"));
        add(bandiera1);
        bandiera1.setSize(650,911);
        bandiera1.setLocation(-255,80);
        bandiera2=new JLabel(new ImageIcon("bandiera2.png"));
        add(bandiera2);
        bandiera2.setSize(650,911);
        bandiera2.setLocation(1520,80);
    }
    public void passaStoCarro(CarroArmato carroInEntrata){
        carro=carroInEntrata;
        carro.start();
    }
    public void aggiungiScacchiera(){
        JLabel scacchiera=new JLabel(new ImageIcon("scacchiera.png"));
        add(scacchiera);
        scacchiera.setSize(1920, 1080);
        scacchiera.setLocation(0, 0);
        show();
    }
    public void chiamaB29(){
        for(int i=-800;i<2600;i++){
            System.out.println(i);
            b29.setLocation(i,85);
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
    public void mouseClicked(MouseEvent e) {  
        int posizioneRelativaX=e.getX()-carro.daiPosizioneX()-15;
        int posizioneRelativaY=e.getY()-carro.daiPosizioneY()+10;
        xDelCarro=(carro.posizioneCarroX+15)/148;
        yDelCarro=(carro.posizioneCarroY-10)/120;
        //System.out.println(posizioneRelativaX+" "+posizioneRelativaY);
        if(e.getButton()==3){
            if(posizioneRelativaX>=0 && posizioneRelativaX<=148){
                if(posizioneRelativaY<0 && posizioneRelativaY>=-148){
                    if(matrice[xDelCarro][yDelCarro-1]!="B" && matrice[xDelCarro][yDelCarro-1]!="N"){
                        carro.muoviCarro("N", carro.carro1, carro.carro2);
                    }
                }else if(posizioneRelativaY>148 && posizioneRelativaY<296){
                    if(matrice[xDelCarro][yDelCarro+1]!="B" && matrice[xDelCarro][yDelCarro+1]!="N"){
                        carro.muoviCarro("S", carro.carro1, carro.carro2);
                    }
                }
            }else if(posizioneRelativaX<0 && posizioneRelativaX>=-148){
                if(posizioneRelativaY>0 && posizioneRelativaY<148){
                    if(matrice[xDelCarro-1][yDelCarro]!="B" && matrice[xDelCarro-1][yDelCarro]!="N"){
                        carro.muoviCarro("O", carro.carro1, carro.carro2);
                    }
                }
            }else if(posizioneRelativaX>=148 && posizioneRelativaX<296){
                if(posizioneRelativaY>0 && posizioneRelativaY<148){
                    if(matrice[xDelCarro+1][yDelCarro]!="B" && matrice[xDelCarro+1][yDelCarro]!="N"){
                        carro.muoviCarro("E", carro.carro1, carro.carro2);
                    }
                }
            }else{
                if(e.getX()==1919){
                    B29 pilotaB29=new B29(b29);
                    pilotaB29.start();
                }
            }
        }
    }
    public void mouseEntered(MouseEvent e) {  
    }  
    public void mouseExited(MouseEvent e) {  
    }  
    public void mousePressed(MouseEvent e) {  
    }  
    public void mouseReleased(MouseEvent e) {  
    }
}
