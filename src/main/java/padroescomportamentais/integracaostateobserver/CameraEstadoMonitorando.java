package padroescomportamentais.integracaostateobserver;

public class CameraEstadoMonitorando extends CameraEstado {

    private CameraEstadoMonitorando() {};
    private static CameraEstadoMonitorando instance = new CameraEstadoMonitorando();
    public static CameraEstadoMonitorando getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Monitorando";
    }

    public boolean desligar(Camera camera) {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        return true;
    }

    public boolean detectarMovimento(Camera camera) {
        camera.setEstado(CameraEstadoGravando.getInstance());
        return true;
    }

    public boolean reportarFalha(Camera camera) {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        return true;
    }
}
