package com.example.demo.pattern.singleton;

public class SyncSingleton {

    private SyncSingleton() {
    }

    private static volatile SyncSingleton syncSingleton;
    private static Object object = new Object();

    public static SyncSingleton getInstance() {

        if (syncSingleton == null) {
            synchronized (object) {
                if (syncSingleton == null) {
                    syncSingleton = new SyncSingleton();
                }
            }
        }
        return syncSingleton;
    }
}
