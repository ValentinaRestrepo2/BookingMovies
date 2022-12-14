package co.com.poli.movieservice.persistence.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,unique = true,nullable = false)
    private Long id;
    @NotEmpty(message = "El titulo no puede estar en blanco")
    @Column(name="title")
    private String title;
    @NotEmpty(message = "El director no puede estar en blanco")
    @Column(name="director")
    private String director;
    @Min(1)
    @Max(5)
    @Column(name="rating")
    private int rating;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "category_id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //private Category category;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getId().equals(movie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
