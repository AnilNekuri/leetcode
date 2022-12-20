public class NeedleInHaystack {
    public static void main(String[] args) {
        var haystack = "mississippi";
        var needle = "issipi";
        NeedleInHaystack p = new NeedleInHaystack();
        int r = p.strStr(haystack, needle);
        System.out.println("Result: "+r);
    }
    public int strStr(String haystack, String needle) {
        char[] nArray = needle.toCharArray();
        char[] hArray = haystack.toCharArray();
        for(int i = 0; i < hArray.length && nArray.length <= hArray.length;){
            int j = 0;
            int tempI = i;
            int lenghtMatched = 0;
            while(j < nArray.length && tempI < hArray.length && hArray[tempI] == nArray[j] ){
                tempI++;
                j++;
                lenghtMatched++;
            }
            if(lenghtMatched == nArray.length){
                //System.out.println("String matched: "+j);
                return i;
            }
            else{
                i++;
            }

        }
        return -1;
    }

}
