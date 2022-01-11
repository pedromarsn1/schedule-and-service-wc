package sophos.uniplus.woocommerce.conection.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sophos.uniplus.woocommerce.conection.service.UniplusConnectedProductService;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateProductScheduling {

    private final UniplusConnectedProductService uniplusConnectedProductService;

    @Scheduled(cron =  "0 */5 * * * *")
    public void execute() throws SQLException {
        log.info("Iniciando atualização de produto as " + LocalDateTime.now());
        uniplusConnectedProductService.updateProductWoocommerce();
        log.info("Atualização de produto realizada com sucesso as " + LocalDateTime.now());
    }
}
