package controller;

import entity.Post;
import service.PostService;

import java.util.List;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

public class PostController {

    private final PostService postService;

    public PostController() {
        postService = new PostService();
    }

    public Post getById(long id) {
        return postService.getById(id);
    }

    public List<Post> findAll() {
        return postService.findAll();
    }

    public Post save(Post entity) {
        return postService.save(entity);
    }

    public void update(Post entity) {
        postService.update(entity);
    }

    public void deleteById(long id) {
        postService.deleteById(id);
    }

}
