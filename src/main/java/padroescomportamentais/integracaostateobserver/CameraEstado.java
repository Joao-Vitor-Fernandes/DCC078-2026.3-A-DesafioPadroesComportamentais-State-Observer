package padroescomportamentais.integracaostateobserver;

public abstract class CameraEstado {

    public abstract String getEstado();

    public boolean ligar(Camera camera) {
        return false;
    }

    public boolean desligar(Camera camera) {
        return false;
    }

    public boolean detectarMovimento(Camera camera) {
        return false;
    }

    public boolean confirmarIntrusao(Camera camera) {
        return false;
    }

    public boolean normalizar(Camera camera) {
        return false;
    }

    public boolean reportarFalha(Camera camera) {
        return false;
    }

    public boolean consertar(Camera camera) {
        return false;
    }

}
