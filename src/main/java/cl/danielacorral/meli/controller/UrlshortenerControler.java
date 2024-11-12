package cl.danielacorral.meli.controller;

import cl.danielacorral.meli.DTO.UrlDTO;
import cl.danielacorral.meli.service.IUrlshortenerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlshortenerControler {

    @Autowired
    IUrlshortenerService urlshortenerService;

    @Operation(summary = "Crear url más corta")
    @PostMapping("/url/")
    public ResponseEntity<String> createURL(
            @RequestBody String longURL){
        try {
            String shortURL = urlshortenerService.createShortURL(longURL);
            return ResponseEntity.status(HttpStatus.CREATED).body(shortURL);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la URL: " + e.getMessage());
        }
    }


    @Operation(summary = "Obtener url más corta")
    @GetMapping("/url/")
    public UrlDTO getShortURL(
            @RequestParam String shortURL
            ){
        return urlshortenerService.getLongURL(shortURL);
    }
}
