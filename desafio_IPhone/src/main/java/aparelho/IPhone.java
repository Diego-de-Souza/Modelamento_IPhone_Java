package main.java.aparelho;

import java.util.Scanner;

public class IPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{
    private String modelo;
    private String numeroSerie;
    private int capacidadeArmazenamento;
    private Boolean musicaTocando = false;
    private String nomeMusica;
    private int volumeMusica=1;
    private Boolean statusLigacaoEfetuada = false;
    private Boolean statusLigacaoRecebida = false;
    private  Boolean statusUrl = false;

    Scanner entrada = new Scanner(System.in);
    public IPhone(String modelo, String numeroSerie, int capacidadeArmazenamento) {
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.capacidadeArmazenamento = capacidadeArmazenamento;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public int getCapacidadeArmazenamento() {
        return capacidadeArmazenamento;
    }

    @Override
    public void reproduzirMusica() {
        if (musicaTocando == false) {
            System.out.println("Digite o nome da música que deseja ouvir: ");
            nomeMusica = entrada.nextLine();
            System.out.println("Tocando " + nomeMusica);
            musicaTocando = true;
        }else {
            System.out.println("A música "+nomeMusica+" já está tocando");
        }
    }
    @Override
    public void pausarMusica() {
        if (musicaTocando == true){
            System.out.println("Música "+nomeMusica+" pausada...");
            musicaTocando = false;
        }else {
            System.out.println("Opção já efetuada...");
        }
    }
    @Override
    public void avancarMusica() {
     if (musicaTocando == true){
         System.out.println("Avançando música..."+
                            "Música avançada!");
     }else{
         System.out.println("Não tem como avançar a música está parada...Aperte reproduzir!");
     }
    }

    @Override
    public void voltarMusica() {
        if (musicaTocando == true){
            System.out.println("Retornando música..."+
                                "Música retornada!");
        }else{
            System.out.println("Não tem como retornar a música está parada...Aperte reproduzir!");
        }
    }

    @Override
    public void ajustarVolume(int volume) {
        if (musicaTocando == true) {
            System.out.println("volume está em: " + volumeMusica);
        }else {
            System.out.println("Não tem como ajustar o volume, nenhuma música rodando...");
        }
    }

    @Override
    public void fazerChamada(String numero) {
        if(statusLigacaoRecebida == true){
            System.out.println("Existe uma ligação recebida em andamento...");
        }else if(statusLigacaoEfetuada == true){
            System.out.println("Existe uma ligação efetuada em andamento...");
        }else{
            System.out.println(modelo+" discando para "+numero+
                                modelo+" discando para "+numero+
                                modelo+" discando para "+numero+
                                "ligação atendida 00:01");
        }
    }

    @Override
    public void receberChamada(String numero) {
        String numeroTelefone = "119";
        for (int x=1;x<=8;x++) {
            double randomNumber = Math.random() * 9;
            int randomInteiro = (int)randomNumber;
            numeroTelefone = numeroTelefone + Integer.toString(randomInteiro);
        }
        System.out.println("Recebendo chamada de "+numeroTelefone);
    }

    @Override
    public void encerrarChamada() {
        if (statusLigacaoEfetuada == true || statusLigacaoRecebida == true){
            System.out.println("ligação encerrada");
            statusLigacaoRecebida = false;
            statusLigacaoEfetuada = false;
        }
    }

    @Override
    public void enviarMensagem(String numero, String mensagem) {
        System.out.println("Mensagem enviada para "+numero+
                            "mensagem: "+mensagem);
    }

    @Override
    public void receberMensagem(String numero, String mensagem) {
        String numeroTelefone = "119";
        for (int x=1;x<=8;x++) {
            double randomNumber = Math.random() * 9;
            int randomInteiro = (int)randomNumber;
            numeroTelefone = numeroTelefone + Integer.toString(randomInteiro);
        }
        System.out.println("Mensagem recebida de "+numeroTelefone+
                            "mensagem: Deu certo, mensagem recebida com sucesso!");
    }

    @Override
    public void abrirPagina(String url) {
            System.out.println("Abrindo página " + url +
                    "Página aberta.....");
            statusUrl = true;
    }

    @Override
    public void fecharPagina() {
        if (statusUrl == true){
            System.out.println("Fechando página "+
                                "Página aberta.....");
            statusUrl = false;
        }
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página atualizada!!!");
    }
}
