package padroescomportamentais.integracaostateobserver;

public class CameraEstadoDesligada extends CameraEstado {

    private CameraEstadoDesligada() {};
    private static CameraEstadoDesligada instance = new CameraEstadoDesligada();
    public static CameraEstadoDesligada getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Desligada";
    }

    @Override
    public boolean ligar(Camera camera) {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        return true;
    }

}