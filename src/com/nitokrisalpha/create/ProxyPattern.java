package com.nitokrisalpha.create;

//代理模式
public class ProxyPattern {
    static abstract class Subject {
        abstract public void sell();
    }

    static class RealSubject extends Subject {
        @Override
        public void sell() {
            System.out.println("酒厂买酒");
        }
    }

    static class ProxySubject extends Subject {
        private Subject subject;

        @Override
        public void sell() {
            before();
            //看起来和装饰器模式很像，但是区别是装饰器模式需要从外界获取对象
            if (subject == null) {
                subject = new RealSubject();
            }
            subject.sell();
            after();
        }

        public void before() {
            System.out.println("买酒之前");
        }

        public void after() {
            System.out.println("买酒之后");
        }
    }
}
