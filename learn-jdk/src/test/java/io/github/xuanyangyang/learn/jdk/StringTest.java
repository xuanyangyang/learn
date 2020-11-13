package io.github.xuanyangyang.learn.jdk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * String 测试
 *
 * @author xuanyangyang
 * @since 2020/11/13 22:00
 */
public class StringTest {
    @Test
    public void test1String() {
        String s1 = "1";
        String s2 = "1";
        Assertions.assertSame(s1, s2);
    }

    @Test
    public void test2String() {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        // 不是同一个对象的原因是"1"已经出现过，s1.intern只会放入第一个不存在的
        Assertions.assertSame(s1, s2);
    }

    @Test
    public void test3String() {
        String s1 = new String("1");
        s1 = s1.intern();
        String s2 = "1";
        Assertions.assertSame(s1, s2);
    }

    @Test
    public void test5String() {
        String s1 = new String("禤阳洋") + new String("主线程");
        s1.intern();
        String s2 = "禤阳洋主线程";
        Assertions.assertSame(s1, s2);
    }

    @Test
    public void test6String() {
        String s1 = new String("xuan") + new String("yang") + new String("yang");
        Assertions.assertSame(s1.intern(), s1);
    }
}
