package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        final int MAX_FLOORS = 25;
        int input = -1, previousFloor = 0;

        Deque<Integer> floors = new ArrayDeque<>();
        floors.add(previousFloor);
        System.out.printf("Текущее положение лифта: %d этаж\n", floors.getFirst());

        while (input != 0) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            input = Integer.parseInt(scanner.nextLine());

            if (input > MAX_FLOORS || input < 0) {
                System.out.println("Такого этажа нет!");
                continue;
            }

            if (floors.getLast().equals(input)) {
                System.out.println("Вы находитесь на этажe: " + floors.getLast());
                continue;
            }
            floors.add(input);
        }
        if (input == 0) {
            System.out.println("Лифт проследовал по следующим этажам:");
            while (!floors.isEmpty()) {
                int currentFloor = floors.poll();
                System.out.print("  этаж " + currentFloor);
                if (floors.size() > 0) {
                    System.out.print(" ->");
                }
            }
        }
    }
}


