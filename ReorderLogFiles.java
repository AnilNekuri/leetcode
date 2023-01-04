import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        ReorderLogFiles r = new ReorderLogFiles();
        String[] strings = r.reorderLogFiles(logs);
        for (String str:
             strings) {
            System.out.println(str);
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> digits = new ArrayList<>();
        List<String[]> letters = new ArrayList<>();
        List<String> results = new ArrayList<>();
        for(int i = 0; i < logs.length; i++){
            String log = logs[i];
            int si = log.indexOf(" ");
            if(Character.isDigit(log.charAt(log.indexOf(" ")+1)))
                digits.add(log);
            else
                letters.add(new String[]{log.substring(0,si),log.substring(si+1,log.length())});
        }
        Comparator<String[]> byContent = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return !o1[1].equals(o2[1]) ?  o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]);
            }
        };
        letters.sort(byContent);
        for (String[] letter: letters) {
            results.add(letter[0]+" "+letter[1]);
        }
        results.addAll(digits);
        return results.stream()
                .toArray(String[]::new);
    }
}
