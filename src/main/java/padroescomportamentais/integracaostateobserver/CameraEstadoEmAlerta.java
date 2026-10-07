package padroescomportamentais.integracaostateobserver;

public class CameraEstadoEmAlerta extends CameraEstado {

    private CameraEstadoEmAlerta() {};
    private static CameraEstadoEmAlerta instance = new CameraEstadoEmAlerta();
    public static CameraEstadoEmAlerta getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Alerta";
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
