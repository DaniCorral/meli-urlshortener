package cl.danielacorral.meli.controller;

import cl.danielacorral.meli.service.IUrlshortenerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlshortenerControler {

    @Autowired
    IUrlshortenerService urlshortenerService;

    @Operation(summary = "Crear url más corta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "url creada con exito"),
            @ApiResponse(responseCode = "400", description = "error de response"),
            @ApiResponse(responseCode = "500", description = "error en los parametros")

    })
    @PostMapping("/url/")
    public String createURL(
            @RequestBody String longURL
            ){
        return urlshortenerService.createShortURL(longURL);
    }


    @Operation(summary = "Obtener url más corta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "url obtenida con exito"),
            @ApiResponse(responseCode = "400", description = "error de response"),
            @ApiResponse(responseCode = "500", description = "error en los parametros")

    })    @GetMapping("/url/")
    public String getShortURL(
            @RequestParam String shortURL
            ){
        return urlshortenerService.createShortURL(shortURL);
    }
}
