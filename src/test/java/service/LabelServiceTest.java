package service;

import model.entity.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import repository.hibernate.LabelRepositoryImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author Nikita Gvardeev
 * 27.11.2021
 */
@RunWith(MockitoJUnitRunner.class)
public class LabelServiceTest {

    @Mock
    private LabelRepositoryImpl mockLabelRepository;

    @InjectMocks
    private LabelService labelService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenGetLabelById() {
        Label expected = label();
        when(mockLabelRepository.getById(anyLong())).thenReturn(expected);

        Label actual = labelService.getById(anyLong());

        verify(mockLabelRepository, times(1)).getById(any());
        assertEquals(expected, actual);
    }

    @Test
    public void whenFindAllLabels() {
        List<Label> expected = Arrays.asList(label(), label());
        when(mockLabelRepository.findAll()).thenReturn(expected);

        List<Label> actual = labelService.findAll();

        verify(mockLabelRepository, times(1)).findAll();
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void whenSaveLabel() {
        Label expected = label();

        when(mockLabelRepository.save(any())).thenReturn(expected);

        Label actual = labelService.save(any());

        verify(mockLabelRepository, times(1)).save(any());
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        doNothing().when(mockLabelRepository).update(any());

        mockLabelRepository.update(any());

        verify(mockLabelRepository, times(1)).update(any());
    }

    @Test
    public void deleteById() {
        doNothing().when(mockLabelRepository).deleteById(anyLong());

        mockLabelRepository.deleteById(anyLong());

        verify(mockLabelRepository, times(1)).deleteById(anyLong());
    }

    private Label label() {
        Label label = new Label();
        label.setId(1L);
        label.setName("label1");
        return label;
    }
}