package com.example.dashboardandinventory;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
    Query revMakananSales;
    Query revMakananStock;
    Query revMinumanSales;
    Query revMinumanStock;
    TextView pendaptanKapanTextView;
    TextView nominalPendapatanTextView;
    Button dayButton;
    Button monthButton;
    Button yearButton;
    Button alltimeButton;

    FirebaseFirestore fs;

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
    TextView mieAyamSales;
    TextView mieAyamStock;
    TextView nasiAyamSales;
    TextView nasiAyamStock;
    TextView nasiPindangSales;
    TextView nasiPindangStock;
    TextView nasiTelurSales;
    TextView nasiTelurStock;
    TextView pisangGorengSales;
    TextView pisangGorengStock;
    TextView serealSales;
    TextView serealStock;
    TextView tahuGorengSales;
    TextView tahuGorengStock;
    TextView sosisNagetSales;
    TextView sosisNagetStock;



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
    TextView floridinaSales;
    TextView floridinaStock;
    TextView isoplusSales;
    TextView isoplusStock;

    public void stockUpdate(View view){



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fs = FirebaseFirestore.getInstance();

        //Define
        makananList = new ArrayList<>();
        minumanList = new ArrayList<>();
        makananInventory = new ArrayList<>();
        makananSales = new ArrayList<>();
        minumanInventory = new ArrayList<>();
        minumanSales = new ArrayList<>();
        pendaptanKapanTextView = (TextView) findViewById(R.id.pendapatanKapan);
        nominalPendapatanTextView = (TextView) findViewById(R.id.nominalPendapatan);
        dayButton = findViewById(R.id.buttonDaily);
        monthButton = findViewById(R.id.buttonMonthly);
        yearButton = findViewById(R.id.buttonYearly);
        alltimeButton = findViewById(R.id.buttonAlltime);

        //Define Makanan Table
        baksoSales = findViewById(R.id.sales_1);
        baksoStock = findViewById(R.id.stock_1);
        kentangSales = findViewById(R.id.sales_2);
        kentangStock = findViewById(R.id.stock_2);
        mieAyamSales = findViewById(R.id.sales_3);
        mieAyamStock = findViewById(R.id.stock_4);
        nasbungASales = findViewById(R.id.sales_4);
        nasbungAStock = findViewById(R.id.stock_4);
        nasbungBSales = findViewById(R.id.sales_5);
        nasbungBStock = findViewById(R.id.stock_5);
        nasiAyamSales = findViewById(R.id.sales_6);
        nasiAyamStock = findViewById(R.id.stock_6);
        nasiPindangSales = findViewById(R.id.sales_7);
        nasiPindangStock = findViewById(R.id.stock_7);
        nasiTelurSales = findViewById(R.id.sales_8);
        nasiTelurStock = findViewById(R.id.stock_8);
        pisangGorengSales = findViewById(R.id.sales_9);
        pisangGorengStock = findViewById(R.id.stock_9);
        popmieSales = findViewById(R.id.sales_10);
        popmieStock = findViewById(R.id.stock_10);
        serealSales = findViewById(R.id.sales_11);
        serealStock = findViewById(R.id.stock_11);
        tahuGorengSales = findViewById(R.id.sales_12);
        tahuGorengStock = findViewById(R.id.stock_12);
        siomaySales = findViewById(R.id.sales_13);
        siomayStock = findViewById(R.id.stock_13);
        sosisNagetSales = findViewById(R.id.sales_14);
        sosisNagetStock = findViewById(R.id.stock_14);

        //Define Minuman Table
        aquaSales = findViewById(R.id.sales2_1);
        aquaStock = findViewById(R.id.stock2_1);
        cocaColaSales = findViewById(R.id.sales2_2);
        cocaColaStock = findViewById(R.id.stock2_2);
        esKopiDurianSales = findViewById(R.id.sales2_3);
        esKopiDurianStock = findViewById(R.id.stock2_3);
        tehGelasSales = findViewById(R.id.sales2_4);
        tehGelasStock = findViewById(R.id.stock2_4);
        fantaSales = findViewById(R.id.sales2_5);
        fantaStock = findViewById(R.id.stock2_5);
        floridinaSales = findViewById(R.id.sales2_6);
        floridinaStock = findViewById(R.id.stock2_6);
        fresteaSales = findViewById(R.id.sales2_7);
        fresteaStock = findViewById(R.id.stock2_7);
        isoplusSales = findViewById(R.id.sales2_8);
        isoplusStock = findViewById(R.id.stock2_8);
        kopiHitamSales = findViewById(R.id.sales2_9);
        kopiHitamStock = findViewById(R.id.stock2_9);
        miloSales = findViewById(R.id.sales2_10);
        miloStock = findViewById(R.id.stock2_10);
        spriteSales = findViewById(R.id.sales2_11);
        spriteStock = findViewById(R.id.stock2_11);
        tehPucukHarumSales = findViewById(R.id.sales2_12);
        tehPucukHarumStock = findViewById(R.id.stock2_12);


        reff = FirebaseDatabase.getInstance("https://point-of-sales-app-25e2b-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("TransacationDetail");
        reffStock = FirebaseDatabase.getInstance("https://point-of-sales-app-25e2b-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("StockCount");
        revToday = reff.orderByChild("timeStamp").startAt(getDate()).endAt(getDate() + "\uf8ff");
        revMonth = reff.orderByChild("timeStamp").startAt(getMonth()).endAt(getMonth() + "\uf8ff");
        revYear = reff.orderByChild("timeStamp").startAt(getYear()).endAt(getYear() + "\uf8ff");



//        totalHariIniTextView = findViewById(R.id.TotalHariIni);
//        revToday.addListenerForSingleValueEvent(revenueCount);

        InsertMenu();
        resetData();


        countRevenue(getDate());
        String date_makanan = "";
        for (int i = 0; i < makananList.size(); i++) {
            date_makanan = getDate() + "_" + makananList.get(i);


            fs.collection("TransactionDetail").whereEqualTo("day_itemID", date_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                    int sum = 0;
                    for (DocumentSnapshot snapshot : snapshotList) {
                        Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                        Object subtotal = map.get("quantity");
                        Object item = map.get("itemID");
                        String item_string = item.toString();
                        int pValue = Integer.parseInt(String.valueOf(subtotal));
                        sum += pValue;
                        Log.i(TAG, "onSuccess: " + item_string + " " + sum);
                        doSwitchMakananSales(item_string, sum);
                    }
                }
            });

            fs.collection("Stock").whereEqualTo("day_itemID", date_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                    int sum = 0;
                    for (DocumentSnapshot snapshot : snapshotList) {
                        Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                        Object subtotal = map.get("quantity");
                        Object item = map.get("itemID");
                        String item_string = item.toString();
                        int pValue = Integer.parseInt(String.valueOf(subtotal));
                        sum += pValue;
                        doSwitchMakananInventory(item_string, sum);
                    }
                }
            });


        }
        String date_minuman = "";
        for (int i = 0; i < minumanList.size(); i++) {
            date_minuman = getDate() + "_" + minumanList.get(i);



            fs.collection("TransactionDetail").whereEqualTo("day_itemID", date_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                    int sum = 0;
                    for (DocumentSnapshot snapshot : snapshotList) {
                        Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                        Object item = map.get("itemID");
                        Object subtotal = map.get("quantity");
                        String item_string = item.toString();
                        int pValue = Integer.parseInt(String.valueOf(subtotal));
                        sum += pValue;
                        doSwitchMinumanSales(item_string, sum);

                    }
                }
            });

            fs.collection("Stock").whereEqualTo("day_itemID", date_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                    int sum = 0;
                    for (DocumentSnapshot snapshot : snapshotList) {
                        Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                        Object subtotal = map.get("quantity");
                        Object item = map.get("itemID");
                        String item_string = item.toString();
                        int pValue = Integer.parseInt(String.valueOf(subtotal));
                        sum += pValue;
                        doSwitchMinumanInventory(item_string, sum);
                    }
                }

            });
        }


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
//        makananSales.clear();
//        makananInventory.clear();
//        minumanInventory.clear();
//        minumanSales.clear();

        view.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));
        resetData();
//        makananSales.clear();
//        makananInventory.clear();
//        minumanInventory.clear();
//        minumanSales.clear();


        switch (view.getTag().toString()) {
            case "day":
                Log.i("Timeframe:", "Day");
//                dayButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));
                pendaptanKapanTextView.setText("Pendapatan Hari ini");
                countRevenue(getDate());
                String date_makanan = "";
                for (int i = 0; i < makananList.size(); i++) {
                    date_makanan = getDate() + "_" + makananList.get(i);


                    fs.collection("TransactionDetail").whereEqualTo("day_itemID", date_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                Log.i(TAG, "onSuccess: " + item_string + " " + sum);
                                doSwitchMakananSales(item_string, sum);
                            }
                        }
                    });

                    fs.collection("Stock").whereEqualTo("day_itemID", date_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMakananInventory(item_string, sum);
                            }
                        }
                    });


                }
                String date_minuman = "";
                for (int i = 0; i < minumanList.size(); i++) {
                    date_minuman = getDate() + "_" + minumanList.get(i);



                    fs.collection("TransactionDetail").whereEqualTo("day_itemID", date_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object item = map.get("itemID");
                                Object subtotal = map.get("quantity");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMinumanSales(item_string, sum);

                            }
                        }
                    });

                    fs.collection("Stock").whereEqualTo("day_itemID", date_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMinumanInventory(item_string, sum);
                            }
                        }

                    });
                }

                break;

            case "month":
//                monthButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));
                pendaptanKapanTextView.setText("Pendapatan Bulan ini");
                countRevenue(getMonth());
               String month_makanan = "";
                for (int i = 0; i < makananList.size(); i++) {
                    month_makanan = getMonth() + "_" + makananList.get(i);


                    fs.collection("TransactionDetail").whereEqualTo("month_itemID", month_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                Log.i(TAG, "onSuccess: " + item_string + " " + sum);
                                doSwitchMakananSales(item_string, sum);
                            }
                        }
                    });

                    fs.collection("Stock").whereEqualTo("month_itemID", month_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMakananInventory(item_string, sum);
                            }
                        }
                    });


                }
                String month_minuman = "";
                for (int i = 0; i < minumanList.size(); i++) {
                    month_minuman = getMonth() + "_" + minumanList.get(i);



                    fs.collection("TransactionDetail").whereEqualTo("month_itemID", month_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object item = map.get("itemID");
                                Object subtotal = map.get("quantity");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMinumanSales(item_string, sum);

                            }
                        }
                    });

                    fs.collection("Stock").whereEqualTo("month_itemID", month_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMinumanInventory(item_string, sum);
                            }
                        }

                    });
                }

                break;
            case "year":
                pendaptanKapanTextView.setText("Pendapatan Tahun ini");
                countRevenue(getYear());

                String year_makanan = "";
                for (int i = 0; i < makananList.size(); i++) {
                    year_makanan = getYear() + "_" + makananList.get(i);


                    fs.collection("TransactionDetail").whereEqualTo("year_itemID", year_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                Log.i(TAG, "onSuccess: " + item_string + " " + sum);
                                doSwitchMakananSales(item_string, sum);
                            }
                        }
                    });

                    fs.collection("Stock").whereEqualTo("year_itemID", year_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMakananInventory(item_string, sum);
                            }
                        }
                    });


                }
                String year_minuman = "";
                for (int i = 0; i < minumanList.size(); i++) {
                    year_minuman = getYear() + "_" + minumanList.get(i);



                    fs.collection("TransactionDetail").whereEqualTo("year_itemID", year_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object item = map.get("itemID");
                                Object subtotal = map.get("quantity");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMinumanSales(item_string, sum);

                            }
                        }
                    });

                    fs.collection("Stock").whereEqualTo("year_itemID", year_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMinumanInventory(item_string, sum);
                            }
                        }

                    });
                }
                break;
            case "alltime":
                pendaptanKapanTextView.setText("Pendapatan All Time");
                countRevenue("all");

                String makanan = "";
                for (int i = 0; i < makananList.size(); i++) {
                    makanan = makananList.get(i);


                    fs.collection("TransactionDetail").whereEqualTo("itemID", makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                Log.i(TAG, "onSuccess: " + item_string + " " + sum);
                                doSwitchMakananSales(item_string, sum);
                            }
                        }
                    });

                    fs.collection("Stock").whereEqualTo("itemID", makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMakananInventory(item_string, sum);
                            }
                        }
                    });


                }
                String minuman = "";
                for (int i = 0; i < minumanList.size(); i++) {
                    minuman =  minumanList.get(i);



                    fs.collection("TransactionDetail").whereEqualTo("itemID", minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object item = map.get("itemID");
                                Object subtotal = map.get("quantity");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMinumanSales(item_string, sum);

                            }
                        }
                    });

                    fs.collection("Stock").whereEqualTo("itemID", minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Object subtotal = map.get("quantity");
                                Object item = map.get("itemID");
                                String item_string = item.toString();
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                doSwitchMinumanInventory(item_string, sum);
                            }
                        }

                    });
                }

                break;
        }
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("Sales", makananSales.toString());
                Log.i("Inventory", makananInventory.toString());
                changeValue();
                progressDialog.dismiss();

            }
        }, 1500);


        Toast.makeText(this, "Query is done... did it work?", Toast.LENGTH_SHORT).show();
    }

    void GetData(final FirebaseCallback firebaseCallback, String time, ArrayList items) {
        ArrayList<Integer> salesCallback = new ArrayList<>();
        ArrayList<Integer> stockCallback = new ArrayList<>();
        int size = 0;
        while (size < items.size()) {
            salesCallback.add(0);
            stockCallback.add(0);
        }
        for (int i = 0; i < items.size(); i++) {
            int finalI = i;
            fs.collection("TransactionDetail").orderBy("day_itemID").startAt(time).endAt(time + "\uf8ff").whereEqualTo("itemID", items.get(i))
                    .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                    int sum = 0;
                    for (DocumentSnapshot snapshot : snapshotList) {
                        Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                        Object subtotal = map.get("quantity");
                        int pValue = Integer.parseInt(String.valueOf(subtotal));
                        sum += pValue;
                        salesCallback.set(finalI, sum);
                    }

                    firebaseCallback.onCallback(salesCallback);

                }
            });


        }


    }

    interface FirebaseCallback {
        void onCallback(ArrayList sales);
    }


    public void InsertMenu() {
        //Makanan
        makananList.add("Bakso"); //0
        makananList.add("Kentang G");
        makananList.add("Mie Ayam");
        makananList.add("NasBung A");
        makananList.add("NasBung B");
        makananList.add("Nasi Ayam");
        makananList.add("Nasi Pindang"); // 7
        makananList.add("Nasi Telur");
        makananList.add("Pisang G");
        makananList.add("Popmie");
        makananList.add("Sereal");
        makananList.add("Tahu G");
        makananList.add("Siomay");
        makananList.add("Sosis Naget"); //14


        //Minuman
        minumanList.add("Aqua 600ml"); //0
        minumanList.add("Coca Cola");
        minumanList.add("Es Kopi Durian");
        minumanList.add("Es Teh");
        minumanList.add("Fanta");
        minumanList.add("Floridina");
        minumanList.add("Frestea"); //7
        minumanList.add("Isoplus");
        minumanList.add("Kopi Hitam");
        minumanList.add("Milo");
        minumanList.add("Sprite");
        minumanList.add("Teh Pucuk Harum"); //12



        Log.i("Menu:", "Has been successfully inserted");


    }

    //Reset the Sales and Inventory
    public void resetData() {
        //Populate Inventory and Sales List with 0's
        makananSales.clear();
        makananInventory.clear();
        minumanInventory.clear();
        minumanSales.clear();
        int i = 0;
        while (i < makananList.size()) {
            makananSales.add(0);
            makananInventory.add(0);
            i++;
        }
        int j = 0;
        while (j < minumanList.size()) {
            minumanInventory.add(0);
            minumanSales.add(0);
            j++;
        }
    }

    //Makanan Query
    ValueEventListener makananQuery = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String makanan_string = "";
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    int i = 0;
                    while (i < makananList.size()) {
                        makanan_string = makananList.get(i);

                        Query foodSalesQuery = reff.orderByChild("itemID").startAt(makanan_string).endAt(makanan_string + "\uf8ff");
                        Query foodInventoryQuery = reffStock.orderByChild("itemID").startAt(makanan_string).endAt(makanan_string + "\uf8ff");
                        Log.i("Query terisi", "makanan query");
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
                    Log.i("Query terisi", "makanan sales query");
                }
            } else {
                makananSales.add(999);
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
                    Object subtotal = map.get("stockChange");
                    int pValue = Integer.parseInt(String.valueOf(subtotal));
                    inventory += pValue;
                    makananInventory.add(inventory);
                }
            } else {
                makananInventory.add(0);

            }
        }

        ;

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    //Minuman Query
    ValueEventListener minumanQuery = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String minuman_string = "";
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    int i = 0;
                    while (i < minumanList.size()) {
                        minuman_string = minumanList.get(i);
                        Query drinksSalesQuery = reff.orderByChild("itemID").startAt(minuman_string).endAt(minuman_string + "\uf8ff");
                        Query drinksInventoryQuery = reffStock.orderByChild("itemID").startAt(minuman_string).endAt(minuman_string + "\uf8ff");

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
    ValueEventListener minumanSalesQuery = new ValueEventListener() {
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
                minumanSales.add(99);

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
                    Object subtotal = map.get("stockChange");
                    int pValue = Integer.parseInt(String.valueOf(subtotal));
                    invetory += pValue;
                    minumanInventory.add(invetory);
                }
            } else {
                minumanInventory.add(0);
                Log.i("MIQ", "added 0 here");

            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    //Change Table Sales and Stock Value

    public void changeValue() {

        //Makanan
        baksoSales.setText(String.valueOf(makananSales.get(0)));
        baksoStock.setText(String.valueOf(makananInventory.get(0)));
        kentangSales.setText(String.valueOf(makananSales.get(1)));
        kentangStock.setText(String.valueOf(makananInventory.get(1)));
        mieAyamSales.setText(String.valueOf(makananSales.get(2)));
        mieAyamStock.setText(String.valueOf(makananInventory.get(2)));
        nasbungASales.setText(String.valueOf(makananSales.get(3)));
        nasbungAStock.setText(String.valueOf(makananInventory.get(3)));
        nasbungBSales.setText(String.valueOf(makananSales.get(4)));
        nasbungBStock.setText(String.valueOf(makananInventory.get(4)));
        nasiAyamSales.setText(String.valueOf(makananSales.get(5)));
        nasiAyamStock.setText(String.valueOf(makananInventory.get(5)));
        nasiPindangSales.setText(String.valueOf(makananSales.get(6)));
        nasiPindangStock.setText(String.valueOf(makananInventory.get(6)));
        nasiTelurSales.setText(String.valueOf(makananSales.get(7)));
        nasiTelurStock.setText(String.valueOf(makananInventory.get(7)));
        pisangGorengSales.setText(String.valueOf(makananSales.get(8)));
        pisangGorengStock.setText(String.valueOf(makananInventory.get(8)));
        popmieSales.setText(String.valueOf(makananSales.get(9)));
        popmieStock.setText(String.valueOf(makananInventory.get(9)));
        serealSales.setText(String.valueOf(makananSales.get(10)));
        serealStock.setText(String.valueOf(makananInventory.get(10)));
        tahuGorengSales.setText(String.valueOf(makananSales.get(11)));
        tahuGorengStock.setText(String.valueOf(makananInventory.get(11)));
        siomaySales.setText(String.valueOf(makananSales.get(12)));
        siomayStock.setText(String.valueOf(makananInventory.get(12)));
        sosisNagetSales.setText(String.valueOf(makananSales.get(13)));
        sosisNagetStock.setText(String.valueOf(makananInventory.get(13)));

        //Minuman
        aquaSales.setText(String.valueOf(minumanSales.get(0)));
        aquaStock.setText(String.valueOf(minumanInventory.get(0)));
        cocaColaSales.setText(String.valueOf(minumanSales.get(1)));
        cocaColaStock.setText(String.valueOf(minumanInventory.get(1)));
        esKopiDurianSales.setText(String.valueOf(minumanSales.get(2)));
        esKopiDurianStock.setText(String.valueOf(minumanInventory.get(2)));
        tehGelasSales.setText(String.valueOf(minumanSales.get(3)));
        tehGelasStock.setText(String.valueOf(minumanInventory.get(3)));
        fantaSales.setText(String.valueOf(minumanSales.get(4)));
        fantaStock.setText(String.valueOf(minumanInventory.get(4)));
        floridinaSales.setText(String.valueOf(minumanSales.get(5)));
        floridinaStock.setText(String.valueOf(minumanInventory.get(5)));
        fresteaSales.setText(String.valueOf(minumanSales.get(6)));
        fresteaStock.setText(String.valueOf(minumanInventory.get(6)));
        isoplusSales.setText(String.valueOf(minumanSales.get(7)));
        isoplusStock.setText(String.valueOf(minumanInventory.get(7)));
        kopiHitamSales.setText(String.valueOf(minumanSales.get(8)));
        kopiHitamStock.setText(String.valueOf(minumanInventory.get(8)));
        miloSales.setText(String.valueOf(minumanSales.get(9)));
        miloStock.setText(String.valueOf(minumanInventory.get(9)));
        spriteSales.setText(String.valueOf(minumanSales.get(10)));
        spriteStock.setText(String.valueOf(minumanInventory.get(10)));
        tehPucukHarumSales.setText(String.valueOf(minumanSales.get(11)));
        tehPucukHarumStock.setText(String.valueOf(minumanInventory.get(11)));


    }

    public void countRevenue(String timeFrame) {

        if (timeFrame.equals("all")) {
            fs.collection("TransactionDetail").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                    int sum = 0;
                    for (DocumentSnapshot snapshot : snapshotList) {
                        Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                        Log.i("TAG", "onSuccess: " + snapshot.getData());
                        Object subtotal = map.get("lineTotal");
                        int pValue = Integer.parseInt(String.valueOf(subtotal));
                        sum += pValue;
                        nominalPendapatanTextView.setText("Rp." + sum);
                    }
                }
            });
        } else {
            fs.collection("TransactionDetail").orderBy("timeStamp").startAt(timeFrame).endAt(timeFrame + '\uf8ff')
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                            int sum = 0;
                            for (DocumentSnapshot snapshot : snapshotList) {
                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
                                Log.i("TAG", "onSuccess: " + snapshot.getData());
                                Object subtotal = map.get("lineTotal");
                                int pValue = Integer.parseInt(String.valueOf(subtotal));
                                sum += pValue;
                                nominalPendapatanTextView.setText("Rp." + sum);
                            }
                        }
                    });
        }

    }



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

    public void doSwitchMakananSales(String item, int sum) {
        switch (item) {
            case "Bakso":
                makananSales.set(0, sum);
                break;
            case "Kentang G":
                makananSales.set(1, sum);
                break;
            case "Mie Ayam":
                makananSales.set(2, sum);
                break;
            case "NasBung A":
                makananSales.set(3, sum);
                break;
            case "NasBung B":
                makananSales.set(4, sum);
                break;
            case "Nasi Ayam":
                makananSales.set(5, sum);
                break;
            case "Nasi Pindang":
                makananSales.set(6, sum);
                break;
            case "Nasi Telur":
                makananSales.set(7, sum);
                break;
            case "Pisang G":
                makananSales.set(8, sum);
                break;
            case "Popmie":
                makananSales.set(9, sum);
                break;
            case "Sereal":
                makananSales.set(10, sum);
                break;
            case "Tahu G":
                makananSales.set(11, sum);
                break;
            case "Siomay":
                makananSales.set(12, sum);
                break;
            case "Sosis Naget":
                makananSales.set(13, sum);
                break;
        }


    }

    public void doSwitchMakananInventory(String item, int sum) {
        switch (item) {
            case "Bakso":
                makananInventory.set(0, sum);
                break;
            case "Kentang G":
                makananInventory.set(1, sum);
                break;
            case "Mie Ayam":
                makananInventory.set(2, sum);
                break;
            case "NasBung A":
                makananInventory.set(3, sum);
                break;
            case "NasBung B":
                makananInventory.set(4, sum);
                break;
            case "Nasi Ayam":
                makananInventory.set(5, sum);
                break;
            case "Nasi Pindang":
                makananInventory.set(6, sum);
                break;
            case "Nasi Telur":
                makananInventory.set(7, sum);
                break;
            case "Pisang G":
                makananInventory.set(8, sum);
                break;
            case "Popmie":
                makananInventory.set(9, sum);
                break;
            case "Sereal":
                makananInventory.set(10, sum);
                break;
            case "Tahu G":
                makananInventory.set(11, sum);
                break;
            case "Siomay":
                makananInventory.set(12, sum);
                break;
            case "Sosis Naget":
                makananInventory.set(13, sum);
                break;
        }
    }

    public void doSwitchMinumanSales(String item, int sum) {
        switch (item){
            case "Aqua 600ml":
                minumanSales.set(0, sum);
                break;
            case "Coca Cola":
                minumanSales.set(1, sum);
                break;
            case "Es Kopi Durian":
                minumanSales.set(2, sum);
                break;
            case "Es Teh":
                minumanSales.set(3, sum);
                break;
            case "Fanta":
                minumanSales.set(4, sum);
                break;
            case "Floridina":
                minumanSales.set(5, sum);
            case "Frestea":
                minumanSales.set(6, sum);
                break;
            case "Isoplus":
                minumanSales.set(7, sum);
                break;
            case "Kopi Hitam":
                minumanSales.set(8, sum);
                break;
            case "Milo":
                minumanSales.set(9, sum);
                break;
            case "Sprite":
                minumanSales.set(10, sum);
                break;
            case "Teh Pucuk Harum":
                minumanSales.set(11, sum);
                break;
        }
    }

    public void doSwitchMinumanInventory(String item, int sum) {
        switch (item){
            case "Aqua 600ml":
                minumanInventory.set(0, sum);
                break;
            case "Coca Cola":
                minumanInventory.set(1, sum);
                break;
            case "Es Kopi Durian":
                minumanInventory.set(2, sum);
                break;
            case "Es Teh":
                minumanInventory.set(3, sum);
            case "Fanta":
                minumanInventory.set(4, sum);
                break;
            case "Floridina":
                minumanInventory.set(5, sum);
            case "Frestea":
                minumanInventory.set(6, sum);
                break;
            case "Isoplus":
                minumanInventory.set(7, sum);
                break;
            case "Kopi Hitam":
                minumanInventory.set(8, sum);
                break;
            case "Milo":
                minumanInventory.set(9, sum);
                break;
            case "Sprite":
                minumanInventory.set(10, sum);
                break;
            case "Teh Pucuk Harum":
                minumanInventory.set(11, sum);
                break;
        }
    }
}