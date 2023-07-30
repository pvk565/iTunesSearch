package com.apple.iTunesSearch.entity;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ITunes {
    private int resultCount;
    private List<ITune> appleTunes;
}
