package model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

@Entity()
@Table(name = "post", schema = "public", catalog = "postgres")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String content;

    @NonNull
    private Timestamp created;

    @NonNull
    private Timestamp updated;

    @ManyToOne
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    @ToString.Exclude
    private Writer writer;

    @ManyToMany(mappedBy = "posts", fetch = FetchType.EAGER)
    private List<Label> labels;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}