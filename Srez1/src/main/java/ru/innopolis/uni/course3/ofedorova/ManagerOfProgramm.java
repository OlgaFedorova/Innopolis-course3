package ru.innopolis.uni.course3.ofedorova;

/**
 * Класс, управляющий работой потоков в программе.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 12.12.2016
 */
public class ManagerOfProgramm {

    /**
     * Метод, стартующий работу потоков.
     */
    public void start() {
        final StorageForNumber storage = new StorageForNumber();
        Thread threadGenerater = new Thread(new GeneratorNumber(storage));
        Thread threadChecker = new Thread(new CheckerNumber(storage));
        threadGenerater.start();
        threadChecker.start();

        while (true) {
            if (storage.getSet().size() == 100) {
                threadChecker.interrupt();
                threadGenerater.interrupt();
                break;
            }
        }
        System.out.println("End program!");
    }

}
