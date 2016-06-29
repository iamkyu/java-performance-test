package com.test;

import org.junit.Test;

import java.io.File;

/**
 * Created by kjnam on 2016. 6. 29..
 */
public class FileTest {

    @Test
    public void fileIoTest() {
        FileTest fileTest= new FileTest();
        String path = "/Users/kjnam";
        fileTest.checkPath(path);
    }

    public void checkPath(String path) {
        File file = new File(path);
        System.out.println(path + " is exists? " + file.exists());
        System.out.println(path + " can read? " + file.canRead());
        System.out.println(path + " can write? " + file.canWrite());
        System.out.println(path + " can execute? " + file.canExecute());

    }
}
