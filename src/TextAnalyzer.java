import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть текст:");
        String text = scanner.nextLine();

        System.out.println("Оберіть операцію:\n1. Пошук слова\n2. Замінити слово\n3. Підрахунок кількості слів");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.println("Введіть слово для пошуку:");
                String word = scanner.nextLine();
                Function<String, Boolean> findWord = t -> t.contains(word);
                System.out.println("Слово знайдено: " + findWord.apply(text));
            }
            case 2 -> {
                System.out.println("Введіть слово для заміни:");
                String oldWord = scanner.nextLine();
                System.out.println("Введіть нове слово:");
                String newWord = scanner.nextLine();
                BiFunction<String, String, String> replaceWord = (o, n) -> text.replace(o, n);
                System.out.println("Новий текст: " + replaceWord.apply(oldWord, newWord));
            }
            case 3 -> {
                Function<String, Long> countWords = t -> t.split("\\s+").length * 1L;
                System.out.println("Кількість слів: " + countWords.apply(text));
            }
            default -> System.out.println("Невірний вибір!");
        }
        scanner.close();
    }
}
