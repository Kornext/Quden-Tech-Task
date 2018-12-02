package task2;

import java.util.*;

public class Diagram {
    private String text;
    private List<String> words;
    private Map<String, Integer> diagram;

    public Diagram(String text) {
        this.text = text;
        words = Arrays.asList(text.split(" "));
        diagram = new HashMap<>();
        createDiagram();
    }

    private void createDiagram() {
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            if (!diagram.containsKey(currentWord)) {
                int count = 1;
                for (int j = i + 1; j < words.size(); j++) {
                    if (words.get(j).equals(currentWord)) {
                        count++;
                    }
                }
                diagram.put(currentWord, count);
            }
        }
    }

    public void sortASC(){
        diagram = sortByValue(diagram, false);
    }

    public void sortDESC() {
        diagram = sortByValue(diagram, true);
    }

    private <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map, boolean desc)
    {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        if(desc) {
            Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
                @Override
                public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            }.reversed());
        }
        else {
            Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
                @Override
                public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });
        }

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public void printDiagram() {
        List<String> keys = new ArrayList<String>(diagram.keySet());
        int wordMaxLength = keys.get(0).length();
        for (String word : keys) {
            if (word.length() > wordMaxLength) {
                wordMaxLength = word.length();
            }
        }
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            int value = diagram.get(key);
            if(key.length() < wordMaxLength) {
                int difference = wordMaxLength - key.length();
                StringBuilder underscore = new StringBuilder();
                for(int j=0; j<difference; j++) {
                    underscore.append("_");
                }
                key = underscore.append(key).toString();
            }
            StringBuilder points = new StringBuilder();
            for (int j = 0; j < value; j++) {
                points.append(".");
            }
            System.out.print(key + " " + points);
            System.out.println();
        }
    }
}
