package repository.hibernate;

import entity.Writer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.WriterRepository;
import utils.HibernateUtil;

import java.util.List;

/**
 * @author Nikita Gvardeev 24.11.2021
 * email gvardeev@po-korf.ru
 */
public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public Writer getById(Long id) {
        try(Session session = HibernateUtil.session()) {
            return session.get(Writer.class, id);
        }
    }

    @Override
    public List<Writer> findAll() {
        try(Session session = HibernateUtil.session()) {
            Query<Writer> query = session.createQuery("FROM Writer");
            return query.getResultList();
        }
    }

    @Override
    public Writer save(Writer writer) {
        try(Session session = HibernateUtil.session()) {
            session.beginTransaction();
            Long id = (Long) session.save(writer);
            session.getTransaction().commit();
            return session.load(Writer.class, id);
        }
    }

    @Override
    public void update(Writer writer) {
        try(Session session = HibernateUtil.session()) {
            session.beginTransaction();
            session.update(writer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = HibernateUtil.session()) {
            session.beginTransaction();
            Writer writer = new Writer();
            writer.setId(id);
            session.delete(writer);
            session.getTransaction().commit();
        }
    }
}
