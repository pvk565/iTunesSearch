package com.apple.iTunesSearch.service;

import com.apple.iTunesSearch.entity.ITune;
import com.apple.iTunesSearch.entity.ITunes;

public interface ITuneSearchService {
     ITunes getAllITunesDetails(ITunes iTunes);
     ITune getITuneDetails(ITunes iTunes, long id);
     ITunes addITuneDetails(ITunes iTunes, ITune iTune);
     ITunes updateITuneDetails(ITunes iTunes, ITune iTune);
     ITunes deleteITuneDetails(ITunes iTunes, long id);
}
