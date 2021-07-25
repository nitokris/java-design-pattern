package com.nitokrisalpha.create;

/**
 * 简单工厂模式
 */
public class SimpleFactory {

    public interface Block {
        void say();
    }

    public static class IBlock implements Block {

        @Override
        public void say() {
            System.out.println("IBlock");
        }
    }

    public static class TBlock implements Block {

        @Override
        public void say() {
            System.out.println("TBlock");
        }
    }

    public static class Factory {
        public Block getBlock(String block) {
            if (block.matches("T")) {
                return new TBlock();
            } else if (block.matches("I")) {
                return new IBlock();
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Block t = factory.getBlock("T");
        Block i = factory.getBlock("I");
        t.say();
        i.say();
    }

}
