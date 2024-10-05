package com.festivals.demo.controller;

import com.festivals.demo.model.Festival;
import com.festivals.demo.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/festivals")
public class FestivalController {

    @Autowired
    private FestivalRepository festivalRepository;

    @PostMapping
    public Festival createFestival(@RequestBody Festival festival) {
        return festivalRepository.save(festival);
    }

    @GetMapping
    public List<Festival> getAllFestivals() {
        return festivalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Festival> getFestivalById(@PathVariable String id) {
        return festivalRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Festival updateFestival(@PathVariable String id, @RequestBody Festival festivalDetails) {
        Festival festival = festivalRepository.findById(id).orElseThrow();
        festival.setArtists(festivalDetails.getArtists());
        festival.setDate(festivalDetails.getDate());
        festival.setTime(festivalDetails.getTime());
        festival.setCity(festivalDetails.getCity());
        festival.setDescription(festivalDetails.getDescription());
        return festivalRepository.save(festival);
    }

    @DeleteMapping("/{id}")
    public void deleteFestival(@PathVariable String id) {
        festivalRepository.deleteById(id);
    }
}
