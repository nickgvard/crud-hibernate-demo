package model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */
@Entity()
@Table(name = "writer", schema = "public", catalog = "postgres")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Post> posts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return id == writer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}