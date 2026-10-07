package padroescomportamentais.integracaostateobserver;

public class CameraEstadoGravando extends CameraEstado {

    private CameraEstadoGravando() {};
    private static CameraEstadoGravando instance = new CameraEstadoGravando();
    public static CameraEstadoGravando getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Gravando";
    }

    public boolean desligar(Camera camera) {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        return true;
    }

    public boolean confirmarIntrusao(Camera camera) {
        camera.setEstado(CameraEstadoEmAlerta.getInstance());
        return true;
    }

    public boolean normalizar(Camera camera) {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        return true;
    }

    public boolean reportarFalha(Camera camera) {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        return true;
    }
}