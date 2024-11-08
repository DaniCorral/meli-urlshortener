package cl.danielacorral.meli.controller;

import cl.danielacorral.meli.service.IUrlshortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlshortenerControler {

    @Autowired
    IUrlshortenerService urlshortenerService;

    @PostMapping("/url/")
    public String urlCorta(@RequestParam String urlCompleta){
        return urlshortenerService.processURL(urlCompleta);
    }
}
