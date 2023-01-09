package com.example.designpattern;

public class ClassroomSingleton {
    private String mName;

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    private static ClassroomSingleton mInstance;

    private ClassroomSingleton() {
    }

    public static ClassroomSingleton getInstance() {
        if (mInstance == null) {
            mInstance = new ClassroomSingleton();
        }
        return mInstance;
    }
}
