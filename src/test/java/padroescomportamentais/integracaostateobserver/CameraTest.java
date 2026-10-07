package padroescomportamentais.integracaostateobserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CameraTest {

    Camera camera;

    @BeforeEach
    public void setUp() {
        camera = new Camera(1, "Portaria");
    }

    @Test
    public void deveIniciarCameraDesligada() {
        assertEquals(CameraEstadoDesligada.getInstance(), camera.getEstado());
        assertEquals("Desligada", camera.getNomeEstado());
    }

    // Câmera desligada

    @Test
    public void deveLigarCameraDesligada() {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        assertTrue(camera.ligar());
        assertEquals(CameraEstadoMonitorando.getInstance(), camera.getEstado());
    }

    @Test
    public void naoDeveDesligarCameraDesligada() {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        assertFalse(camera.desligar());
    }

    @Test
    public void naoDeveDetectarMovimentoCameraDesligada() {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        assertFalse(camera.detectarMovimento());
    }

    @Test
    public void naoDeveConfirmarIntrusaoCameraDesligada() {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        assertFalse(camera.confirmarIntrusao());
    }

    @Test
    public void naoDeveNormalizarCameraDesligada() {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        assertFalse(camera.normalizar());
    }

    @Test
    public void naoDeveReportarFalhaCameraDesligada() {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        assertFalse(camera.reportarFalha());
    }

    @Test
    public void naoDeveConsertarCameraDesligada() {
        camera.setEstado(CameraEstadoDesligada.getInstance());
        assertFalse(camera.consertar());
    }

    // Câmera monitorando

    @Test
    public void naoDeveLigarCameraMonitorando() {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        assertFalse(camera.ligar());
    }

    @Test
    public void deveDesligarCameraMonitorando() {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        assertTrue(camera.desligar());
        assertEquals(CameraEstadoDesligada.getInstance(), camera.getEstado());
    }

    @Test
    public void deveDetectarMovimentoCameraMonitorando() {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        assertTrue(camera.detectarMovimento());
        assertEquals(CameraEstadoGravando.getInstance(), camera.getEstado());
    }

    @Test
    public void naoDeveConfirmarIntrusaoCameraMonitorando() {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        assertFalse(camera.confirmarIntrusao());
    }

    @Test
    public void naoDeveNormalizarCameraMonitorando() {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        assertFalse(camera.normalizar());
    }

    @Test
    public void deveReportarFalhaCameraMonitorando() {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        assertTrue(camera.reportarFalha());
        assertEquals(CameraEstadoEmFalha.getInstance(), camera.getEstado());
    }

    @Test
    public void naoDeveConsertarCameraMonitorando() {
        camera.setEstado(CameraEstadoMonitorando.getInstance());
        assertFalse(camera.consertar());
    }

    // Câmera gravando

    @Test
    public void naoDeveLigarCameraGravando() {
        camera.setEstado(CameraEstadoGravando.getInstance());
        assertFalse(camera.ligar());
    }

    @Test
    public void deveDesligarCameraGravando() {
        camera.setEstado(CameraEstadoGravando.getInstance());
        assertTrue(camera.desligar());
        assertEquals(CameraEstadoDesligada.getInstance(), camera.getEstado());
    }

    @Test
    public void naoDeveDetectarMovimentoCameraGravando() {
        camera.setEstado(CameraEstadoGravando.getInstance());
        assertFalse(camera.detectarMovimento());
    }

    @Test
    public void deveConfirmarIntrusaoCameraGravando() {
        camera.setEstado(CameraEstadoGravando.getInstance());
        assertTrue(camera.confirmarIntrusao());
        assertEquals(CameraEstadoEmAlerta.getInstance(), camera.getEstado());
    }

    @Test
    public void deveNormalizarCameraGravando() {
        camera.setEstado(CameraEstadoGravando.getInstance());
        assertTrue(camera.normalizar());
        assertEquals(CameraEstadoMonitorando.getInstance(), camera.getEstado());
    }

    @Test
    public void deveReportarFalhaCameraGravando() {
        camera.setEstado(CameraEstadoGravando.getInstance());
        assertTrue(camera.reportarFalha());
        assertEquals(CameraEstadoEmFalha.getInstance(), camera.getEstado());
    }

    @Test
    public void naoDeveConsertarCameraGravando() {
        camera.setEstado(CameraEstadoGravando.getInstance());
        assertFalse(camera.consertar());
    }

    // Câmera em alerta

    @Test
    public void naoDeveLigarCameraEmAlerta() {
        camera.setEstado(CameraEstadoEmAlerta.getInstance());
        assertFalse(camera.ligar());
    }

    @Test
    public void naoDeveDesligarCameraEmAlerta() {
        camera.setEstado(CameraEstadoEmAlerta.getInstance());
        assertFalse(camera.desligar());
    }

    @Test
    public void naoDeveDetectarMovimentoCameraEmAlerta() {
        camera.setEstado(CameraEstadoEmAlerta.getInstance());
        assertFalse(camera.detectarMovimento());
    }

    @Test
    public void naoDeveConfirmarIntrusaoCameraEmAlerta() {
        camera.setEstado(CameraEstadoEmAlerta.getInstance());
        assertFalse(camera.confirmarIntrusao());
    }

    @Test
    public void deveNormalizarCameraEmAlerta() {
        camera.setEstado(CameraEstadoEmAlerta.getInstance());
        assertTrue(camera.normalizar());
        assertEquals(CameraEstadoMonitorando.getInstance(), camera.getEstado());
    }

    @Test
    public void deveReportarFalhaCameraEmAlerta() {
        camera.setEstado(CameraEstadoEmAlerta.getInstance());
        assertTrue(camera.reportarFalha());
        assertEquals(CameraEstadoEmFalha.getInstance(), camera.getEstado());
    }

    @Test
    public void naoDeveConsertarCameraEmAlerta() {
        camera.setEstado(CameraEstadoEmAlerta.getInstance());
        assertFalse(camera.consertar());
    }

    // Câmera em falha

    @Test
    public void naoDeveLigarCameraEmFalha() {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        assertFalse(camera.ligar());
    }

    @Test
    public void naoDeveDesligarCameraEmFalha() {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        assertFalse(camera.desligar());
    }

    @Test
    public void naoDeveDetectarMovimentoCameraEmFalha() {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        assertFalse(camera.detectarMovimento());
    }

    @Test
    public void naoDeveConfirmarIntrusaoCameraEmFalha() {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        assertFalse(camera.confirmarIntrusao());
    }

    @Test
    public void naoDeveNormalizarCameraEmFalha() {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        assertFalse(camera.normalizar());
    }

    @Test
    public void naoDeveReportarFalhaCameraEmFalha() {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        assertFalse(camera.reportarFalha());
    }

    @Test
    public void deveConsertarCameraEmFalha() {
        camera.setEstado(CameraEstadoEmFalha.getInstance());
        assertTrue(camera.consertar());
        assertEquals(CameraEstadoDesligada.getInstance(), camera.getEstado());
    }
}
