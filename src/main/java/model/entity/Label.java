package model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author Nikita Gvardeev
 * 13.11.2021
 */

@Entity()
@Table(name = "label", schema = "public", catalog = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_label",
            joinColumns = @JoinColumn(name = "label_id"),
            inverseJoinColumns = @JoinColumn(name ="post_id"))
    @ToString.Exclude
    private Set<Post> posts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return id == label.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}