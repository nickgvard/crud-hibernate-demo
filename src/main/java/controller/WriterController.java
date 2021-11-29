package controller;

import entity.Writer;
import service.WriterService;

import java.util.List;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

public class WriterController {

    private final WriterService writerService;

    public WriterController() {
        writerService = new WriterService();
    }

    public Writer getById(long id) {
        return writerService.getById(id);
    }

    public List<Writer> findAll() {
        return writerService.findAll();
    }

    public Writer save(Writer entity) {
        return writerService.save(entity);
    }

    public void update(Writer entity) {
        writerService.update(entity);
    }

    public void deleteById(long id) {
        writerService.deleteById(id);
    }
}