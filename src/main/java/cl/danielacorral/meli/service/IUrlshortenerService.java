package cl.danielacorral.meli.domain.service;

import cl.danielacorral.meli.domain.dto.UrlDTO;

public interface IUrlshortenerService {
    String createShortURL(String longUrl) throws Exception;
    UrlDTO getLongURL(String shortURL) throws Exception;
    UrlDTO getShortURL(String LongURL);


}
