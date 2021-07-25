package com.nitokrisalpha.create;

/**
 * 简单工厂模式有个弊端，当新增了实现类时
 * 需要修改工厂的getBlck()中的代码,违反开闭原则
 */
public class Factory {
    public interface BlockFactory {
        Block getBlock();
    }

    public interface Block {
        void say();
    }

    public static class IBlock implements Block {

        @Override
        public void say() {
            System.out.println("Iblock ......");
        }
    }

    public static class TBlock implements Block {

        @Override
        public void say() {
            System.out.println("TBlock.......");
        }
    }

    public static class IBlockFactory implements BlockFactory {

        @Override
        public Block getBlock() {
            return new IBlock();
        }
    }

    public static class TBlockFactory implements BlockFactory {

        @Override
        public Block getBlock() {
            return new TBlock();
        }
    }

    public static void main(String[] args) {
        BlockFactory factory = new IBlockFactory();
        Block block = factory.getBlock();
        block.say();
        factory = new TBlockFactory();
        Block tblock = factory.getBlock();
        tblock.say();
    }
}
