package com.example.house.service.impl;

import com.example.house.dto.BlockDto;
import com.example.house.dto.FlatDto;
import com.example.house.entity.BlockEntity;
import com.example.house.repository.BlockRepository;
import com.example.house.service.BlockService;
import com.example.house.utils.mapping.BlockMapping;
import com.example.house.utils.mapping.FlatMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;
    private final BlockMapping blockMapping;
    private final FlatMapping flatMapping;

    public BlockServiceImpl(BlockRepository blockRepository,
                            BlockMapping blockMapping,
                            FlatMapping flatMapping) {
        this.blockRepository = blockRepository;
        this.blockMapping = blockMapping;
        this.flatMapping = flatMapping;
    }

    @Override
    public List<BlockDto> getAllBlocks(int page, int size) {
        return blockRepository
                .findAll(PageRequest.of(page - 1, size, Sort.by("id")))
                .stream()
                .map(blockMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BlockDto getBlockById(Long id) {
        BlockEntity block = blockRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return blockMapping.mapToDto(block);
    }

    @Override
    public List<FlatDto> getBlockFlatsById(Long id) {
        return blockRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new)
                .getFlatEntities()
                .stream()
                .map(flatMapping::mapToDto)
                .collect(Collectors.toList());
    }
}
