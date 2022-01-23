package com.example.dashboardandinventory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ArrayList barArrayList;
    String[] labels;
    TextView totalHariIniTextView;
    DatabaseReference reff;
    Query reffToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reff = FirebaseDatabase.getInstance("https://point-of-sales-app-25e2b-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("TransacationDetail");
        reffToday = reff.orderByChild("timeStamp").startAt(getDate()).endAt(getDate()+"\uf8ff");

        Log.i("Tanggal", getDate());
//        totalHariIniTextView = findViewById(R.id.TotalHariIni);
        reffToday.addListenerForSingleValueEvent(valueEventListener);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            int sum = 0;
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    TransactionDetail artist = snapshot.getValue(TransactionDetail.class);
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    Object subtotal = map.get("lineTotal");
                    int pValue = Integer.parseInt(String.valueOf(subtotal));
                    sum += pValue;
//                    totalHariIniTextView.setText("Rp." + sum);
                }
            } else {

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }

    };

    public String getDate() {
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        String date_full = (String) String.valueOf(timestamp);
        String date = date_full.substring(0, 10);
        return date;
    }


}