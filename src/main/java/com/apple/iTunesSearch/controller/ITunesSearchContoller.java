package com.apple.iTunesSearch.controller;


import com.apple.iTunesSearch.entity.ITune;
import com.apple.iTunesSearch.entity.ITunes;
import com.apple.iTunesSearch.service.ITuneSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI")
public class ITunesSearchContoller {
    @Autowired
    private ITuneSearchService iTuneSearchService;

    private static ITunes iTunes = new ITunes();

    @GetMapping("/all")
    public ResponseEntity<ITunes> getAllDetails(@RequestParam(required = false, value = "term") String term,
                                                @RequestParam(required = false, value = "limit") Integer limit) {
        if(term!=null && limit >= 0){
            this.iTunes = iTuneSearchService.getAllITunesDetails(iTunes);
            return ResponseEntity.ok().body(ITunes.builder()
                    .appleTunes(this.iTunes.getAppleTunes().stream()
                            .filter(x -> x.getProductType().equals(term))
                            .limit(limit).collect(Collectors.toList()))
                    .resultCount(this.iTunes.getAppleTunes().size())
                    .build());
        }else if(term==null || limit==null){
            this.iTunes = iTuneSearchService.getAllITunesDetails(iTunes);
        } else {
            this.iTunes = iTuneSearchService.getAllITunesDetails(iTunes);
        }
        return ResponseEntity.ok().body(this.iTunes);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ITune> getAllTuneDetails(@PathVariable long id) {
        return ResponseEntity.ok().body(iTuneSearchService.getITuneDetails(iTunes, id));
    }

    @PostMapping("/apple_ref/doc/uid")
    public ResponseEntity<ITunes> addTunesDetails(@RequestBody ITune iTune) {
        this.iTunes = iTuneSearchService.addITuneDetails(iTunes, iTune);
        return ResponseEntity.ok().body(this.iTunes);
    }

    @PutMapping("/apple_ref/doc/uid/{id}")
    public ResponseEntity<ITunes> updateTunesDetails(@RequestBody ITune iTune) {
        this.iTunes = iTuneSearchService.updateITuneDetails(iTunes, iTune);
        return ResponseEntity.ok().body(this.iTunes);
    }

    @DeleteMapping("/apple_ref/doc/uid/{id}")
    public ResponseEntity<ITunes> deleteTunesDetails(@PathVariable long id) {
        this.iTunes = iTuneSearchService.deleteITuneDetails(iTunes, id);
        return ResponseEntity.ok().body(this.iTunes);
    }
}

