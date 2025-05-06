package javaCollectionFramework.Assignment2;

import java.util.*;

class Wordcounter{
    public static void main(String[] args) {
        String paragraph= "In the hearti i i i i i  of the bustling city, people hurried through crowded streets, chasing time. Vendors called out, offering colorful fruits, spices, and souvenirs. Children laughed, playing near fountains that sparkled in the afternoon sun. Pigeons scattered as cars honked, weaving between cyclists and pedestrians. Amid the chaos, a street musician played a soft melody, drawing smiles from passersby. The aroma of baked bread drifted from nearby cafes. Life pulsed in every direction—fast, loud, and vivid. Yet, moments of calm whispered through the noise, reminding all that beauty exists even in the rush. The city breathed, alive and endlessly moving forward.";
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z\\s]", "");
        String[] words= paragraph.split("\\s+");

        Map<String, Integer> wordCount= new HashMap<>();
        for(String word: words){
            if(!word.isEmpty()){
                wordCount.put(word,wordCount.getOrDefault(word,0)+1);
            }
        }

        Set<String> sortedWords = new TreeSet<>(wordCount.keySet());


        System.out.println("Number of unique words: " + wordCount.size());
        System.out.println("Word Frequencies in sorted order:");

        for (String word : sortedWords) {
            System.out.println(word + ": " + wordCount.get(word));
        }
    }


}