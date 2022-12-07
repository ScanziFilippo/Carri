public class Main
{
    public CarroArmato carro;
    public Main()
    {
        Mappa mappa=new Mappa();
        carro=new CarroArmato(mappa);
        mappa.passaStoCarro(carro);
        Nemici nemico1=new Nemici(mappa);
        mappa.aggiungiScacchiera();
    }
}
