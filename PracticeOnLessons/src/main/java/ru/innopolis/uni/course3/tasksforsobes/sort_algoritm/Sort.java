package ru.innopolis.uni.course3.tasksforsobes.sort_algoritm;

import java.util.Arrays;

/**
 * Created by Olga on 29.01.2017.
 */
public class Sort {

    static void swap(int[] items, int left, int right) {
        if (left != right) {
            int temp = items[left];
            items[left] = items[right];
            items[right] = temp;
        }
    }

    /**
     * Сортировка пузырьком
     *
     * @param items
     */
    static public void sortBuble(int[] items) {
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 1; i < items.length; i++) {
                if (items[i - 1] > items[i]) {
                    swap(items, i - 1, i);
                    swapped = true;
                }
            }
        } while (swapped != false);
    }


    /**
     * Сортировка вставками
     *
     * @param items
     */
    public static void sortInser(int[] items) {
        int sortedRangeEndIndex = 1;

        while (sortedRangeEndIndex < items.length) {
            if (items[sortedRangeEndIndex] < items[sortedRangeEndIndex - 1]) {
                int insertIndex = FindInsertionIndex(items, items[sortedRangeEndIndex], sortedRangeEndIndex);
                if (insertIndex != -1) {
                    Insert(items, insertIndex, sortedRangeEndIndex);
                }
            }

            sortedRangeEndIndex++;
        }
    }

    private static int FindInsertionIndex(int[] items, int valueToInsert, int sortedRangeEndIndex) {
        for (int index = 0; index <= sortedRangeEndIndex; index++) {
            if (items[index] > valueToInsert) {
                return index;
            }
        }

        return -1;
    }

    private static void Insert(int[] itemArray, int indexInsertingAt, int indexInsertingFrom) {
        int temp = itemArray[indexInsertingAt];
        itemArray[indexInsertingAt] = itemArray[indexInsertingFrom];
        for (int current = indexInsertingFrom; current < indexInsertingAt; current--) {
            itemArray[current] = itemArray[current - 1];
        }
        itemArray[indexInsertingAt + 1] = temp;
    }

    /**
     * Сортировка выбором
     *
     * @param items
     */
    public static void sortSelect(int[] items) {
        int sortedRangeEnd = 0;
        while (sortedRangeEnd < items.length) {
            int nextIndex = FindIndexOfSmallestFromIndex(items, sortedRangeEnd);
            swap(items, sortedRangeEnd, nextIndex);

            sortedRangeEnd++;
        }
    }

    private static int FindIndexOfSmallestFromIndex(int[] items, int sortedRangeEnd) {
        int currentSmallest = items[sortedRangeEnd];
        int currentSmallestIndex = sortedRangeEnd;

        for (int i = sortedRangeEnd + 1; i < items.length; i++) {
            if (currentSmallest > items[i]) {
                currentSmallest = items[i];
                currentSmallestIndex = i;
            }
        }

        return currentSmallestIndex;
    }

    /**
     * Сортировка слиянием
     *
     * @param items
     */
    public static void sortSliyaniem(int[] items) {
        if (items.length == 1) {
            return;
        }
        int leftSize = items.length / 2;
        int rightSize = items.length - leftSize;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        System.arraycopy(items, 0, left, 0, leftSize);
        System.arraycopy(items, leftSize, right, 0, rightSize);
        sortSliyaniem(left);
        sortSliyaniem(right);
        Merge(items, left, right);
    }

    private static void Merge(int[] items, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;
        int remaining = left.length + right.length;
        while (remaining > 0) {
            if (leftIndex == left.length) {
                items[targetIndex] = right[rightIndex++];
            } else if (rightIndex == right.length) {
                items[targetIndex] = left[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                items[targetIndex] = left[leftIndex++];
            } else {
                items[targetIndex] = right[rightIndex++];
            }

            targetIndex++;
            remaining--;
        }
    }

    /**
    static Random _pivotRng = new Random();

    public static void sortQuick(int[] items)
    {
        quicksort(items, 0, items.length - 1);
    }


    private static void quicksort(int[] items, int left, int right)
    {
        if (left < right)
        {
            int pivotIndex = _pivotRng.next(left, right);
            int newPivot = partition(items, left, right, pivotIndex);

            quicksort(items, left, newPivot - 1);
            quicksort(items, newPivot + 1, right);
        }
    }

    private int partition(T[] items, int left, int right, int pivotIndex)
    {
        T pivotValue = items[pivotIndex];

        Swap(items, pivotIndex, right);

        int storeIndex = left;

        for (int i = left; i &lt; right; i++)
        {
            if (items[i].CompareTo(pivotValue) &lt; 0)
            {
                Swap(items, i, storeIndex);
                storeIndex += 1;
            }
        }

        Swap(items, storeIndex, right);
        return storeIndex;
    }*/


    public static void main(String[] args) {
        int[] t = new int[]{5, 0, 2, 3, 4, -1, 8};
        sortBuble(t);
        System.out.println(Arrays.toString(t));

        int[] t1 = new int[]{5, 0, 2, 3, 4, -1, 8};
        sortInser(t1);
        System.out.println(Arrays.toString(t1));

        int[] t2 = new int[]{5, 0, 2, 3, 4, -1, 8};
        sortSelect(t2);
        System.out.println(Arrays.toString(t2));

        int[] t3 = new int[]{5, 0, 2, 3, 4, -1, 8};
        sortSliyaniem(t3);
        System.out.println(Arrays.toString(t3));

        /*int[] t4 = new int[]{5, 0, 2, 3, 4, -1, 8};
        sortQuick(t4);
        System.out.println(Arrays.toString(t4));*/

    }
}
