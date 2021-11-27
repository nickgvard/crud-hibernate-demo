package repository.hibernate;

import javafx.geometry.Pos;
import model.entity.Post;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.PostRepository;
import util.HibernateUtil;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Nikita Gvardeev 24.11.2021
 * email gvardeev@po-korf.ru
 */
public class PostRepositoryImpl implements PostRepository {

    @Override
    public Post getById(Long id) {
        Session session = HibernateUtil.sessionFactory().openSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;
    }

    @Override
    public List<Post> findAll() {
        Session session = HibernateUtil.sessionFactory().openSession();
        Query<Post> query = session.createQuery("FROM Post");
        List<Post> posts = query.getResultList();
        session.close();
        return posts;
    }

    @Override
    public Post save(Post post) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        Long id = (Long) session.save(post);
        session.getTransaction().commit();
        Post persist = session.load(Post.class, id);
        session.close();
        return persist;
    }

    @Override
    public void update(Post post) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        Post persist = session.load(Post.class, post.getId());
        persist.setContent(post.getContent());
        persist.setUpdated(post.getUpdated());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.sessionFactory().openSession();
        session.beginTransaction();
        Post post = new Post();
        post.setId(id);
        session.delete(post);
        session.getTransaction().commit();
        session.close();
    }
}
