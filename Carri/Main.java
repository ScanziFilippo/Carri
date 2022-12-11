public class Main
{
    public CarroArmato carro;
    public Mappa mappa;
    public Main()
    {
        mappa=new Mappa();
        carro=new CarroArmato(mappa);
        mappa.passaStoCarro(carro);
        Nemici nemico1=new Nemici(mappa);
        mappa.aggiungiScacchiera();
        //carro.muoviTorretta();
    }
}
