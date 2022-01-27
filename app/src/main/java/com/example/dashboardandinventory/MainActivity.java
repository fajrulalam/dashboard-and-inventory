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
import android.widget.Toast;

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
    DatabaseReference reffStock;
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

    //Table
    TextView baksoSales;
    TextView baksoStock;
    TextView kentangSales;
    TextView kentangStock;
    TextView nasbungASales;
    TextView nasbungAStock;
    TextView nasbungBSales;
    TextView nasbungBStock;
    TextView nasiLaukSales;
    TextView nasiLaukStock;
    TextView popmieSales;
    TextView popmieStock;
    TextView siomaySales;
    TextView siomayStock;

    TextView aquaSales;
    TextView aquaStock;
    TextView cocaColaSales;
    TextView cocaColaStock;
    TextView esKopiDurianSales;
    TextView esKopiDurianStock;
    TextView fantaSales;
    TextView fantaStock;
    TextView fresteaSales;
    TextView fresteaStock;
    TextView kopiHitamSales;
    TextView kopiHitamStock;
    TextView miloSales;
    TextView miloStock;
    TextView spriteSales;
    TextView spriteStock;
    TextView tehGelasSales;
    TextView tehGelasStock;
    TextView tehPucukHarumSales;
    TextView tehPucukHarumStock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define
        makananList = new ArrayList<>();
        minumanList = new ArrayList<>();
        makananInventory = new ArrayList<>();
        makananSales =  new ArrayList<>();
        minumanInventory = new ArrayList<>();
        minumanSales =  new ArrayList<>();
        pendaptanKapanTextView = (TextView) findViewById(R.id.pendapatanKapan);
        nominalPendapatanTextView = (TextView) findViewById(R.id.nominalPendapatan);
        dayButton = findViewById(R.id.buttonDaily);
        monthButton = findViewById(R.id.buttonMonthly);
        yearButton =  findViewById(R.id.buttonYearly);
        alltimeButton = findViewById(R.id.buttonAlltime);

        //Define Makanan Table
        baksoSales = findViewById(R.id.sales_1);
        baksoStock = findViewById(R.id.stock_1);

        kentangSales = findViewById(R.id.sales_2);
        kentangStock = findViewById(R.id.stock_2);

        nasbungASales = findViewById(R.id.sales_3);
        nasbungAStock = findViewById(R.id.stock_3);

        nasbungBSales = findViewById(R.id.sales_4);
        nasbungBStock = findViewById(R.id.stock_4);

        nasiLaukSales = findViewById(R.id.sales_5);
        nasiLaukStock = findViewById(R.id.stock_5);

        popmieSales = findViewById(R.id.sales_6);
        popmieStock = findViewById(R.id.stock_6);

        siomaySales = findViewById(R.id.sales_7);
        siomayStock = findViewById(R.id.stock_7);

        //Define Minuman Table

        reff = FirebaseDatabase.getInstance("https://point-of-sales-app-25e2b-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("TransacationDetail");
        reffStock = FirebaseDatabase.getInstance("https://point-of-sales-app-25e2b-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("StockCount");
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
                pendaptanKapanTextView.setText("Pendapatan Hari ini");
                revToday.addListenerForSingleValueEvent(revenueCount);
                revToday.addListenerForSingleValueEvent(makananQuery);
                revToday.addListenerForSingleValueEvent(minumanQuery);
                break;

            case "month":
//                monthButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));
                pendaptanKapanTextView.setText("Pendapatan Bulan ini");
                revMonth.addListenerForSingleValueEvent(revenueCount);
                revMonth.addListenerForSingleValueEvent(makananQuery);
                revMonth.addListenerForSingleValueEvent(minumanQuery);
                break;
            case "year":
                pendaptanKapanTextView.setText("Pendapatan Tahun ini");
                revYear.addListenerForSingleValueEvent(revenueCount);
                revYear.addListenerForSingleValueEvent(makananQuery);
                revYear.addListenerForSingleValueEvent(minumanQuery);
                break;
            case "alltime":
                pendaptanKapanTextView.setText("Pendapatan All Time");
                reff.addListenerForSingleValueEvent(revenueCount);
                reff.addListenerForSingleValueEvent(makananQuery);
                reff.addListenerForSingleValueEvent(minumanQuery);
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

        //Populate Inventory and Sales List
//        int i = 0;
//        while (i < makananList.size()) {
//            makananSales.add(0);
//            minumanInventory.add(0);
//            i++;
//        }
//        int j = 0;
//        while (j < minumanList.size()){
//            minumanInventory.add(0);
//            minumanSales.add(0);
//            j++;
//        }
    }

    //Makanan Query
    ValueEventListener makananQuery =  new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String makanan_string = "";
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    int i = 0;
                    while (i < makananList.size()) {
                        makanan_string = makananList.get(i);
                        Query foodSalesQuery = reff.startAt(makanan_string).endAt(makanan_string+"\uf8ff");
                        Query foodInventoryQuery = reffStock.startAt(makanan_string).endAt(makanan_string+"\uf8ff");

                        foodSalesQuery.addListenerForSingleValueEvent(makananSalesQuery);
                        foodInventoryQuery.addListenerForSingleValueEvent(makananInventoryQuery);
                        i++;
                    }
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    //Makanan Sales Query
    ValueEventListener makananSalesQuery = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            int sales = 0;
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    Object subtotal = map.get("quantity");
                    int pValue = Integer.parseInt(String.valueOf(subtotal));
                    sales += pValue;
                    makananSales.add(sales);
                }
            } else {

            }
        }


        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    //Makanan Stock Query
    ValueEventListener makananInventoryQuery = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            int inventory = 0;
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    Object subtotal = map.get("quantity");
                    int pValue = Integer.parseInt(String.valueOf(subtotal));
                    inventory += pValue;
                    makananInventory.add(inventory);
                }
            } else {

            }
        };

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    //Minuman Query
    ValueEventListener minumanQuery =  new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String minuman_string = "";
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    int i = 0;
                    while (i < minumanList.size()) {
                        minuman_string = makananList.get(i);
                        Query drinksSalesQuery = reff.startAt(minuman_string).endAt(minuman_string+"\uf8ff");
                        Query drinksInventoryQuery = reffStock.startAt(minuman_string).endAt(minuman_string+"\uf8ff");

                        drinksSalesQuery.addListenerForSingleValueEvent(minumanSalesQuery);
                        drinksInventoryQuery.addListenerForSingleValueEvent(minumanInventoryQuery);
                        i++;
                    }
                }
            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    //Minuman Sales Query
    ValueEventListener minumanSalesQuery =  new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            int sales = 0;
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    Object subtotal = map.get("quantity");
                    int pValue = Integer.parseInt(String.valueOf(subtotal));
                    sales += pValue;
                    minumanSales.add(sales);
                }
            } else {

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    //Minuman Inventory Query
    ValueEventListener minumanInventoryQuery = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            int invetory = 0;
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    Object subtotal = map.get("quantity");
                    int pValue = Integer.parseInt(String.valueOf(subtotal));
                    invetory += pValue;
                    minumanInventory.add(invetory);
                }
            } else {

            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    //Change Table Sales and Stock Value

    public void changeValue() {


    }



    //Total Revenue
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