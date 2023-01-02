# leetcode
 1. replace the punctuations with spaces, and put all letters in lower case
 String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
 
 2. split the string into words
 String[] words = normalizedStr.split("\\s+");
 
 3. Get key with max value, return the word with the highest frequency
 Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
