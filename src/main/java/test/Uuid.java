package test;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class Uuid {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().replace("-", ""));

        String uuid = Generators.timeBasedGenerator().generate().toString().replace("-", "");
        System.out.println(uuid);
    }

}
