/** Программа вычисляет числа Фибоначчи –
 * последовательность чисел, в котором каждое следующее
 * число равно сумме двух предыдущих.
 * @autor Огородников Лев 
 */
public class Main {
    /**
     * Метод предназначен для вычисления чисел Фибоначчи
     * новый элемент массива является суммой двух предыдущих элементов
     * @param args Не используется.
     */
    public static void main(String[] args) {
        int n = 9;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        System.out.println("Последовательность Фибоначчи: ");
        for (int i = 2; i<n; ++i)
        {
            System.out.println(arr[i-2]);
            arr[i]=arr[i-1]+arr[i-2];
        }
    }
}