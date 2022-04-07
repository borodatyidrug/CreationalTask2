package http.creationaltask2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CreationalTask2 {
    
    public static List<Integer> intListGenerator(int length, int bound) {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            list.add(r.nextInt(bound));
        }
        return list;
    }

    public static void main(String[] args) {
        
        Logger logger = Logger.getInstance();
        Scanner sc = new Scanner(System.in);
        logger.log("Запускаем программу");
        int length, treshold, bound;
        String line;
        
        while (true) {
            logger.log("Введите размер списка (N > 0):");
            line = sc.nextLine().trim();
            logger.log("Введенное вами значение - \"" + line + "\"");
            if (line == null || line.isBlank()) {
                logger.log("Вы ввели ничего");
            } else {
                try {
                    length = Integer.parseInt(line);
                    if (length <= 0) {
                        logger.log("Ну какой смысл в отрицательном или нулевом размере списка? О_о");
                    } else {
                        logger.log("Вами установлен след. размер списка: " + length);
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    logger.log("Введенное вами значение не является целым числом");
                }
            }
        }
        
        while (true) {
            logger.log("Введите верхнюю границу значений чисел:");
            line = sc.nextLine().trim();
            logger.log("Введенное вами значение - \"" + line + "\"");
            if (line == null || line.isBlank()) {
                logger.log("Вы ввели ничего");
            } else {
                try {
                    bound = Integer.parseInt(line);
                    if (bound > 0) {
                        logger.log("Вами установлен след. верхняя граница: " + bound);
                        break;
                    } else {
                        logger.log("Верхняя граница должна быть > 0!");
                    }
                } catch (IllegalArgumentException e) {
                    logger.log("Введенное вами значение не является целым числом");
                }
            }
        }
        
        while (true) {
            logger.log("Введите порог фильтрации (0 < t < N):");
            line = sc.nextLine().trim();
            logger.log("Введенное вами значение - \"" + line + "\"");
            if (line == null || line.isBlank()) {
                logger.log("Вы ввели ничего");
            } else {
                try {
                    treshold = Integer.parseInt(line);
                    if (treshold > 0 && treshold < bound) {
                        logger.log("Вами установлен след. порог фильтрации: " + treshold);
                        break;
                    } else {
                        logger.log("Ну какой смысл отфильтровывать все или не отфильтровывать ничего? О_о");
                    }
                } catch (IllegalArgumentException e) {
                    logger.log("Введенное вами значение не является целым числом");
                }
            }
        }
        
        logger.log("Начинаем генерацию списка чисел согласно заданным ограничениям...");
        List<Integer> source = intListGenerator(length, bound);
        logger.log("Список ваших чисел:");
        logger.log(source.toString());
        Filter filter = new Filter(treshold);
        List<Integer> out = filter.filter(source);
        logger.log("Результирующий список чисел:");
        logger.log(out.toString());
        logger.log("До свидания!");
    }
}
