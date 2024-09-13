import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // счетчик количества пришедших смс-сообщений
        System.out.print("Введите количество SMS-сообщений: ");
        int N = Integer.parseInt(scanner.nextLine());

        // массив для хранения количества голосов для каждой пары
        int[] votes = new int[16];

        System.out.println("Введите номера пар (от 1 до 16):");
        for (int i = 0; i < N; i++) {
            int pairNumber = Integer.parseInt(scanner.nextLine());
            if (pairNumber < 1 || pairNumber > 16) {
                System.out.println("Номер пары должен быть от 1 до 16. Пожалуйста, введите снова номер:");
                i--; // уменьшение индекса, чтобы повторить ввод
            } else {
                votes[pairNumber - 1]++; // увеличение количества голосов для пары
            }
        }

        // переменные для хранения промежуточного результата
        int[] pairs = new int[16];
        int pairsCount = 0;

        // массив пар с учетом голосов
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > 0) {
                pairs[pairsCount] = i + 1; // номер пары
                pairsCount++;
            }
        }

        // результаты
        for (int i = 0; i < pairsCount; i++) {
            System.out.print(pairs[i] + " " + votes[pairs[i] - 1] + " ");
        }
        System.out.println(); // переход на новую строку

        // сортировка по количеству голосов в порядке убывания
        for (int i = 0; i < votes.length; i++) {
            for (int j = i + 1; j < votes.length; j++) {
                if (votes[i] < votes[j]) {
                    // перемена местами количество голосов
                    int tempVotes = votes[i];
                    votes[i] = votes[j];
                    votes[j] = tempVotes;

                    // то же самое с индексами пар
                    int tempPairIndex = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = tempPairIndex;
                }
            }
        }

        // отсортированный результат
        for (int i = 0; i < pairsCount; i++) {
            System.out.print(pairs[i] + " " + votes[pairs[i] - 1] + " ");
        }
        System.out.println();
    }
}


