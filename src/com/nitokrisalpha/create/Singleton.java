package com.nitokrisalpha.create;

/*
  单例模式
     单例设计，限制内存中只允许创建一个类对象
 */
public class Singleton {
    //未使用单例模式的任务管理器类
    public static class TaskManagerNoSingleton {
        private int count;

        //1.公开的构造方法，用户可以随意使用 new 关键字新建对象
        public TaskManagerNoSingleton() {
            count = 0;
        }

        //get方法记录调用次数
        public int getCount() {

            count++;
            return count;
        }

        @Override
        public String toString() {
            return "TaskManagerNoSingleton{" +
                    "count=" + count +
                    '}';
        }

        public static void test() {
            /*
               可以发现，每次使用这个对象我们都会创建新的对象
               但是现在需求是要记录用户调用次数，如果允许用户随意创建对象，那么会导致记录的混乱
               因此我们需要限制用户的对象的创建行为，保证每次使用时只会有这一个对象
             */
            TaskManagerNoSingleton tm1 = new TaskManagerNoSingleton();
            TaskManagerNoSingleton tm2 = new TaskManagerNoSingleton();
            System.out.println(tm1.getCount());
            System.out.println(tm2);
        }
    }

    //使用了单例模式的任务管理器类
    public static class TaskManagerSingleton {
        private int count;
        //1.类中设计了一个静态的当前类型字段，只要让用户每次获取对象都拿到这个字段即可
        private static TaskManagerSingleton sInstance;

        //2.让类的创建方法设置为私有，禁止用户使用new创建对象
        private TaskManagerSingleton() {
            count = 0;
        }

        //3.对外暴露的静态获取实例方法，让用户能够取得类字段中保存的那个对象
        public static TaskManagerSingleton getInstance() {
            if (sInstance == null) {
                synchronized (TaskManagerSingleton.class) {
                    if (sInstance == null)
                        sInstance = new TaskManagerSingleton();
                }
            }
            return sInstance;
        }

        public int getCount() {
            count++;
            return count;
        }

        @Override
        public String toString() {
            return "TaskManagerSingleton{" +
                    "count=" + count +
                    '}';
        }

        //4.测试用例
        public static void test() {
            TaskManagerSingleton tm1 = TaskManagerSingleton.getInstance();
            TaskManagerSingleton tm2 = TaskManagerSingleton.getInstance();
            System.out.println(tm1.getCount());
            System.out.println(tm2);
        }

    }

    public static void main(String[] args) {
        TaskManagerNoSingleton.test();
        TaskManagerSingleton.test();
    }
}
