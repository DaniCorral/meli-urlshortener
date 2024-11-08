package cl.danielacorral.meli.service;

import org.springframework.stereotype.Service;

@Service
public class UrlshortenerService implements IUrlshortenerService {

    public String processURL(String url){
        return "url pequeña de " + url;
    }

}
