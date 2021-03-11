package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter {
    private TreeMap<String, Integer> map;
    private final ISymptomReader reader;

    public AnalyticsCounter(ISymptomReader reader) {
        this.reader = reader;
        this.map = new TreeMap<>();

    }

    public List<String> read() {
        return reader.getSymptoms();
    }

    public void compute(List<String> symptoms) {
        for (String symptom : symptoms) {
            Integer occurence = this.map.get(symptom);
            if (occurence == null) {
                this.map.put(symptom, 1);
            } else {
                occurence = occurence + 1;
                this.map.put(symptom, occurence);
            }
        }
    }

    public void write() throws IOException {
        String text = this.map.entrySet().stream().map(e -> e.getKey()+" : "+e.getValue()).reduce((a,b)->a+"\n"+b).orElse("");
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
        writer.write(text);
        writer.close();

    }
}
