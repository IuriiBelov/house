package com.example.house.service.impl;

import com.example.house.dto.BlockDto;
import com.example.house.dto.FlatDto;
import com.example.house.repository.BlockRepository;
import com.example.house.service.BlockService;
import com.example.house.utils.mapping.impl.BlockMapping;
import com.example.house.utils.mapping.impl.FlatMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockServiceImpl implements BlockService {

    private BlockRepository blockRepository;
    private BlockMapping blockMapping;
    private FlatMapping flatMapping;

    public BlockServiceImpl(BlockRepository blockRepository,
                            BlockMapping blockMapping,
                            FlatMapping flatMapping) {
        this.blockRepository = blockRepository;
        this.blockMapping = blockMapping;
        this.flatMapping = flatMapping;
    }

    @Override
    public List<BlockDto> getAllBlocks() {

        List<BlockDto> allBlockDtos = blockRepository
                .findAll()
                .stream()
                .map(blockMapping::mapToDto)
                .collect(Collectors.toList());

        return allBlockDtos;
    }

    @Override
    public BlockDto getBlockById(String id) {
        BlockDto blockDto = blockMapping.mapToDto(
                blockRepository.getOneById(Long.parseLong(id)));
        return blockDto;
    }

    @Override
    public List<FlatDto> getBlockFlatsById(String id) {
        List<FlatDto> blockFlatDtos = blockRepository
                .getOneById(Long.parseLong(id))
                .getFlats()
                .stream()
                .map(flatMapping::mapToDto)
                .collect(Collectors.toList());
        return blockFlatDtos;
    }
}
