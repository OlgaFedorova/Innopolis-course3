package ru.innopolis.uni.course3.patterns.singlton;

/**
 Использование внутреннего класса(решение Била Пью(Bill Pugh) “Initialization on Demand Holder”).
 В данном случае мы полностью решили проблему ленивой инициализации – объект инициализируется при первом вызове метода
 getInstance(). Но у нас осталась проблема с обработкой исключительных ситуаций в конструкторе.
 + Ленивая инициализация
 + Высокая производительность
 - Невозможно использовать для не статических полей класса
 */
public class Singlton3 {

    private Singlton3() {
    }

    private static class Singlton3Holder{
        private final static Singlton3 instanse = new Singlton3();
    }

    public static Singlton3 getInstance(){
        return Singlton3Holder.instanse;
    }
}
