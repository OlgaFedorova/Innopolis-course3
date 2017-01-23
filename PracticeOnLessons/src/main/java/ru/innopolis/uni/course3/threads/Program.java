package ru.innopolis.uni.course3.threads;

/**
 * Created by Olga on 21.01.2017.
 */
public class Program {

    //Переменая, которой оперирует инкременатор
    public static int mValue = 0;

    static Incremenator mInc;	//Объект побочного потока


    static class Incremenator extends Thread
    {
        //О ключевом слове volatile - чуть ниже
        private volatile boolean mIsIncrement = true;

        public void changeAction()	//Меняет действие на противоположное
        {
            mIsIncrement = !mIsIncrement;
        }

        @Override
        public void run()
        {
            do
            {
                if(!isInterrupted())	//Проверка на необходимость завершения
                {
                    if(mIsIncrement)
                        Program.mValue++;	//Инкремент
                    else
                        Program.mValue--;	//Декремент

                    //Вывод текущего значения переменной
                    System.out.print(Program.mValue + " ");
                }
                else
                    return;		//Завершение потока

                try{
                    Thread.sleep(1000);		//Приостановка потока на 1 сек.
                }catch(InterruptedException e){
                    return;	//Завершение потока после прерывания
                }
            }
            while(true);
        }
    }

    public static void main(String[] args)
    {
        mInc = new Incremenator();	//Создание потока

        System.out.print("Значение = ");

        mInc.start();	//Запуск потока

        //Троекратное изменение действия инкременатора
        //с интервалом в i*2 секунд
        for(int i = 1; i <= 3; i++)
        {
            try{
                Thread.sleep(i*2*1000); //Ожидание в течении i*2 сек.
            }catch(InterruptedException e){}

            mInc.changeAction();	//Переключение действия
        }

        mInc.interrupt();	//Инициация завершения побочного потока
    }
}
