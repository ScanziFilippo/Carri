import javax.swing.*;
import java.awt.*;

public class Mappa extends JFrame
{
    public Mappa()
    {
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
        setSize(1800,1000);
        show();
    }
}
