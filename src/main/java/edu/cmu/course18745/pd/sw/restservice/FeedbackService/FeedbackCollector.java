package edu.cmu.course18745.pd.sw.restservice.FeedbackService;

import java.util.List;
import java.util.ArrayList;

public class FeedbackCollector {
    private final List<Feedback> feedbacks = new ArrayList<>();

    void add(Feedback feedback) {
        feedbacks.add(feedback);
    }

    List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public record Feedback(boolean isTripSmooth, String reason) {
    }
}
