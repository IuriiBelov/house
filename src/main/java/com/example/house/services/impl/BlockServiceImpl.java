package com.example.house.services.impl;

import com.example.house.dtos.BlockDto;
import com.example.house.dtos.FlatDto;
import com.example.house.repositories.BlockRepository;
import com.example.house.services.BlockService;
import com.example.house.utils.MappingUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockServiceImpl implements BlockService {

    private BlockRepository blockRepository;
    private MappingUtils mappingUtils;

    public BlockServiceImpl(BlockRepository blockRepository, MappingUtils mappingUtils) {
        this.blockRepository = blockRepository;
        this.mappingUtils = mappingUtils;
    }

    @Override
    public List<BlockDto> getAllBlocks() {
        List<BlockDto> allBlockDtos = blockRepository
                .findAll()
                .stream()
                .map(mappingUtils::mapToBlockDto)
                .collect(Collectors.toList());
        return allBlockDtos;
    }

    @Override
    public BlockDto getBlockById(String id) {
        BlockDto blockDto = mappingUtils.mapToBlockDto(
                blockRepository.getOneById(Long.parseLong(id)));
        return blockDto;
    }

    @Override
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
