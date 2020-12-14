package io.github.xuanyangyang.learn.jdk.classload;

/**
 * @author xuanyangyang
 * @since 2020/11/21 17:08
 */
public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
