package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

/** Класс Tasks описывает 8 задач 2-ой лабораторной работы. "
 * @author Огородников Лев
 */
public class Tasks
{
    /** Метод task1 вычисляет значение выражения по формуле 15 варианта.
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task1(int inputMode) throws FileNotFoundException
    {
        double x;
        double y;
        double result;
        if (inputMode == 1)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите x ");
            x = scanner.nextDouble();
            System.out.print("Введите y ");
            y = scanner.nextDouble();
        }
        else
        {
            String path = "task_1_data.txt";
            Scanner scanner = new Scanner(new File(path));
            x = scanner.nextDouble();
            System.out.println("Ввод x из файла, x = " + x);
            y = scanner.nextDouble();
            System.out.println("Ввод y из файла, y = " + y);
        }
        result = x * Math.log(x) + y/(Math.cos(x)-x/3);
        System.out.println("Результат: " + result);
    }

    /**
     * Вычисляет значение выражения 2x^4 - 3x^3 + 4x^2 - 5x + 6 для заданного значения x.
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task2(int inputMode) throws FileNotFoundException
    {
        double x;
        if (inputMode == 1)
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите x: ");
            x = scan.nextDouble();
        }
        else
        {
            String path = "task_2_data.txt";
            Scanner scanner = new Scanner(new File(path));
            x = scanner.nextDouble();
            System.out.println("Ввод из файла, x = " + x);
        }
        double x2 = x * x;
        double x4 = x2 * x2;
        double x3 = x2 * x;
        double result = (2 * x4) - (3 * x3) + (4 * x2) - (5 * x) + 6;
        System.out.println("Результат выражения = " + result);
    }

    /** Метод task3 считает количество целых чисел среди a, b, c
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task3(int inputMode) throws FileNotFoundException
    {
        double a;
        double b;
        double c;
        if (inputMode == 1)
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите число a: ");
            a = scan.nextDouble();
            System.out.print("Введите число b: ");
            b = scan.nextDouble();
            System.out.print("Введите число c: ");
            c = scan.nextDouble();
        }
        else
        {
            String path = "task_3_data.txt";
            Scanner scanner = new Scanner(new File(path));
            a = scanner.nextDouble();
            System.out.println("Ввод a из файла, a = " + a);
            b = scanner.nextDouble();
            System.out.println("Ввод b из файла, b = " + b);
            c = scanner.nextDouble();
            System.out.println("Ввод c из файла, c = " + c);
        }
        int count = 0;
        if (a == Math.floor(a) && !Double.isInfinite(a))
        {
            count++;
        }
        if (b == Math.floor(b) && !Double.isInfinite(b))
        {
            count++;
        }
        if (c == Math.floor(c) && !Double.isInfinite(c))
        {
            count++;
        }
        System.out.println("Количество целых чисел = " + count);
    }

    /**Метод task4 определяет, можно ли построить треугольник с заданными длинами сторон,
     * и является ли он остроугольным.
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task4(int inputMode) throws FileNotFoundException
    {
        double a;
        double b;
        double c;
        if (inputMode == 1)
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите длину стороны a: ");
            a = scan.nextDouble();
            System.out.print("Введите длину стороны b: ");
            b = scan.nextDouble();
            System.out.print("Введите длину стороны c: ");
            c = scan.nextDouble();
        }
        else
        {
            String path = "task_4_data.txt";
            Scanner scanner = new Scanner(new File(path));
            a = scanner.nextDouble();
            System.out.println("Ввод стороны a из файла, a = " + a);
            b = scanner.nextDouble();
            System.out.println("Ввод стороны b из файла, b = " + b);
            c = scanner.nextDouble();
            System.out.println("Ввод стороны c из файла, c = " + c);
        }
        if (a + b > c && a + c > b && b + c > a)
        {
            double maxSide = Math.max(Math.max(a, b), c);
            double sumSquares = 0;
            if (a == maxSide)
            {
                sumSquares = b * b + c * c;
            }
            else if (b == maxSide)
            {
                sumSquares = a * a + c * c;
            }
            else
            {
                sumSquares = a * a + b * b;
            }
            if (sumSquares > maxSide * maxSide)
            {
                System.out.print("Треугольник остроугольный");
            }
            else if (sumSquares == maxSide * maxSide)
            {
                System.out.print("Треугольник прямоугольный");
            }
            else
            {
                System.out.print("Треугольник тупоугольный");
            }
        }
        else
        {
            System.out.print("Треугольник нельзя построить");
        }
    }

    /**Метод task5 Программа выводит значение числа N в зависимости от остатка от деления на 4
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task5(int inputMode) throws FileNotFoundException
    {
        int N;
        if (inputMode == 1)
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите натуральное число N: ");
            N = scan.nextInt();
        }
        else
        {
            String path = "task_5_data.txt";
            Scanner scanner = new Scanner(new File(path));
            N = scanner.nextInt();
            System.out.println("Ввод  натурального число N из файла, N = " + N);
        }
        int remainder = N % 4;
        double k = N/4;
        switch (remainder)
        {
            case 0:
                System.out.println("N = " + N * k);
                break;
            case 1:
                System.out.println("N = " + N * k + 1);
                break;
            case 2:
                System.out.println("N = " + N * k + 2);
                break;
            case 3:
                System.out.println("N = " + N * k + 3);
                break;
            default:
                System.out.println("Некорректное значение числа");
                break;
        }
    }

    /** Метод task6 выводит на экран все числа Пифагора, меньшие N..
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     * */
    public void task6(int inputMode) throws FileNotFoundException
    {
        int N;
        if (inputMode == 1)
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите натуральное число N: ");
            N = scan.nextInt();
        }
        else
        {
            String path = "task_6_data.txt";
            Scanner scanner = new Scanner(new File(path));
            N = scanner.nextInt();
            System.out.println("Ввод  натурального число N из файла, N = " + N);
        }
        for (int a = 1; a < N; a++)
        {
            for (int b = a + 1; b < N; b++)
            {
                int c = (int) Math.sqrt(a * a + b * b);
                if (c * c == a * a + b * b && c < N)
                {
                    System.out.println(a + "^2 + " + b + "^2 = " + c + "^2");
                }
            }
        }
    }

    /** Метод task7 находит сумму n членов ряда
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task7(int inputMode) throws FileNotFoundException
    {
        int n;
        float x;
        float sum = 0;
        if (inputMode == 1)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число n ");
            n = scanner.nextInt();
            System.out.println("Введите число x ");
            x = scanner.nextFloat();
        }
        else
        {
            String path = "task_7_data.txt";
            Scanner scanner = new Scanner(new File(path));
            n = scanner.nextInt();
            System.out.println("Ввод из файла числa n " + n);
            x = scanner.nextFloat();
            System.out.println("Ввод из файла числa x " + x);
        }
        for (int i = 1; i <= n; i++)
        {
            long fact = 1;
            for (int j = 2; j <= 2*i-1; j++)
            {
                fact = fact * j;
            }
            sum += Math.pow(-1,i-1)*(Math.pow(x,2*i-1)/fact);
        }
        System.out.println("Сумма n членов ряда = " + sum);
    }

    /**
     Метод task8 для получения расписания звонков на весь учебный день в учебном заведении.
     Задаются параметры начала учебного дня, продолжительности пары, продолжительности
     обычного и большого перерывов (и их место в расписании), количество пар.
     @param inputMode параметр передает режим ввода данных.
     @exception FileNotFoundException При ошибке открытия файла.
     @exception ParseException При ошибке в парсинге даты.
     */
    public void task8(int inputMode) throws FileNotFoundException, ParseException {
        long lessonDuration, standardInterval, bigInterval, time;
        int indexBigInterval, countLessons;
        Date startDay;
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
        formater.setTimeZone(TimeZone.getTimeZone("GMT"));
        if (inputMode == 1)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Начало учебного дня: ");
            startDay = formater.parse(scanner.nextLine());
            time = startDay.getTime();
            System.out.print("Продолжительность пары: ");
            lessonDuration = formater.parse(scanner.nextLine()).getTime();
            System.out.print("Продолжительность обычного перерыва: ");
            standardInterval = formater.parse(scanner.nextLine()).getTime();
            System.out.print("Продолжительность большого перерыва: ");
            bigInterval = formater.parse(scanner.nextLine()).getTime();
            System.out.print("Его позиция: ");
            indexBigInterval = scanner.nextInt();
            System.out.print("Кол-во пар: ");
            countLessons = scanner.nextInt();
            System.out.println();
        }
        else
        {
            Scanner scanner = new Scanner(new File("task_8_data.txt"));
            startDay = formater.parse(scanner.nextLine());
            time = startDay.getTime();
            System.out.println("Начало учебного дня: " +  formater.format(new Date(time)));
            lessonDuration = formater.parse(scanner.nextLine()).getTime();
            System.out.println("Продолжительность пары: " + formater.format(new Date(lessonDuration)));
            standardInterval = formater.parse(scanner.nextLine()).getTime();
            System.out.println("Продолжительность обычного перерыва: " +  formater.format(new Date(standardInterval)));
            bigInterval = formater.parse(scanner.nextLine()).getTime();
            System.out.println("Продолжительность большого перерыва: " +  formater.format(new Date(bigInterval)));
            indexBigInterval = scanner.nextInt();
            System.out.println("Его позиция: " + indexBigInterval);
            countLessons = scanner.nextInt();
            System.out.println("Кол-во пар: " + countLessons);
            System.out.println();
            time = startDay.getTime();
        }
        for (int i = 1; i <= countLessons; i++)
        {
            System.out.println(i + " пара");
            System.out.println(formater.format(new Date(time)));
            time += lessonDuration;
            System.out.println(formater.format(new Date(time)));
            System.out.println();
            if (i != countLessons)
            {
                System.out.println("Перерыв:");
                System.out.println(formater.format(new Date(time)));
                if (i != indexBigInterval)
                {
                    time += standardInterval;
                    System.out.println(formater.format(new Date(time)));
                }
                else
                {
                    time += bigInterval;
                    System.out.println(formater.format(new Date(time)));
                }
                System.out.println();
            }
        }
    }
}