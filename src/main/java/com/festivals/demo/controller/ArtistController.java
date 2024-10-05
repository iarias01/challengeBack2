package com.festivals.demo.controller;
import com.festivals.demo.model.Artist;
import com.festivals.demo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Artist> getArtistById(@PathVariable String id) {
        return artistRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable String id, @RequestBody Artist artistDetails) {
        Artist artist = artistRepository.findById(id).orElseThrow();
        artist.setName(artistDetails.getName());
        artist.setMusic(artistDetails.getMusic());
        return artistRepository.save(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable String id) {
        artistRepository.deleteById(id);
    }
}