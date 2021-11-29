package repository.hibernate;

import entity.Label;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.LabelRepository;
import utils.HibernateUtil;

import java.util.List;

/**
 * @author Nikita Gvardeev 24.11.2021
 * email gvardeev@po-korf.ru
 */
public class LabelRepositoryImpl implements LabelRepository {

    @Override
    public Label getById(Long id) {
        try(Session session = HibernateUtil.session()) {
            return session.get(Label.class, id);
        }
    }

    @Override
    public List<Label> findAll() {
        try(Session session = HibernateUtil.session();) {
            Query<Label> query = session.createQuery("FROM Label");
            return query.getResultList();
        }
    }

    @Override
    public Label save(Label label) {
        try(Session session = HibernateUtil.session()) {
            session.beginTransaction();
            Long id = (Long) session.save(label);
            session.getTransaction().commit();
            return session.load(Label.class, id);
        }
    }

    @Override
    public void update(Label label) {
        try(Session session = HibernateUtil.session()){
            session.beginTransaction();
            Label persist = session.load(Label.class, label.getId());
            persist.setName(label.getName());
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = HibernateUtil.session()) {
            session.beginTransaction();
            Label label = new Label();
            label.setId(id);
            session.delete(label);
            session.getTransaction().commit();
        }
    }
}