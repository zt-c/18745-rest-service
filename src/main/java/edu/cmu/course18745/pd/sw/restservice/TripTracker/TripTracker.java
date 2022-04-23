package edu.cmu.course18745.pd.sw.restservice.TripTracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class TripTracker {
    private final Map<String, ArrayList<TripRecord>> records = new HashMap<>();

    void put(String deviceId, TripRecord tripRecord) {
        if (!records.containsKey(deviceId)) records.put(deviceId, new ArrayList<>());
        records.get(deviceId).add(tripRecord);
    }

    ArrayList<RecordsPerDevice> getJsonFormatRecords() {
        ArrayList<RecordsPerDevice> res = new ArrayList<>();
        records.forEach((deviceId, records) -> {
            res.add(new RecordsPerDevice(deviceId, records));
        });
        return res;
    }

    record RecordsPerDevice(String deviceId, ArrayList<TripRecord> records) {
    }

    record TripRecord(Date time, String action) {
        @Override
        public String toString() {
            return " " + action + " @ " + time;
        }
    }
}
