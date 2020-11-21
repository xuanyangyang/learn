package io.github.xuanyangyang.learn.jdk.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author xuanyangyang
 * @since 2020/11/21 14:11
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        Object obj = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> objectWeakReference = new WeakReference<>(obj, referenceQueue);
        System.out.println(referenceQueue);
        System.out.println(obj);
        System.out.println(objectWeakReference.get());
        obj = null;
        System.gc();
        try {
            Reference<?> reference = referenceQueue.remove();
            System.out.println(objectWeakReference == reference);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
