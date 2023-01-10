# leetcode

Todo
Learn java regex

 1. replace the punctuations with spaces, and put all letters in lower case
 String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
 
 2. split the string into words
 String[] words = normalizedStr.split("\\s+");
 
 3. Get key with max value, return the word with the highest frequency
 Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();

 4. Word count Collectors.groupingBy
    Map<String, Long> wordCount = Arrays.asList(words).stream()
    .filter(word -> !bannedSet.contains(word))
    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
 5. Sorting Comparator Java 8
    Comparator<String[]> byContent = new Comparator<String[]>() {
    @Override
    public int compare(String[] o1, String[] o2) {
      return !o1[1].equals(o2[1]) ?  o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]);
    }
    };
 6. Is Numeric 
     Character.isDigit(log.charAt(log.indexOf(" ")+1))