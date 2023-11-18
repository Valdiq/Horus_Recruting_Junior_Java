package org.example;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return Optional.ofNullable(blocks
                .stream()
                .findAny()
                .filter(block -> block.getColor().equals(color))
                .orElseThrow(() -> new RuntimeException("Can not find Block")));
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .findAny()
                .filter(block -> block.getMaterial().equals(material))
                .stream()
                .toList();
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
