package io.github.xuanyangyang.learn.jdk.classload;

/**
 * @author xuanyangyang
 * @since 2020/11/21 16:42
 */
public class ClassLoadDemo {
    public static void main(String[] args) {
        // 被动使用类字段演示一： 通过子类引用父类的静态字段，不会导致子类初始化
        System.out.println(Son.value);

        // 被动使用类字段演示二： 通过数组定义来引用类，不会触发此类的初始化
        Son[] sons = new Son[10];

        // 被动使用类字段演示三： 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的 类的初始化
        System.out.println(ConstantClass.value);
    }
}
