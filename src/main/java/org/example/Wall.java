package org.example;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure, CompositeBlock {

    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return getBlocks().stream().filter(block -> {
            return block.getColor().equals(color);
        }).findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return getBlocks().stream().filter(block -> {
            return block.getMaterial().equals(material);
        }).toList();
    }

    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
