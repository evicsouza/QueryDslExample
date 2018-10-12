package br.edu.ifpe.jpa.querydsl;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.querydsl.jpa.impl.JPAQuery;

public class EntityManagerHelper {

	private EntityManagerHelper() { }
	
	public static EntityManagerHelper getInstance() {
		return new EntityManagerHelper();
	}
	
	public <T> void execute(Consumer<JPAQuery<T>> action) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("MyPersicenceUnit");
		EntityManager em = fabrica.createEntityManager();

		try {
			action.accept(new JPAQuery<T>(em));
		} finally {
			em.close();
			fabrica.close();
		}
	}
}
