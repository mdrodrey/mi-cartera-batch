package org.mada.batch.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Aspectos para la clase BatchFacade
 *
 */
@Configurable
@Aspect
public class BatchAspect {

	/* Logger de la clase */
	private static final Log logger = LogFactory.getLog(BatchAspect.class);

	/**
	 * Aspecto para tratamiento de excepciones en procesos. se loga y se env�a
	 * correo. Si la excepci�n es por estar inactivo no se env�a correo. se loga
	 * y se continua.
	 *
	 * @param joinPoint
	 *            datos del m�todo a lanzar
	 * @param exception
	 *            excepci�n producida
	 */
	@AfterThrowing(pointcut = "execution(public * org.grecasa.batch.scheduler.BatchScheduler.*(..))", throwing = "exception")
	public void tratarExcepcion(JoinPoint joinPoint, Throwable exception) {

	}

	/**
	 * Log y control del estado del proceso para continunar la ejecuci�n.
	 *
	 * @param joinPoint
	 *            datos del m�todo a ejecutar
	 */
	@Before(value = "execution(public * org.grecasa.batch.facade.impl.BatchFacade.*(..))", argNames = "joinPoint")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void logExecuteBefore(JoinPoint joinPoint) {

		logger.info("Inicio del proceso [" + joinPoint.getSignature() + "]");

	}

	/**
	 * Log y fechas de fin del m�todo y procesos.
	 *
	 * @param joinPoint
	 *            datos del m�todo a ejecutar
	 */
	@AfterReturning(value = "execution(public * org.grecasa.batch.facade.impl.BatchFacade.*(..))", argNames = "joinPoint")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void logExecuteAfter(JoinPoint joinPoint) {

		logger.debug("Fin del proceso [" + joinPoint.getSignature() + "]");

	}

}
