package org.mada.batch.scheduler;

import org.mada.batch.facade.IBatchFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Clase con la frecuencia de ejecuci�n de los procesos
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
	 * proceso de creaci�n de certificados individuales de publicaci�n
	 */
	@Scheduled(cron = "${cron.loadQuoteDaily}")
	public void loadQuoteDaily() {

		batchFacade.loadQuoteDailyProcess();

	}

}
