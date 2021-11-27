package service;

import model.entity.Writer;
import repository.hibernate.WriterRepositoryImpl;

import java.util.List;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

public class WriterService {

    private WriterRepositoryImpl writerRepository;

    public WriterService() {
        writerRepository = new WriterRepositoryImpl();
    }

    public Writer getById(long id) {
        return writerRepository.getById(id);
    }

    public List<Writer> findAll() {
        return writerRepository.findAll();
    }

    public Writer save(Writer writer) {
        return writerRepository.save(writer);
    }

    public void update(Writer writer) {
        writerRepository.update(writer);
    }

    public void deleteById(long id) {
        writerRepository.deleteById(id);
    }
}