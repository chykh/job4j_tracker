package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Collections.sort;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0;
        double totalScore = 0;
        List<Label> averagePupils = averageScoreByPupil(pupils);
        for (Label label : averagePupils) {
            totalScore = totalScore + label.score();
        }
        result = totalScore / averagePupils.size();
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score = score + subject.score() ;
            }
            double averageScore = score / pupil.subjects().size();
            result.add(new Label(pupil.name(), averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        ArrayList<Label> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), score + subject.score());
            }
        }
        for (String name : map.keySet()) {
            result.add(new Label(name, map.get(name) / (double)pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score = score + subject.score() ;
            }
            result.add(new Label(pupil.name(), score));
        }
        sort(result);
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), score + subject.score());
            }
        }
        ArrayList<Label> list = new ArrayList<>();
        for (String name : map.keySet()) {
            list.add(new Label(name, map.get(name)));
        }
        sort(list);
        return list.get(list.size() - 1);
    }
}
