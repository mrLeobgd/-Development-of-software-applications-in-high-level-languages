import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.awt.*;

/**
 * Класс для извлечения паролей из текстового файла.
 */
public class PasswordExtractor
{
    /**
     * Главный метод, который читает файл, ищет пароли, записывает результаты в файл, а затем открывает результирующий файл
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args)
    {
        try
        {
            String content = readFile("password.txt");
            Map<String, Integer> passwordCount = findPasswords(content);
            writeToFile("output.txt", passwordCount);
            File outputFile = new File("output.txt");
            Desktop.getDesktop().open(outputFile);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Читает содержимое файла с заданным именем и возвращает его в виде строки.
     *
     * @param filename имя файла для чтения
     * @return содержимое файла в виде строки
     * @throws FileNotFoundException если файл не найден
     */
    public static String readFile(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String content = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return content;
    }

    /**
     * Извлекает пароли из заданной строки и возвращает карту паролей и количество их повторений.
     *
     * @param content текстовая строка для поиска паролей
     * @return карта паролей и их количества повторений
     */
    public static Map<String, Integer> findPasswords(String content)
    {
        Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}");
        Matcher matcher = pattern.matcher(content);
        Map<String, Integer> passwordCount = new HashMap<>();
        while (matcher.find())
        {
            String password = matcher.group();
            int count = passwordCount.getOrDefault(password, 0);
            passwordCount.put(password, count + 1);
        }
        return passwordCount;
    }

    /**
     * Записывает карту паролей и количество их повторений в файл с заданным именем.
     *
     * @param filename имя файла для записи результатов
     * @param passwordCount карта паролей и количества их повторений
     * @throws IOException если произошла ошибка записи в файл
     */
    public static void writeToFile(String filename, Map<String, Integer> passwordCount) throws IOException
    {
        FileWriter writer = new FileWriter(filename);
        for (Map.Entry<String, Integer> entry : passwordCount.entrySet())
        {
            String password = entry.getKey();
            int count = entry.getValue();
            writer.write(password + " " + count + "\n");
        }
        writer.close();
    }
}