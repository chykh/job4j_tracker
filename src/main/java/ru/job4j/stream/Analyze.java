package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.summingDouble;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average().orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(),
                        e.getSubjects().stream()
                                .mapToInt(Subject::getScore)
                                .average().orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
         HashMap<String, Double> temp = stream
                .flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, LinkedHashMap::new, averagingDouble(Subject::getScore)
                ));
         return temp.entrySet().stream().map(e -> new Tuple(e.getKey(), e.getValue())).collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
                return stream.map(e -> new Tuple(e.getName(), e.getSubjects().stream().mapToInt(Subject::getScore).sum()))
                .max(Comparator.comparingDouble(Tuple::getScore)).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
         Map<String, Double> temp = stream
                 .flatMap(e -> e.getSubjects().stream())
                 .collect(Collectors.groupingBy(
                        Subject::getName, summingDouble(Subject::getScore)));

         return temp.entrySet().stream()
                 .map(e -> new Tuple(e.getKey(), e.getValue()))
                 .max(Comparator.comparingDouble(Tuple::getScore))
                 .orElse(null);

    }

}
