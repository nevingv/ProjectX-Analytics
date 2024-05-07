package com.projectx.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TierDetails {

    private String tier;
    private List<String> benefits;
    private boolean active;
    private String id;
}
