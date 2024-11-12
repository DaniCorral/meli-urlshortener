package cl.danielacorral.meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlDTO {
    private Integer id;
    private String longUrl;
    private String shortUrl;
}
