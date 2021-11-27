package service;

import model.entity.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import repository.hibernate.PostRepositoryImpl;

import java.sql.Timestamp;
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
public class PostServiceTest {

    @Mock
    private PostRepositoryImpl mockPostRepository;

    @InjectMocks
    private PostService postService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getById() {
        Post expected = post();
        when(mockPostRepository.getById(anyLong())).thenReturn(expected);

        Post actual = postService.getById(anyLong());

        verify(mockPostRepository, times(1)).getById(any());
        assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        List<Post> expected = Arrays.asList(post(), post());
        when(mockPostRepository.findAll()).thenReturn(expected);

        List<Post> actual = postService.findAll();

        verify(mockPostRepository, times(1)).findAll();
        assertEquals(expected, actual);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void save() {
        Post expected = post();
        when(mockPostRepository.save(any())).thenReturn(expected);

        Post actual = postService.save(any());

        verify(mockPostRepository, times(1)).save(any());
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        doNothing().when(mockPostRepository).update(any());

        mockPostRepository.update(any());

        verify(mockPostRepository, times(1)).update(any());
    }

    @Test
    public void deleteById() {
        doNothing().when(mockPostRepository).deleteById(anyLong());

        mockPostRepository.deleteById(anyLong());

        verify(mockPostRepository, times(1)).deleteById(any());
    }

    private Post post() {
        Post post = new Post();
        post.setId(1L);
        post.setContent("content1");
        post.setCreated(new Timestamp(100000000L));
        post.setUpdated(new Timestamp(200000000L));
        return post;
    }
}