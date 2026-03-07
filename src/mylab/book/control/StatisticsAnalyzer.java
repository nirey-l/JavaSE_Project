package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {
    
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            sumMap.put(type, sumMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgMap = new HashMap<>();
        for (String key : sumMap.keySet()) {
            avgMap.put(key, (double) sumMap.get(key) / countMap.get(key));
        }
        return avgMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distMap = new HashMap<>();
        int total = publications.length;
        for (String key : countMap.keySet()) {
            distMap.put(key, (countMap.get(key) / (double) total) * 100);
        }
        return distMap;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (count / (double) publications.length) * 100;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat priceFormat = new DecimalFormat("#,###원");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        String[] types = {"소설", "참고서", "잡지"};
        for (String type : types) {
            if (avgPrices.containsKey(type)) {
                System.out.println("   - " + type + ": " + priceFormat.format(avgPrices.get(type)));
            }
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distributions = calculatePublicationDistribution(publications);
        for (String type : types) {
            if (distributions.containsKey(type)) {
                System.out.printf("   - %s: %.2f%%\n", type, distributions.get(type));
            }
        }

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + String.format("%.2f%%", calculatePublicationRatioByYear(publications, "2007")));
    }
}