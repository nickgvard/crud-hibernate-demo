package service;

import entity.Label;
import repository.hibernate.LabelRepositoryImpl;

import java.util.List;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

public class LabelService {

    private LabelRepositoryImpl labelRepository;

    public LabelService() {
        labelRepository = new LabelRepositoryImpl();
    }

    public Label getById(long id) {
        return labelRepository.getById(id);
    }

    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    public Label save(Label label) {
        return labelRepository.save(label);
    }

    public void update(Label label) {
        labelRepository.update(label);
    }

    public void deleteById(long id) {
        labelRepository.deleteById(id);
    }
}