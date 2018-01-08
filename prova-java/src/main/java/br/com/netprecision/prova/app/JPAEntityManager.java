/**
 * 
 */
package br.com.netprecision.prova.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Jaime
 *
 */
public class JPAEntityManager {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
	private EntityManager em = factory.createEntityManager();

	public EntityManager getEntityManager() {
		return em;
	}
}
