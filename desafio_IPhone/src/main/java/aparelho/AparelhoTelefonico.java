package main.java.aparelho;

public interface AparelhoTelefonico {

    public void fazerChamada(String numero);
    public void receberChamada(String numero);
    public void encerrarChamada();
    public void enviarMensagem(String numero, String mensagem);
    public void receberMensagem(String numero, String mensagem);
}
