package com.hyq.day1;

import org.junit.Test;

//懒汉式
public class SingleTonTest {

    private int id;
    private String name;
    private static SingleTonTest s = null;

    private SingleTonTest() {
    }

    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return com.hyq.day1.SingleTonTest
     * @Author huangyq
     * @Description TODO
     * @Date 2021/2/24 16:00
     * @Param []
     * @Version
     **/
    public static SingleTonTest getInstance() {
        if (s == null) {
            s = new SingleTonTest();
        }
        return s;
    }


}

//饿汉式方式一：使用构造器直接默认赋值
class SingleTonTestLazyOne {
    private static SingleTonTestLazyOne s = new SingleTonTestLazyOne();

    private SingleTonTestLazyOne() {
    }

    ;

    /**
     * @return com.hyq.day1.SingleTonTestLazyOne
     * @Author huangyq
     * @Description TODO  返回实例对象
     * @Date 2021/2/24 16:11
     * @Param []
     * @Version 1.0
     **/
    public static SingleTonTestLazyOne getInstance() {
        return s;
    }

}

//饿汉式方法二使用静态代码块
class SingleTonTestLazyTwo {
    private static SingleTonTestLazyTwo s = null;

    private SingleTonTestLazyTwo() {
    }

    ;

    static {
        s = new SingleTonTestLazyTwo();
    }

    public static SingleTonTestLazyTwo getInstance() {
        return s;
    }
}

//懒汉式线程安全实现
class SingleTonTestLazyThree {
    private static SingleTonTestLazyThree s = null;

    private SingleTonTestLazyThree() { }

/**
 *@Author huangyq
 *@Description TODO 实现懒汉式的线程安全
 *@Date 2021/2/24 16:45
 *@Param []
 *@return com.hyq.day1.SingleTonTestLazyThree
 *@Version 1.0
 **/
    public static SingleTonTestLazyThree getInstance() {
        synchronized (SingleTonTestLazyThree.class) {
            if (s == null) {
                s = new SingleTonTestLazyThree();
            }
            return s;
        }
    }
//存在效率低的问题
}

//懒汉式线程安全二
class SingleTonTestLazyTFour {
    //private static SingleTonTestLazyTFour s = null;
    private volatile static SingleTonTestLazyTFour s = null;
    private String str = null;

    private SingleTonTestLazyTFour() { str = "1";}


    public static SingleTonTestLazyTFour getInstance() {
        if (s == null){
            synchronized (SingleTonTestLazyThree.class) {
                if (s == null) {
                    s = new SingleTonTestLazyTFour();
                    //语句为非原子性，实际上会执行以下内容：
                    //(1)在堆上开辟空间；(2)属性初始化;(3)引用指向对象
                    //假设以上三个内容为三条单独指令，因指令重排可能会导致执行顺序为1->3->2(正常为1->2->3),
                    // 当单例模式中存在普通变量需要在构造方法中进行初始化操作时，单线程情况下，
                    // 顺序重排没有影响；但在多线程情况下，
                    // 假如线程1执行s = new SingleTonTestLazyTFour()语句时先1再3，
                    // 由于系统调度线程2的原因没来得及执行步骤2，
                    // 但此时已有引用指向对象也就是s!=null，
                    // 故线程2在第一次检查时不满足条件直接返回s，
                    // 此时s为null(即它的属性值str为null)
                    // volatile关键字可保证s = new SingleTonTestLazyTFour()语句执行顺序为123，
                    // 因其为非原子性依旧可能存在系统调度问题(即执行步骤时被打断)，
                    // 但能确保的是只要s!=0，就表明一定执行了属性初始化操作；
                    // 而若在步骤3之前被打断，此时s依旧为null，
                    // 其他线程可进入第一层检查向下执行创建对象
                }

            }
        }
        return s;
    }
//缺点在于实现复杂
}

