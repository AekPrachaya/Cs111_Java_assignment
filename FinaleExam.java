import java.util.ArrayList;

class FinaleExam {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(3);
        System.out.println(arr.indexOf(2));
        System.out.println(arr.lastIndexOf(3));
        arr.remove(arr.indexOf(3));
    }
}
 
