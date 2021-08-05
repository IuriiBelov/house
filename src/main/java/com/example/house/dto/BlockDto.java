package com.example.house.dto;

import java.util.List;

public class BlockDto {

    private Long id;
    private Integer blockNumber;
    private List<Integer> flatsNumbers;

    public BlockDto() {}

    public BlockDto(Long id, Integer blockNumber, List<Integer> flatsNumbers) {
        this.id = id;
        this.blockNumber = blockNumber;
        this.flatsNumbers = flatsNumbers;
    }

    public Long getId() {
        return id;
    }

    public Integer getBlockNumber() {
        return blockNumber;
    }

    public List<Integer> getFlatsNumbers() {
        return flatsNumbers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setFlatsNumbers(List<Integer> flatsNumbers) {
        this.flatsNumbers = flatsNumbers;
    }
}
