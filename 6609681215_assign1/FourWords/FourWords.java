// Prachaya Kheawchan
// 6609681215

public class FourWords {
    private String word1;
    private String word2;
    private String word3;
    private String word4;
    private int count;

    public void add(String word) {
        if (word1 == null) {
            this.word1 = word;
            this.count++;
        } else if (word2 == null) {
            this.word2 = word;
            this.count++;
        } else if (word3 == null) {
            this.word3 = word;
            this.count++;
        } else if (word4 == null) {
            this.word4 = word;
            this.count++;
        } else {
            System.out.println("Can't add a new word " + word + " !");
        }
    }

    public String getMin() {
        if (word1 == null && word2 == null && word3 == null && word4 == null) {
            return "null";
        }
        int minw = word1.compareTo(word1);
        String min = word1;
        if (word2 != null && word2.compareTo(word1) < minw) {
            minw = word2.compareTo(word1);
            min = word2;
        }
        if (word3 != null && word3.compareTo(word1) < minw) {
            minw = word3.compareTo(word1);
            min = word3;
        }
        if (word4 != null && word4.compareTo(word1) < minw) {
            minw = word4.compareTo(word1);
            min = word4;
        }
        return min;
    }

    public String getMax() {
        if (word1 == null && word2 == null && word3 == null && word4 == null) {
            return "null";
        }
        int maxw = word1.compareTo(word1);
        String max = word1;

        if (word2 != null && word2.compareTo(word1) > maxw) {
            maxw = word2.compareTo(word1);
            max = word2;
        }
        if (word3 != null && word3.compareTo(word1) > maxw) {
            maxw = word3.compareTo(word1);
            max = word3;
        }
        if (word4 != null && word4.compareTo(word1) > maxw) {
            maxw = word4.compareTo(word1);
            max = word4;
        }
        return max;
    }

    public void printWords() {
        if (word1 == null && word2 == null && word3 == null && word4 == null) {
            System.out.println("No words set up yet!");
        }
        int totalLength = 0;
        
        System.out.println(" List of words: ");
        if (word1 != null) {
            System.out.println("    " + word1);
            totalLength += word1.length();
        }
        if (word2 != null) {
            System.out.println("    " + word2);
            totalLength += word2.length();
        }
        if (word3 != null) {
            System.out.println("    " + word3);
            totalLength += word3.length();
        }
        if (word4 != null) {
            System.out.println("    " + word4);
            totalLength += word4.length();
        }
        System.out.println();
        System.out.println("The lexicographic minimum is " + getMin());
        System.out.println("The lexicographic maximum is " + getMax());
        System.out.println("Total length " + totalLength);

        if (count == 0) {
            System.out.printf("Average length %.6f", (double) totalLength);
        } else {
            System.out.printf("Average length %.6f", (double) totalLength / count);
        }
    }
}
