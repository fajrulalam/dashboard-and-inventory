package com.example.dashboardandinventory;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    Query revToday;
    Query revMonth;
    Query revYear;
    TextView pendaptanKapanTextView;
    TextView nominalPendapatanTextView;
    Button dayButton;
    Button monthButton;
    Button yearButton;
    Button alltimeButton;

    ArrayList<String> makananList;
    ArrayList<String> minumanList;
    ArrayList<Integer> makananSales;
    ArrayList<Integer> makananInventory;
    ArrayList<Integer> minumanSales;
    ArrayList<Integer> minumanInventory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define
        makananList = new ArrayList<>();
        minumanList = new ArrayList<>();
        pendaptanKapanTextView = (TextView) findViewById(R.id.pendapatanKapan);
        nominalPendapatanTextView = (TextView) findViewById(R.id.nominalPendapatan);
        dayButton = findViewById(R.id.buttonDaily);
        monthButton = findViewById(R.id.buttonMonthly);
        yearButton =  findViewById(R.id.buttonYearly);
        alltimeButton = findViewById(R.id.buttonAlltime);

        reff = FirebaseDatabase.getInstance("https://point-of-sales-app-25e2b-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("TransacationDetail");
        revToday = reff.orderByChild("timeStamp").startAt(getDate()).endAt(getDate()+"\uf8ff");
        revMonth = reff.orderByChild("timeStamp").startAt(getMonth()).endAt(getMonth()+"\uf8ff");
        revYear = reff.orderByChild("timeStamp").startAt(getYear()).endAt(getYear()+"\uf8ff");

        Log.i("Tanggal", getDate());
        Log.i("Bulan", getMonth());
        Log.i("Tahun", getYear());
//        totalHariIniTextView = findViewById(R.id.TotalHariIni);
//        revToday.addListenerForSingleValueEvent(revenueCount);

        InsertMenu();

        revToday.addListenerForSingleValueEvent(revenueCount);


    }
    
    public void timeFrameButtonClick(View view) {
        Log.i(TAG, "timeFrameButtonClick: ");

        //deselect all button
//        monthButton.setBackgroundResource(R.color.buttonNotSelected);
//        yearButton.setBackgroundResource(R.color.buttonNotSelected);
//        alltimeButton.setBackgroundResource(R.color.buttonNotSelected);
//        dayButton.setBackgroundColor(Color.rgb(75, 160, 211));

        monthButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonNotSelected)));
        dayButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonNotSelected)));
        yearButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonNotSelected)));
        alltimeButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonNotSelected)));

        view.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));

        switch (view.getTag().toString()) {
            case "day":
                Log.i("Timeframe:", "Day");
//                dayButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));
                revToday.addListenerForSingleValueEvent(revenueCount);
                break;

            case "month":
                Log.i("Timeframe:", "Month");
//                monthButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));
                revMonth.addListenerForSingleValueEvent(revenueCount);
                break;
            case "year":
                Log.i("Timeframe:", "Year");
                revYear.addListenerForSingleValueEvent(revenueCount);
                break;
            case "alltime":
                Log.i("Timeframe:", "Alltime");
                reff.addListenerForSingleValueEvent(revenueCount);
                break;
        }
    }

    public void InsertMenu() {
        //Makanan
        makananList.add("Bakso"); //0
        makananList.add("Kentang G");
        makananList.add("NasBung A");
        makananList.add("NasBung B");
        makananList.add("Nasi Lauk");
        makananList.add("Popmie");
        makananList.add("Siomay"); // 7


        //Minuman
        minumanList.add("Aqua 600ml"); //0
        minumanList.add("Coca Cola");
        minumanList.add("Es Kopi Durian");
        minumanList.add("Fanta");
        minumanList.add("Frestea");
        minumanList.add("Kopi Hitam");
        minumanList.add("Milo");
        minumanList.add("Sprite");
        minumanList.add("Teh Gelas");
        minumanList.add("Teh Pucuk Harum"); //10
    }

    ValueEventListener revenueCount = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            int sum = 0;
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    Object subtotal = map.get("lineTotal");
                    int pValue = Integer.parseInt(String.valueOf(subtotal));
                    sum += pValue;
                    Log.i("Sum:", "" + sum);
                    nominalPendapatanTextView.setText("Rp." + sum);
                }
            } else {
                nominalPendapatanTextView.setText("Rp." + 0);
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

    public String getMonth() {
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        String date_full = (String) String.valueOf(timestamp);
        String month = date_full.substring(0, 7);
        return month;
    }

    public String getYear() {
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        String date_full = (String) String.valueOf(timestamp);
        String year = date_full.substring(0, 4);
        return year;
    }






}