// Prachaya Kheawchan
// 6609681215

import java.util.Scanner;

public class FourWordsTest {
    public static void main(String[] args) {
        FourWords wordssss = new FourWords();
        Scanner sc = new Scanner(System.in);

        wordssss.printWords();
        for (int i = 0; i < 5; i++) {
            System.out.printf("%nEnter your word: ");
            String word = sc.nextLine();

            wordssss.add(word);
            System.out.printf("Round %d: ", i + 1);
            wordssss.printWords();
            System.out.println();
        }
        sc.close();

    }
}