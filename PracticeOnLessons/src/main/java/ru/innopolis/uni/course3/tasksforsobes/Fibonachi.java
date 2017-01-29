package ru.innopolis.uni.course3.tasksforsobes;

/**
 * Created by Olga on 29.01.2017.
 */
public class Fibonachi {

    public static void PrintFibonachi(int a, int b)
    {
        int sum = a + b;
        System.out.println("{0}" + sum);

        a = b;
        b = sum;
        if (Integer.MAX_VALUE - b > a)
        {
            PrintFibonachi(a, b);
        }
    }

    /* 2 вариант */
    public static void PrintFibonachi2(int a, int b)
    {
        if (0.0 + a + b < Integer.MAX_VALUE) // or (double)a or (double)b
        {
            int sum = a + b;
            System.out.println("{0}" + sum);

            a = b;
            b = sum;
            PrintFibonachi2(a, b);
        }
    }

    public static void main(String[] args) {
        PrintFibonachi(1,1 );
        PrintFibonachi2(1,1 );
    }
}
