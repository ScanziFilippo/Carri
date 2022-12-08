import javax.swing.*;

public class B29 extends Thread
{
    public JLabel b29;
    public B29(JLabel b29)
    {
        this.b29=b29;
    }
    public void run(){
        for(int i=-800;i<2600;i++){
            System.out.println(i);
            b29.setLocation(i,85);
            try
            {
                sleep(1);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}