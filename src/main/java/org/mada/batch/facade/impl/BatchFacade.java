package org.mada.batch.facade.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mada.batch.facade.IBatchFacade;
import org.mada.es.mibolsa.facade.IQuoteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fachada para los procesos batch. El nombre de cada método corresponde con el
 * nombre a comprobar en la tabla NXPROCESOBATCH
 *
 * @author grlp0143
 *
 */
@Service
public class BatchFacade implements IBatchFacade {

	private static final Log logger = LogFactory.getLog(BatchFacade.class);

	/*
	 * fachadas y servicios con los que interacciona
	 */
	@Autowired
	private IQuoteFacade quoteFacade;

	public void loadQuoteDailyProcess() {
		logger.info("cargando cotizaciones diarias");
		quoteFacade.loadQuoteProcess();

	}

}
