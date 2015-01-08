package ua.epam.sergiishapoval.projects.strings;

import ua.epam.sergiishapoval.projects.strings.taskentities.Sentence;
import ua.epam.sergiishapoval.projects.strings.taskentities.Text;
import ua.epam.sergiishapoval.projects.strings.taskentities.Word;

import java.io.IOException;
import java.util.*;

/**
 * Created by Сергей on 06.11.2014.
 * Создать программу обработки текста учебника по программированию
 * с использованием классов: Символ, Слово, Предложение, Знак препинания и др.
 * Во всех задачах с формированием текста заменять табуляции и
 * последовательности пробелов одним пробелом.
 * 1.	Найти наибольшее количество предложений текста,
 * в которых есть одинаковые слова.
 *
 * == задача равносильна поиску слова,
 * которое встречается максимальное число раз,
 * достаём множество предложений,
 * достаём все слова из собранных предложений,
 * кроме максимального,
 * достаем все предложения, кроме уже собранных,
 * проверяем каждое предложение, можно ли его добавить во множество,
 * чтобы не нарушить правило.
 *
 * Вводим понятие ранга предложения = к-во уникальных предложений,
 * в которых встречаются его слова. Для получения такого списка -
 * карта слов на множество предложений.
 * Из карты получаем счётчик уникальных предложений.
 *
 */
public class WordsInSentencesMain {


    public static void main(String[] args) {

        Text currentText = new Text("C:\\Dropbox\\epam\\EpamCoursesCode\\src\\ua\\epam\\sergiishapoval\\projects\\strings\\resources\\MathTextSmall.txt");

        try{
            currentText.createtext();
        }catch (IOException e) {
            System.out.println(e);
        }

        List<Sentence> sentenceList = currentText.getSentences();

        System.out.println(String.format("Number of sentences in a text: %d", sentenceList.size()));

        Map<Word, Set<Sentence>> wordRange = calculateWordRange(sentenceList);

        Word wordWithMaxRange = getWordWithMaxRange(wordRange);

        System.out.println(String.format("Word with maximum range: %s",wordWithMaxRange ));


        Set<Sentence> resultSentenceSet = new HashSet<>();
        Set<Sentence> sentenceSetToCheck = new HashSet<>();


//get sentences with word of Max Range, and make set of other sentences to check
        for (Sentence sentence : wordRange.get(wordWithMaxRange)){
            resultSentenceSet.add(sentence);
            for (Word word : sentence.getWords()){
                sentenceSetToCheck.addAll(wordRange.get(word));
            }
        }

        sentenceSetToCheck.removeAll(resultSentenceSet);

        checkPotentialSentences(wordRange, resultSentenceSet, sentenceSetToCheck);


        System.out.println(String.format("Number of sentences with at least one similar word: %d", resultSentenceSet.size()));

        for (Sentence sentence : resultSentenceSet){
            System.out.println(sentence);
        }
    }

//check other sentences if they contain necessary words

    private static void checkPotentialSentences(Map<Word, Set<Sentence>> wordRange, Set<Sentence> resultSentenceSet, Set<Sentence> sentenceSetToCheck) {
        for (Sentence sentenceToCheck : sentenceSetToCheck){
            boolean isAllOtherContainSimilarWord = true;
            for (Sentence resultSentence : resultSentenceSet){
                if (!sentenceToCheck.hasSimilarWords(resultSentence, wordRange)) {
                    isAllOtherContainSimilarWord = false;
                    break;
                }

            }
            if (isAllOtherContainSimilarWord) resultSentenceSet.add(sentenceToCheck);
        }
    }


    private static Word getWordWithMaxRange(Map<Word, Set<Sentence>> wordRange) {
        Word wordWithMaxRange = null;
        int maxRange = 0;

        for (Word word : wordRange.keySet()){
            if (wordWithMaxRange == null) {
                wordWithMaxRange = word;
                maxRange = wordRange.get(word).size();
            } else {
                if (maxRange < wordRange.get(word).size()){
                    wordWithMaxRange = word;
                    maxRange = wordRange.get(word).size();
                } else {
                    if (maxRange == wordRange.get(word).size()){
                        int countPotentialMaxWordSentence = getMaxSentenceLength(wordRange, word);;
                        int countCurrentMaxWordSentence = getMaxSentenceLength(wordRange, wordWithMaxRange);
                        if (countCurrentMaxWordSentence < countPotentialMaxWordSentence){
                            wordWithMaxRange = word;
                        }
                    }
                }
            }
        }
        return wordWithMaxRange;
    }

    private static int getMaxSentenceLength(Map<Word, Set<Sentence>> wordRange, Word wordWithMaxRange) {
        int countCurrentMaxWordSentence = 0;
        for (Sentence sentence : wordRange.get(wordWithMaxRange)){
            if (countCurrentMaxWordSentence < sentence.getWords().size())
                countCurrentMaxWordSentence = sentence.getWords().size();
        }
        return countCurrentMaxWordSentence;
    }

    private static Map<Word, Set<Sentence>> calculateWordRange(List<Sentence> sentenceList) {
        Map<Word, Set<Sentence>> wordRange = new HashMap<>();

        for (Sentence sentence: sentenceList) {
            Set<Word> wordSet = sentence.getWords();
            for (Word word: wordSet){
                if (wordRange.containsKey(word)){
                    wordRange.get(word).add(sentence);
                } else {
                    Set<Sentence> sentenceOfWord= new HashSet<>();
                    sentenceOfWord.add(sentence);
                    wordRange.put(word, sentenceOfWord);
                }
            }
        }
        return wordRange;
    }


}
