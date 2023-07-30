package com.apple.iTunesSearch.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class ITune {
    private long id;
    private String uid;
    private String productId;
    private String productDes;
    private String productType;
    private String productRef;
}
