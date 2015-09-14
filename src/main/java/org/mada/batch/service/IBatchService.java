package org.mada.batch.service;

/**
 * Interfaz del servicio para los procesos batch.
 * 
 * @author exgc0003
 * 
 */
public interface IBatchService {

	/**
	 * Indica si un proceso batch está activo.
	 * 
	 * @param proceso
	 *            Proceso
	 * 
	 * @return Booleano
	 */
	boolean isProcesoActivo(String proceso);

	/**
	 * Método que actualiza la fecha de última ejecución de un procesoBatch
	 * 
	 * @param proceso
	 *            Proceso
	 */
	void setFechaUltimaEjecucionBatch(String proceso);

	/**
	 * Método que actualiza la fecha de inicio de un procesoBatch
	 * 
	 * @param proceso
	 *            Proceso
	 */
	void setFechaInicioBatch(String proceso);

	/**
	 * Método que actualiza la fecha de fin de un procesoBatch
	 * 
	 * @param proceso
	 *            Proceso
	 */
	void setFechaFinBatch(String proceso);
}
