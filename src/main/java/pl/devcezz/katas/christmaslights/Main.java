package pl.devcezz.katas.christmaslights;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("input.txt"));

        String sideOfSquare = lines.get(0);

        RectangleLights lights = new RectangleLights(Integer.parseInt(sideOfSquare));

        lines.stream()
                .skip(1)
                .forEach(line -> {
                    String[] values = line.split("\\|");

                    Instruction instruction = Instruction.of(values[0]);

                    String[] firstPoint = values[1].split(",");
                    String[] secondPoint = values[2].split(",");

                    Point leftBottomCorner = Point.of(
                            Integer.parseInt(firstPoint[0]),
                            Integer.parseInt(firstPoint[1]));
                    Point rightTopCorner = Point.of(
                            Integer.parseInt(secondPoint[0]),
                            Integer.parseInt(secondPoint[1]));

                    switch (instruction) {
                        case I -> lights.turnOn(leftBottomCorner, rightTopCorner);
                        case O -> lights.turnOff(leftBottomCorner, rightTopCorner);
                        case T -> lights.toggle(leftBottomCorner, rightTopCorner);
                    }
                });

        System.out.println("Amount of lit lights is: " + lights.countTurnedOnLights());
    }
}

enum Instruction {

    I, O, T;

    static Instruction of(String instruction) {
        return Arrays.stream(values())
                .filter(value -> value.name().equals(instruction))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown instruction: " + instruction));
    }
}
