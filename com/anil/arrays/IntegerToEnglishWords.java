package com.anil.arrays;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    private static String BILLION = "Billion ";
    private static String MILLION = "Million ";
    private static String THOUSAND = "Thousand ";
    private static String[] bmt = {BILLION,MILLION,THOUSAND,""};
    private static String HUNDRED = "Hundred ";
    private static Map<Integer,String> underTwenty = new HashMap<Integer, String>() {{
        put(1, "One ");put(2, "Two ");put(3, "Three ");put(4, "Four ");put(5, "Five ");
        put(6, "Six ");put(7, "Seven ");put(8, "Eight ");put(9, "Nine ");put(10, "Ten ");
        put(11, "Eleven ");put(12, "Twelve ");put(13, "Thirteen ");put(14, "Fourteen ");put(15, "Fifteen ");
        put(16, "Sixteen ");put(17, "Seventeen ");put(18, "Eighteen ");put(19, "Nineteen ");
    }};
    private static Map<Integer,String> TwentyAndAbove = new HashMap<Integer, String>() {{
       put(2, "Twenty ");put(3, "Thirty ");put(4, "Forty ");put(5, "Fifty ");
        put(6, "Sixty ");put(7, "Seventy ");put(8, "Eighty ");put(9, "Ninety ");
    }};
    public static void main(String[] args) {
        int num = 1234567;//12345;;//123;
        IntegerToEnglishWords ie = new IntegerToEnglishWords();
        String words = ie.numberToWords(num);
        //var words = ie.underHundredWord(39);
        System.out.println(words);
    }
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0, hn = 1000000000, tnum = num; i < bmt.length; i++, hn = hn/1000){
            int temp = tnum/hn;
            if(temp > 0){
                int hundreds = temp/100;
                int underHun = temp%100;
                if(hundreds > 0){
                    sb.append(underTwenty.get(hundreds));
                    sb.append(HUNDRED);
//                    if(underHun > 0){
//                        sb.append("and ");
//                    }
                }
                sb.append(underHundredWord(underHun));
                sb.append(bmt[i]);
            }
            tnum = tnum%hn;
        }
        return sb.toString().trim();
    }

    private String underHundredWord(int underHun){
        StringBuffer sb = new StringBuffer();
        int dd = underHun/10;
        int rem = underHun%10;
        if(dd >= 2){
            sb.append(TwentyAndAbove.get(dd));
            if(rem > 0)
                sb.append(underTwenty.get(rem));
        }else if(underHun > 0){
            sb.append(underTwenty.get(underHun%20));
        }
        return sb.toString();
    }

}
