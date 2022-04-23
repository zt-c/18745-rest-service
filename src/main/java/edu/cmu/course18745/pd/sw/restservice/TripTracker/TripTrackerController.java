package edu.cmu.course18745.pd.sw.restservice.TripTracker;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class TripTrackerController {
    private final TripTracker tripTracker = new TripTracker();

    @PostMapping("/trip-records")
    public RecordingStatus recordTrip(@RequestParam(value = "deviceId") String deviceId, @RequestBody TripTracker.TripRecord tripRecord) {
        System.out.println("Device(" + deviceId + ")" + tripRecord);
        tripTracker.put(deviceId, tripRecord);
        return new RecordingStatus(true);
    }

    @GetMapping("/trip-records")
    public ArrayList<TripTracker.RecordsPerDevice> getAllRecords() {
        return tripTracker.getJsonFormatRecords();
    }

    record RecordingStatus(boolean recorded, Date time) {
        RecordingStatus(boolean recorded) {
            this(recorded, new Date(System.currentTimeMillis()));
        }
    }
}


