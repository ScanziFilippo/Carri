import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mappa extends JFrame implements MouseListener
{
    public CarroArmato carro;
    public Mappa()
    {
        //Mouse
        addMouseListener(this);  
        //Genera la struttura e dati del campo
        String[][] matrice=new String[15][10];
        for(int x=0; x<15; x++){
            for(int y=0;y<10;y++){
                matrice[x][y]=" ";
            }
        }
        for(int x=0; x<15; x++){
            if(x==0){
                matrice[0][4]="B";
                matrice[14][4]="B";
            }else if(x==1){
                matrice[1][4]="C";
            }else if(x>1 && x<13){
                for(int y=0;y<10;y++){
                    if(Math.random()<0.01){
                        matrice[x][y]="p";
                    }else if(Math.random()<0.02){
                        matrice[x][y]="m";
                    }
                }
            }else if(x==13){
                matrice[13][1]="N";
                matrice[13][3]="N";
                matrice[13][5]="N";
                matrice[13][7]="N";
            }
        }
        for(int y=0;y<10;y++){
            for(int x=0; x<15; x++){
                //System.out.print(matrice[x][y]+" ");
            }
            //System.out.println();
        }
        //Grafica campo e carri
        setLayout(null);
        setSize(1500,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setVisible(true);
    }
    public void passaStoCarro(CarroArmato carroInEntrata){
        carro= carroInEntrata;
    }
    public void aggiungiScacchiera(){
        JLabel scacchiera=new JLabel(new ImageIcon("scacchiera.png"));
        add(scacchiera);
        scacchiera.setSize(1920, 1080);
        scacchiera.setLocation(0, 0);
        show();
    }
    public void mouseClicked(MouseEvent e) {  
        int posizioneRelativaX=e.getX()-carro.daiPosizioneX()-15;
        int posizioneRelativaY=e.getY()-carro.daiPosizioneY()+10;
        //System.out.println(posizioneRelativaX+" "+posizioneRelativaY);
        if(posizioneRelativaX>=0 && posizioneRelativaX<=148){
            if(posizioneRelativaY<0 && posizioneRelativaY>=-148){
                carro.muoviCarro("N", carro.carro1, carro.carro2);
            }else if(posizioneRelativaY>148 && posizioneRelativaY<296){
                carro.muoviCarro("S", carro.carro1, carro.carro2);
            }
        }else if(posizioneRelativaX<0 && posizioneRelativaX>=-148){
            if(posizioneRelativaY>0 && posizioneRelativaY<148){
                carro.muoviCarro("O", carro.carro1, carro.carro2);
            }
        }else if(posizioneRelativaX>=148 && posizioneRelativaX<296){
            if(posizioneRelativaY>0 && posizioneRelativaY<148){
                carro.muoviCarro("E", carro.carro1, carro.carro2);
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
