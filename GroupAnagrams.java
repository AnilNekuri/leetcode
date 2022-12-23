import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        var ga = new GroupAnagrams();
        //ga.groupAnagrams(strs);
        System.out.println(ga.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (var str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.copyValueOf(chars);
            if(map.containsKey(key))
                map.get(key).add(str);
            else{
                var anagram = new ArrayList<String>();
                anagram.add(str);
                map.put(key,anagram);
            }
        }
        return map.values().stream().toList();
    }
}
