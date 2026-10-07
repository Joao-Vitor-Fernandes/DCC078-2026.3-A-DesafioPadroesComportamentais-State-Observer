package padroescomportamentais.integracaostateobserver;

import java.util.Observable;

public class Camera extends Observable {

    private Integer id;
    private String local;
    private CameraEstado estado;

    public Camera(Integer id, String local) {
        this.id = id;
        this.local = local;
        this.estado = CameraEstadoDesligada.getInstance();
    }

    public void setEstado(CameraEstado estado) {
        this.estado = estado;
    }

    public boolean ligar() {
        return notificarSeMudou(estado.ligar(this));
    }

    public boolean desligar() {
        return notificarSeMudou(estado.desligar(this));
    }

    public boolean detectarMovimento() {
        return notificarSeMudou(estado.detectarMovimento(this));
    }

    public boolean confirmarIntrusao() {
        return notificarSeMudou(estado.confirmarIntrusao(this));
    }

    public boolean normalizar() {
        return notificarSeMudou(estado.normalizar(this));
    }

    public boolean reportarFalha() {
        return notificarSeMudou(estado.reportarFalha(this));
    }

    public boolean consertar() {
        return notificarSeMudou(estado.consertar(this));
    }

    private boolean notificarSeMudou(boolean transicionou) {
        if (transicionou) {
            setChanged();
            notifyObservers(estado.getEstado());
        }
        return transicionou;
    }

    public CameraEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public Integer getId() {
        return id;
    }

    public String getLocal() {
        return local;
    }

    @Override
    public String toString() {
        return "Camera{" +
            "id=" + id +
            ", local='" + local + '\'' +
            '}';
    }
}
