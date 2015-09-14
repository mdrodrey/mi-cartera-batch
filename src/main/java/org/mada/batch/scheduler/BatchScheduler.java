package org.mada.batch.scheduler;

import org.mada.batch.facade.IBatchFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Clase con la frecuencia de ejecución de los procesos
 *
 * @author grlp0143
 *
 */
@Service
@EnableScheduling
public class BatchScheduler {

	@Autowired
	private IBatchFacade batchFacade;

	/**
	 * proceso de creación de certificados individuales de publicación
	 */
	@Scheduled(cron = "${cron.loadQuoteDaily}")
	public void loadQuoteDaily() {

		batchFacade.loadQuoteDailyProcess();

	}

}
