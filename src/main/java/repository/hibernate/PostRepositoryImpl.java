package repository.hibernate;

import entity.Post;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.PostRepository;
import utils.HibernateUtil;

import java.util.List;

/**
 * @author Nikita Gvardeev 24.11.2021
 * email gvardeev@po-korf.ru
 */
public class PostRepositoryImpl implements PostRepository {

    @Override
    public Post getById(Long id) {
        try(Session session = HibernateUtil.session()){
            return session.get(Post.class, id);
        }
    }

    @Override
    public List<Post> findAll() {
        try(Session session = HibernateUtil.session()) {
            Query<Post> query = session.createQuery("FROM Post");
            return query.getResultList();
        }
    }

    @Override
    public Post save(Post post) {
        try(Session session = HibernateUtil.session()) {
            session.beginTransaction();
            Long id = (Long) session.save(post);
            session.getTransaction().commit();
            return session.load(Post.class, id);
        }
    }

    @Override
    public void update(Post post) {
        try(Session session = HibernateUtil.session()) {
            session.beginTransaction();
            Post persist = session.load(Post.class, post.getId());
            persist.setContent(post.getContent());
            persist.setUpdated(post.getUpdated());
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = HibernateUtil.session();) {
            session.beginTransaction();
            Post post = new Post();
            post.setId(id);
            session.delete(post);
            session.getTransaction().commit();
        }
    }
}