package padroescomportamentais.integracaostateobserver;

import java.util.Observable;
import java.util.Observer;

public class Vigilante implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Vigilante(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void monitorar(Camera camera) {
        camera.addObserver(this);
    }

    @Override
    public void update(Observable camera, Object estado) {
        this.ultimaNotificacao = this.nome + ", " + camera.toString() + " mudou para o estado " + estado;
    }
}
