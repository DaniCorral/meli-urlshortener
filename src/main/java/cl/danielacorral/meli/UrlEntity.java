package cl.danielacorral.meli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "urls",
        schema = "public"
)
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idUrl;

    @Column(name="longurl")
    private String longurl;

    @Column(name="shorturl")
    private String shorturl;


}
