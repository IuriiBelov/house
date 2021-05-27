package com.example.house.services;

import com.example.house.dto.BlockDto;
import com.example.house.dto.FlatDto;
import com.example.house.repositories.BlockRepository;
import com.example.house.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockService {
    private BlockRepository blockRepository;
    private MappingUtils mappingUtils;

    @Autowired
    public BlockService(BlockRepository blockRepository, MappingUtils mappingUtils) {
        this.blockRepository = blockRepository;
        this.mappingUtils = mappingUtils;
    }


    public List<BlockDto> getAllBlocks() {
        List<BlockDto> allBlockDtos = blockRepository
                .findAll()
                .stream()
                .map(mappingUtils::mapToBlockDto)
                .collect(Collectors.toList());
        return allBlockDtos;
    }

    public BlockDto getBlockById(String id) {
        BlockDto blockDto = mappingUtils.mapToBlockDto(
                blockRepository.getOneById(Long.parseLong(id)));
        return blockDto;
    }

    public List<FlatDto> getBlockFlatsById(String id) {
        List<FlatDto> blockFlatDtos = blockRepository
                .getOneById(Long.parseLong(id))
                .getFlats()
                .stream()
                .map(mappingUtils::mapToFlatDto)
                .collect(Collectors.toList());
        return blockFlatDtos;
    }
}
