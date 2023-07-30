package com.apple.iTunesSearch.service;

import com.apple.iTunesSearch.entity.ITune;
import com.apple.iTunesSearch.entity.ITunes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ITuneSearchServiceImpl implements ITuneSearchService {

    @Override
    public ITunes getAllITunesDetails(ITunes iTunes) {
        iTunes.setResultCount(iTunes.getAppleTunes().size());
        return iTunes;
    }

    @Override
    public ITune getITuneDetails(ITunes iTunes, long id) {
        ITune iTune = ITune.builder().build();
        if (iTunes.getAppleTunes() == null) {
        } else {
            iTune = iTunes.getAppleTunes().stream().filter(x -> x.getId() == id).findFirst().get();
        }
        return iTune;
    }

    @Override
    public ITunes addITuneDetails(ITunes iTunes, ITune iTune) {
        if (iTunes.getAppleTunes() == null) {
            List<ITune> list = new ArrayList<>();
            list.add(iTune);
            iTunes.setAppleTunes(list);
            iTunes.setResultCount(iTunes.getAppleTunes().size());
        } else {
            iTunes.getAppleTunes().add(iTune);
            iTunes.setResultCount(iTunes.getAppleTunes().size());
        }
        return iTunes;
    }

    @Override
    public ITunes updateITuneDetails(ITunes iTunes, ITune iTune) {
        return ITunes.builder().appleTunes(
                iTunes.getAppleTunes().stream()
                        .map(y -> {
                            if (y.getId() == iTune.getId()) {
                                y.setId(iTune.getId());
                                y.setUid(iTune.getUid());
                                y.setProductId(iTune.getProductId());
                                y.setProductDes(iTune.getProductDes());
                                y.setProductRef(iTune.getProductRef());
                                y.setProductType(iTune.getProductType());
                                return y;
                            } else {
                                return  y;
                            }
                        }).collect(Collectors.toList())).build();
    }

    @Override
    public ITunes deleteITuneDetails(ITunes iTunes, long id) {
        if (iTunes.getAppleTunes() == null) {
        } else {
            iTunes.getAppleTunes().removeIf(x -> x.getId()==id);
        }
        return iTunes;
    }
}
