package process;

import utils.HibernateUtil;

/**
 * @author Nikita Gvardeev
 * 27.11.2021
 */
public class App {

    static {
        try {
            Class.forName(HibernateUtil.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //        Label label = new Label();
//        label.setName("label3_1");

//        Post post = new Post();
//        post.setId(9L);
//        post.setContent("content2_1");
//        post.setCreated(Timestamp.valueOf("2021-11-27 17:41:00.612000"));
//        post.setUpdated(new Timestamp(System.currentTimeMillis()));
////        post.addLabel(label);
//
//        PostRepositoryImpl repo = new PostRepositoryImpl();
//        repo.update(post);

//        Label label = new Label();
//        label.setName("label2");
//        LabelRepositoryImpl repo = new LabelRepositoryImpl();
//        repo.save(label);
//
//        Label label = new Label();
//        label.setName("label2");
//
//        Post post = new Post();
//        post.setContent("content2");
//        post.setCreated(new Timestamp(System.currentTimeMillis()));
//        post.addLabel(label);
//
//        Writer writer = new Writer();
//        writer.setFirstName("firstname2");
//        writer.setLastName("lastname2");
//        writer.addPost(post);
//
//        WriterRepositoryImpl repo = new WriterRepositoryImpl();
//        repo.save(writer);

        /*
        Label label = new Label();
        label.setId(20L);
        label.setName("label2_1");

        LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();
        labelRepository.update(label);

        Post post = new Post();
        post.setId(28L);
        post.setContent("content2_1");
        post.setUpdated(new Timestamp(System.currentTimeMillis()));

        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        postRepository.update(post);

        Writer writer = new Writer();
        writer.setId(23L);
        writer.setFirstName("firstname2_1");
        writer.setLastName("lastname2_1");

        WriterRepositoryImpl repo = new WriterRepositoryImpl();
        repo.update(writer);
         */
    }
}