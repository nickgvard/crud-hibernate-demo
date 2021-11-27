package repository.hibernate;

import model.entity.Label;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.LabelRepository;
import util.HibernateUtil;

import java.util.List;

/**
 * @author Nikita Gvardeev 24.11.2021
 * email gvardeev@po-korf.ru
 */
public class LabelRepositoryImpl implements LabelRepository {

    @Override
    public Label getById(Long id) {
        Session session = HibernateUtil.sessionFactory().openSession();
        Label label = session.get(Label.class, id);
        session.close();
        return label;
    }

    @Override
    public List<Label> findAll() {
        Session session = HibernateUtil.sessionFactory().openSession();
        Query<Label> query = session.createQuery("FROM Label");
        List<Label> labels = query.getResultList();
        session.close();
        return labels;
    }

    @Override
    public Label save(Label label) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        Long id = (Long) session.save(label);
        session.getTransaction().commit();
        Label persist = session.load(Label.class, id);
        session.close();
        return persist;
    }

    @Override
    public void update(Label label) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        Label persist = session.load(Label.class, label.getId());
        persist.setName(label.getName());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        Label label = new Label();
        label.setId(id);
        session.delete(label);
        session.getTransaction().commit();
        session.close();
    }
}