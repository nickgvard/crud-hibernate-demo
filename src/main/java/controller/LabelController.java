package controller;

import entity.Label;
import service.LabelService;

import java.util.List;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

public class LabelController {

    private final LabelService labelService;

    public LabelController() {
        labelService = new LabelService();
    }

    public Label getById(long id) {
        return labelService.getById(id);
    }

    public List<Label> findAll() {
        return labelService.findAll();
    }

    public Label save(Label label) {
        return labelService.save(label);
    }

    public void update(Label label) {
        labelService.update(label);
    }

    public void deleteById(long id) {
        labelService.deleteById(id);
    }
}