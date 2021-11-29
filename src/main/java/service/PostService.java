package service;

import entity.Post;
import repository.hibernate.PostRepositoryImpl;

import java.util.List;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

public class PostService {

    private PostRepositoryImpl postRepository;

    public PostService() {
        postRepository = new PostRepositoryImpl();
    }

    public Post getById(long id) {
        return postRepository.getById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void update(Post post) {
        postRepository.update(post);
    }

    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}