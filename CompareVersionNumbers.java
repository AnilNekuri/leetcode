public class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers cvn = new CompareVersionNumbers();
        System.out.println(cvn.compareVersion("1.01","1"));
    }
    public int compareVersion(String version1, String version2) {
        var v1Arr = version1.split("\\.");
        var v2Arr = version2.split("\\.");
        for(int i = 0; i < v1Arr.length || i  <v2Arr.length; i++){
            var v1 = i < v1Arr.length  ? Integer.parseInt(v1Arr[i]): 0;
            var v2 = i < v2Arr.length  ? Integer.parseInt(v2Arr[i]): 0;
            if(v1  < v2 ){
                return -1;
            }else if(v1 > v2){
                return 1;
            }else {
                continue;
            }
        }
        return 0;
    }
}
