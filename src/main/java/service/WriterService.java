package service;

import model.Writer;
import repository.hibernate.HibernateWriterRepositoryImpl;

import java.util.List;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

public class WriterService {

    private HibernateWriterRepositoryImpl writerRepository;

    public WriterService() {
        writerRepository = new HibernateWriterRepositoryImpl();
    }

    public Writer getById(long id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAll() {
        return writerRepository.findAll();
    }

    public Writer save(Writer writer) {
        return writerRepository.save(writer);
    }

    public Writer update(Writer writer) {
        return writerRepository.update(writer);
    }

    public Writer deleteById(Writer writer) {
        return writerRepository.deleteById(writer);
    }
}