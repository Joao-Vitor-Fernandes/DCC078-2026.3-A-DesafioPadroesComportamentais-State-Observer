package padroescomportamentais.integracaostateobserver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VigilanteTest {

    @Test
    void deveNotificarUmVigilante() {
        Camera camera = new Camera(1, "Portaria");
        Vigilante vigilante = new Vigilante("Vigilante 1");
        vigilante.monitorar(camera);
        camera.ligar();
        assertEquals("Vigilante 1, Camera{id=1, local='Portaria'} mudou para o estado Monitorando", vigilante.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVigilantes() {
        Camera camera = new Camera(1, "Portaria");
        Vigilante vigilante1 = new Vigilante("Vigilante 1");
        Vigilante vigilante2 = new Vigilante("Vigilante 2");
        vigilante1.monitorar(camera);
        vigilante2.monitorar(camera);
        camera.ligar();
        assertEquals("Vigilante 1, Camera{id=1, local='Portaria'} mudou para o estado Monitorando", vigilante1.getUltimaNotificacao());
        assertEquals("Vigilante 2, Camera{id=1, local='Portaria'} mudou para o estado Monitorando", vigilante2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarVigilanteQueNaoMonitoraCamera() {
        Camera camera = new Camera(1, "Portaria");
        Vigilante vigilante = new Vigilante("Vigilante 1");
        camera.ligar();
        assertEquals(null, vigilante.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarVigilanteQuandoTransicaoForInvalida() {
        Camera camera = new Camera(1, "Portaria");
        Vigilante vigilante = new Vigilante("Vigilante 1");
        vigilante.monitorar(camera);
        assertFalse(camera.desligar());
        assertEquals(null, vigilante.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVigilanteDaCameraMonitorada() {
        Camera cameraPortaria = new Camera(1, "Portaria");
        Camera cameraGaragem = new Camera(2, "Garagem");
        Vigilante vigilante1 = new Vigilante("Vigilante 1");
        Vigilante vigilante2 = new Vigilante("Vigilante 2");
        vigilante1.monitorar(cameraPortaria);
        vigilante2.monitorar(cameraGaragem);
        cameraPortaria.ligar();
        assertEquals("Vigilante 1, Camera{id=1, local='Portaria'} mudou para o estado Monitorando", vigilante1.getUltimaNotificacao());
        assertEquals(null, vigilante2.getUltimaNotificacao());
    }

    @Test
    void deveNotificarVigilanteQueMonitoraVariasCameras() {
        Camera cameraPortaria = new Camera(1, "Portaria");
        Camera cameraGaragem = new Camera(2, "Garagem");
        Vigilante vigilante = new Vigilante("Vigilante 1");
        vigilante.monitorar(cameraPortaria);
        vigilante.monitorar(cameraGaragem);
        cameraPortaria.ligar();
        cameraGaragem.ligar();
        assertEquals("Vigilante 1, Camera{id=2, local='Garagem'} mudou para o estado Monitorando", vigilante.getUltimaNotificacao());
    }

    @Test
    void deveNotificarGravacaoPorMovimento() {
        Camera camera = new Camera(1, "Portaria");
        Vigilante vigilante = new Vigilante("Vigilante 1");
        vigilante.monitorar(camera);
        camera.ligar();
        camera.detectarMovimento();
        assertEquals("Vigilante 1, Camera{id=1, local='Portaria'} mudou para o estado Gravando", vigilante.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlertaDeIntrusao() {
        Camera camera = new Camera(1, "Portaria");
        Vigilante vigilante = new Vigilante("Vigilante 1");
        vigilante.monitorar(camera);
        camera.ligar();
        camera.detectarMovimento();
        camera.confirmarIntrusao();
        assertEquals("Vigilante 1, Camera{id=1, local='Portaria'} mudou para o estado Em Alerta", vigilante.getUltimaNotificacao());
    }

    @Test
    void deveNotificarFalhaDaCamera() {
        Camera camera = new Camera(1, "Portaria");
        Vigilante vigilante = new Vigilante("Vigilante 1");
        vigilante.monitorar(camera);
        camera.ligar();
        camera.reportarFalha();
        assertEquals("Vigilante 1, Camera{id=1, local='Portaria'} mudou para o estado Em Falha", vigilante.getUltimaNotificacao());
    }

    @Test
    void deveNotificarConsertoDaCamera() {
        Camera camera = new Camera(1, "Portaria");
        Vigilante vigilante = new Vigilante("Vigilante 1");
        vigilante.monitorar(camera);
        camera.ligar();
        camera.reportarFalha();
        camera.consertar();
        assertEquals("Vigilante 1, Camera{id=1, local='Portaria'} mudou para o estado Desligada", vigilante.getUltimaNotificacao());
    }
}