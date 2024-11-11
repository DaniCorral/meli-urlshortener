package cl.danielacorral.meli.service;

import cl.danielacorral.meli.DTO.UrlDTO;

public interface IUrlshortenerService {
    String createShortURL(String longUrl) throws Exception;
    UrlDTO getLongURL(String shortURL);
    UrlDTO getShortURL(String LongURL);


}
