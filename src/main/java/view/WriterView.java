package view;

import controller.WriterController;
import entity.Writer;

import java.util.List;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

public class WriterView {

    private final WriterController writerController;

    public WriterView() {
        writerController = new WriterController();
    }

    public void showWriterById(long id) {
        Writer writer = writerController.getById(id);
        if(writer != null) {
            System.out.println(writer);
        }else
            System.out.println("Not found writer by this id");
    }

    public void showAllWriters() {
        List<Writer> writers = writerController.findAll();
        if(!writers.isEmpty()) {
            for (Writer writer : writers) {
                System.out.println(writer);
            }
        }else
            System.out.println("Writers is empty");
    }

    public void saveWriter(Writer writer) {
        writerController.save(writer);
        System.out.println("Writer save successful");
    }

    public void updateWriter(Writer writer) {
        writerController.update(writer);
        System.out.println("Writer updated successful");
    }

    public void deleteWriter(long id) {
        writerController.deleteById(id);
        System.out.println("Writer deleted successful");
    }
}
