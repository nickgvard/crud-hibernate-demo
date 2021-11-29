package entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

@Entity()
@Table(name = "post", schema = "public", catalog = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    private Timestamp created;

    private Timestamp updated;

    @ManyToOne
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    @ToString.Exclude
    private Writer writer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "post_label",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Label> labels = new ArrayList<>();

    public void addLabel(Label label) {
        labels.add(label);
    }

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