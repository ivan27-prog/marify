package org.generation.marify.services;

import org.generation.marify.dtos.ArtistRequest;
import org.generation.marify.exceptions.ResourceNotFoundException;
import org.generation.marify.models.Artist;
import org.generation.marify.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//?Sirve para procesar la lógica
@Service
public class ArtistService {
    /*
    * Inyección de dependencias
    * Inyección en atributo
    * Inyección en constructor
    * Inyección por método
    * */
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtist(){
        return artistRepository.findAll();
    }

    public Artist getArtistById(Long id){
        return artistRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Artista con el id " + id + " no encontrado")
        );
    }

    public Artist createArtist(ArtistRequest newArtist){
        Artist artist = new Artist();
        artist.setName(newArtist.name());
        artist.setGenere(newArtist.genere());
        artist.setOriginCountry(newArtist.country());
        return artistRepository.save(artist);
    }

    public Artist updateArtist(Long id, ArtistRequest updateArtist){
        Artist oldArtist = artistRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Artista con el id " + id + " no encontrado")
        );
        if(updateArtist.name() != null) oldArtist.setName(updateArtist.name());
        if(updateArtist.genere() != null) oldArtist.setGenere(updateArtist.genere());
        if(updateArtist.country() != null) oldArtist.setOriginCountry((updateArtist.country()));
        return artistRepository.save(oldArtist);
    }

    public Artist deleteArtistBiId(Long id){
        Artist artist = artistRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Artista con el id " + id + " no encontrado")
        );
        artistRepository.delete(artist);
        return artist;
    }

}
