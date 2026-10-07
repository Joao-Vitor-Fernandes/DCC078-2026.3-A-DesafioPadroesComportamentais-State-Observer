package padroescomportamentais.integracaostateobserver;

public class CameraEstadoEmFalha extends CameraEstado {

    private CameraEstadoEmFalha() {};
    private static CameraEstadoEmFalha instance = new CameraEstadoEmFalha();
    public static CameraEstadoEmFalha getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Falha";
    }

    public boolean consertar(Camera camera) {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        return true;
    }
}