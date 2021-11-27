package repository.hibernate;

import model.entity.Writer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.WriterRepository;
import util.HibernateUtil;

import java.util.List;

/**
 * @author Nikita Gvardeev 24.11.2021
 * email gvardeev@po-korf.ru
 */
public class WriterRepositoryImpl implements WriterRepository {

    @Override
    public Writer getById(Long id) {
        Session session = HibernateUtil.sessionFactory().openSession();
        Writer writer = session.get(Writer.class, id);
        session.close();
        return writer;
    }

    @Override
    public List<Writer> findAll() {
        Session session = HibernateUtil.sessionFactory().openSession();
        Query<Writer> query = session.createQuery("FROM Writer");
        List<Writer> writers = query.getResultList();
        session.close();
        return writers;
    }

    @Override
    public Writer save(Writer writer) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        Long id = (Long) session.save(writer);
        session.getTransaction().commit();
        Writer persist = session.load(Writer.class, id);
        session.close();
        return persist;
    }

    @Override
    public void update(Writer writer) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        session.update(writer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        Writer writer = new Writer();
        writer.setId(id);
        session.delete(writer);
        session.getTransaction().commit();
        session.close();
    }
}
