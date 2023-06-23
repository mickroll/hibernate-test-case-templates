package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.example.entity.catalog.CatalogValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateReproducerTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void destroy() {
        entityManager.getTransaction().rollback();
        entityManagerFactory.close();
    }

    @Test
    public void metadataBug() {
        final var bav = findByKey("DE-BY"); // has metadata
        findByKey("DE"); // has NO metadata
        bav.getMetadata().size();
    }

    @Test
    public void positiveCase() {
        final var bav = findByKey("DE-BY"); // has metadata
        findByKey("AT"); // has metadata
        bav.getMetadata().size();
    }

    CatalogValue findByKey(final String key) {
        final var cb = entityManager.getCriteriaBuilder();
        final var query = cb.createQuery(CatalogValue.class);
        final var root = query.from(CatalogValue.class);
        query.where(cb.equal(root.get("key"), key));
        final var result = entityManager.createQuery(query).getResultList();
        if (result.isEmpty()) {
            throw new IllegalStateException("mandatory catalog value not found "  + key);
        }
        if (result.size() == 1) {
            return result.get(0);
        }
        throw new IllegalStateException("multiple entities foun for the same key "  + key);
    }
}
