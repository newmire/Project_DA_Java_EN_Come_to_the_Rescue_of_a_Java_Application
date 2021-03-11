package com.hemebiotech.analytics;

import java.util.List;

public class Application {
    public static void main(String args[]) throws Exception {
        AnalyticsCounter counter = new AnalyticsCounter(new ReadSymptomDataFromFile("symptoms.txt"));
        List<String> symptoms = counter.read();
        counter.compute(symptoms);
        counter.write();
    }
}
