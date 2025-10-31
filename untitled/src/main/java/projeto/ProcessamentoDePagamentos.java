package projeto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Random;

public class ProcessamentoDePagamentos {

    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);
    private static final String STATUS_SUCESSO = "sucesso";
    private static final String STATUS_FALHA = "falha";
    private static final String STATUS_PENDENTE = "pendente";

    public static void main(String[] args) throws InterruptedException {
        var statusPagamento = new HashMap<>();

        statusPagamento.put(STATUS_FALHA, "Erro ao processar o pagamento {}: Falha na transação.");
        statusPagamento.put(STATUS_SUCESSO, "Pagamento {} processado com sucesso.");
        statusPagamento.put(STATUS_PENDENTE, "Pagamento {} está pendente. Aguardando confirmação.");

        Random random = new Random();

        for(int i = 0; i <= 5; i++) {
            String status = gerarStatusPagamento(random);

            logger.info("Iniciando o processamento do pagamento {}.", i);

            switch (status) {
                case STATUS_FALHA:
                    logger.error(statusPagamento.get(STATUS_FALHA).toString(), i);
                    break;
                case STATUS_SUCESSO:
                    logger.info(statusPagamento.get(STATUS_SUCESSO).toString(), i);
                    break;
                case STATUS_PENDENTE:
                    logger.warn(statusPagamento.get(STATUS_PENDENTE).toString(), i);
                    break;
            }

            Thread.sleep(1000);
        }

    }

    private static String gerarStatusPagamento(Random random) {
        String[] statuses = {STATUS_FALHA, STATUS_SUCESSO, STATUS_PENDENTE};
        int index = random.nextInt(statuses.length);
        return statuses[index];
    }
}
