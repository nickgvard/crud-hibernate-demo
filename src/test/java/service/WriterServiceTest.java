package service;

import entity.Writer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import repository.hibernate.WriterRepositoryImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Nikita Gvardeev
 * 27.11.2021
 */
@RunWith(MockitoJUnitRunner.class)
public class WriterServiceTest {

    @InjectMocks
    private WriterService writerService;

    @Mock
    private WriterRepositoryImpl mockWriterRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getById() {
        Writer expected = writer();
        when(mockWriterRepository.getById(anyLong())).thenReturn(expected);

        Writer actual = writerService.getById(anyLong());

        verify(mockWriterRepository, times(1)).getById(any());
        assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        List<Writer> expected = Arrays.asList(writer(), writer());
        when(mockWriterRepository.findAll()).thenReturn(expected);

        List<Writer> actual = writerService.findAll();

        verify(mockWriterRepository, times(1)).findAll();
        assertEquals(expected, actual);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void save() {
        Writer expected = writer();
        when(mockWriterRepository.save(any())).thenReturn(expected);

        Writer actual = writerService.save(any());

        verify(mockWriterRepository, times(1)).save(any());
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        doNothing().when(mockWriterRepository).update(any());

        mockWriterRepository.update(any());

        verify(mockWriterRepository).update(any());
    }

    @Test
    public void deleteById() {
        doNothing().when(mockWriterRepository).deleteById(anyLong());

        mockWriterRepository.deleteById(anyLong());

        verify(mockWriterRepository).deleteById(any());
    }

    private Writer writer() {
        Writer writer = new Writer();
        writer.setId(1L);
        writer.setFirstName("firstname1");
        writer.setLastName("lastname1");
        return writer;
    }
}