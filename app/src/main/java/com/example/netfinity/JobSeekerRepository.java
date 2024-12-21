package com.example.netfinity;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.List;

public class JobSeekerRepository {

    private final DatabaseReference databaseReference;

    public JobSeekerRepository() {
        // Initialize the database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("jobSeekers");
    }

    // Store Job Seeker data
    public void addJobSeeker(JobSeeker jobSeeker) {
        String jobSeekerId = databaseReference.push().getKey(); // Generate unique ID
        if (jobSeekerId != null) {
            databaseReference.child(jobSeekerId).setValue(jobSeeker)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Log.d("Firebase", "Job seeker added successfully");
                        } else {
                            Log.e("Firebase", "Error adding job seeker", task.getException());
                        }
                    });
        }
    }

    // Retrieve Job Seeker data
    public void getJobSeekers(ValueEventListener listener) {
        databaseReference.addValueEventListener(listener);
    }
}
