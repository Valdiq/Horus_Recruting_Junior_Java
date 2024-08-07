package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findBlockByColorRecursive(blocks, color);
    }

    private Optional<Block> findBlockByColorRecursive(List<Block> blocks, String color) {
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
            if (block instanceof CompositeBlock) {
                Optional<Block> result = findBlockByColorRecursive(((CompositeBlock) block).getBlocks(), color);
                if (result.isPresent()) {
                    return result;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> result = new ArrayList<>();
        findBlocksByMaterialRecursive(blocks, material, result);
        return result;
    }

    private void findBlocksByMaterialRecursive(List<Block> blocks, String material, List<Block> result) {
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                result.add(block);
            }
            if (block instanceof CompositeBlock) {
                findBlocksByMaterialRecursive(((CompositeBlock) block).getBlocks(), material, result);
            }
        }
    }

    @Override
    public int count() {
        return countRecursive(blocks);
    }

    private int countRecursive(List<Block> blocks) {
        int count = 0;
        for (Block block : blocks) {
            count++;
            if (block instanceof CompositeBlock) {
                count += countRecursive(((CompositeBlock) block).getBlocks());
            }
        }
        return count;
    }
}
