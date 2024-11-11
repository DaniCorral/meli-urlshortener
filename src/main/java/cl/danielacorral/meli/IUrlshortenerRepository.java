package cl.danielacorral.meli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IUrlshortenerRepository extends JpaRepository<UrlEntity,Integer> {

    @Query("Select u from UrlEntity u" +
            " where u.shorturl = :shortUrl ")
    UrlEntity findUrlLong(@Param("shortUrl") String shortUrl );

    @Query("Select u from UrlEntity u" +
            " where u.longurl = :LonguUrl ")
    UrlEntity findUrlShort(@Param("LonguUrl") String LonguUrl );

}
