package io.github.xuanyangyang.learn.jdk;

/**
 * @author xuanyangyang
 * @since 2020/11/13 23:05
 */
public class TryWithResourceDemo {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyResource implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("close");
        }
    }
}
