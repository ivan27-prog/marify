package org.generation.marify.controllers;

import org.generation.marify.models.Artist;
import org.generation.marify.services.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* 1. Indicar que es un controlador tipo rest (estamos haciendo una api rest)
*  2. Indicar cual va a ser el endpoint para este recurso
*/

@RestController
@RequestMapping(path = "api/artist") // http://localhost:8080/api/artist
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtist(){
        List<Artist> artistsList = artistService.getAllArtist();
        return ResponseEntity.ok(artistsList);
    }

}
