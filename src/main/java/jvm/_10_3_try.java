package jvm;

import java.io.*;

public class _10_3_try {

    public static void main(String[] args) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aa"));
             ObjectOutputStream ooa = new ObjectOutputStream(new FileOutputStream("aa"))) {

        }
    }

}
