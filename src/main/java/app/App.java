package app;

import utils.HibernateUtil;
import repository.hibernate.WriterRepositoryImpl;

/**
 * @author Nikita Gvardeev 29.11.2021
 * email gvardeev@po-korf.ru
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

//        Writer writer = new Writer();
//        writer.setFirstName("Nikita");
//        writer.setLastName("Gvardeev");
//
//        Label label = new Label();
//        label.setName("label1");
//
//        Post post = new Post();
//        post.setContent("content1");
//        post.setCreated(new Timestamp(System.currentTimeMillis()));
//        post.addLabel(label);
//        writer.addPost(post);
//
//        post = new Post();
//        post.setContent("content2");
//        post.setCreated(new Timestamp(System.currentTimeMillis()));
//        post.addLabel(label);
//        writer.addPost(post);
//
//        WriterRepositoryImpl writerRepository = new WriterRepositoryImpl();
//        writerRepository.save(writer);

        WriterRepositoryImpl writerRepository = new WriterRepositoryImpl();
        System.out.println(writerRepository.getById(4L));


    }
}
