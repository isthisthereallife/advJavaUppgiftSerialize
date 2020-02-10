package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Serializer {

    public static void write(Path path, Object object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read(Path path) {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error reading from path \"" + path + "\"");
            return null;
        }
    }

}
