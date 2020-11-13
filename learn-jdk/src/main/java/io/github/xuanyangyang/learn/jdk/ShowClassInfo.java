package io.github.xuanyangyang.learn.jdk;

/**
 * 显示class信息
 *
 * @author xuanyangyang
 * @since 2020/11/13 22:47
 */
public class ShowClassInfo {
    public static void main(String[] args) {
        System.out.println(Integer.class.getName());
        System.out.println(Integer.class.getSimpleName());

        System.out.println(int.class.getName());
        System.out.println(int.class.getSimpleName());
    }
}
