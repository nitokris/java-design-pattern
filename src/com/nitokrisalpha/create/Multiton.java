package com.nitokrisalpha.create;

/*
    与单例模式想对应的多例设计模式
    本质和单例模式一样，都是为了限制用户创建类对象的个数
    常见的需要单例模式的场景有容器类
 */
public class Multiton {

    public enum Sex {
        MALE,
        FEMALE
    }

    public static class SexClass {
        private String title;
        private static final SexClass male = new SexClass(Sex.MALE);
        private static final SexClass female = new SexClass(Sex.FEMALE);

        private SexClass(Sex sex) {
            this.title = "你创建的性别是：" + title;
        }

        public static SexClass getSex(Sex sex) {
            switch (sex) {
                case MALE:
                    return male;
                case FEMALE:
                    return female;
                default:
                    return null;
            }
        }

        @Override
        public String toString() {
            return "SexClass{" +
                    "title='" + title + '\'' +
                    '}';
        }

        public static void test() {
            SexClass male = SexClass.getSex(Sex.MALE);
            SexClass female = SexClass.getSex(Sex.FEMALE);
            System.out.println(male);
            System.out.println(female);
        }
    }

    public static void main(String[] args) {
        SexClass.test();
    }

}
