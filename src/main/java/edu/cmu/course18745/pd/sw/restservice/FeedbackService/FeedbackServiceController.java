package edu.cmu.course18745.pd.sw.restservice.FeedbackService;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackServiceController {
    private final FeedbackCollector feedbackCollector = new FeedbackCollector();

    @PostMapping("/feedbacks")
    public FeedbackStatus putFeedbacks(@RequestBody FeedbackCollector.Feedback feedback) {
        feedbackCollector.add(feedback);
        return new FeedbackStatus(true);
    }

    @GetMapping("/feedbacks")
    public List<FeedbackCollector.Feedback> getFeedbacks() {
        return feedbackCollector.getFeedbacks();
    }

    record FeedbackStatus(boolean succ, Date time) {
        FeedbackStatus(boolean succ) {
            this(succ, new Date(System.currentTimeMillis()));
        }
    }
}
