package edu.cmu.course18745.pd.sw.restservice.FeedbackService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackServiceController {
    private final FeedbackCollector feedbackCollector = new FeedbackCollector();

    @PostMapping("/feedbacks")
    public void putFeedbacks(@RequestBody FeedbackCollector.Feedback feedback) {
        feedbackCollector.add(feedback);
    }

    @GetMapping("/feedbacks")
    public List<FeedbackCollector.Feedback> getFeedbacks() {
        return feedbackCollector.getFeedbacks();
    }
}
