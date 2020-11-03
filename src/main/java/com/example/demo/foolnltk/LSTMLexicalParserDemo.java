package com.example.demo.foolnltk;

import me.midday.FoolNLTK;
import me.midday.lexical.AnalysisResult;
import me.midday.lexical.Entity;
import me.midday.lexical.LexicalAnalyzer;
import me.midday.lexical.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ansonglin
 * @className LSTMLexicalParserDemo
 * @description TODO
 * @date 2019/12/11 10:23
 * @cersion 1.0
 **/
public class LSTMLexicalParserDemo {
    public static void main(String[] args){
        String text = "bearing the author's name a named source";
        LexicalAnalyzer lexicalAnalyzer = FoolNLTK.getLSTMLexicalAnalyzer();
        // 分词
        List<List<Word>> words = lexicalAnalyzer.cut(text);
        for(List<Word> ws: words){
            ws.forEach(System.out::println);
        }
        System.out.println("----------------");
        // 词性标注
        List<List<Word>> posWords = lexicalAnalyzer.pos(text);
        for(List<Word> ws: posWords){
            ws.forEach(System.out::println);
        }

        System.out.println("----------------");
        // 实体识别
        List<List<Entity>>  entities = lexicalAnalyzer.ner(text);

        for(List<Entity> ents :entities){
            ents.forEach(System.out::println);
        }

        System.out.println("----------------");
        // 分词，词性，实体识别
        List<AnalysisResult>  results = lexicalAnalyzer.analysis(text);
        results.forEach(System.out::println);


        System.out.println("----------------");
        // 多文本
        System.out.println();
        System.out.println("多文本：");
        List<String> docs = new ArrayList<>();
        docs.add(text);
        docs.add(text);
        // 分词
        List<List<Word>> dWords = lexicalAnalyzer.cut(docs);
        for(List<Word> ws: dWords){
            ws.forEach(System.out::println);
        }

        System.out.println("----------------");
        // 词性标注
        List<List<Word>> dPosWords = lexicalAnalyzer.pos(docs);
        for(List<Word> ws: dPosWords){
            ws.forEach(System.out::println);
        }
        List<List<Entity>>  dEntities = lexicalAnalyzer.ner(docs);

        for(List<Entity> ents :dEntities){
            ents.forEach(System.out::println);
        }
        System.out.println("----------------");
        // 分词, 词性标注，实体识别
        List<AnalysisResult>  dResults = lexicalAnalyzer.analysis(docs);
        dResults.forEach(System.out::println);

    }
}
