import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private final List<CanalNotificacao> canais;

    public ProcessadorVideo(){
        this.canais = new ArrayList<>();
    }

    public void registrarCanal(CanalNotificacao canal) {
        canais.add(canal);
    }

    public void processar(Video video) {
        var texto = video.getArquivo() + " - " + video.getFormato();
        var mensagem = new Mensagem(texto, TipoMensagem.LOG);
        canais.forEach(canal -> canal.notificar(mensagem));
    }
}
