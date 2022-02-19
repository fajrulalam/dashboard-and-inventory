package com.example.dashboardandinventory;

public class dump {

    //        switch (view.getTag().toString()) {
//            case "day":
//                Log.i("Timeframe:", "Day");
////                dayButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));
//                pendaptanKapanTextView.setText("Pendapatan Hari ini");
//                countRevenue(getDate());
//                String date_makanan = "";
//                for (int i = 0; i < makananList.size(); i++) {
//                    date_makanan = getDate() + "_" + makananList.get(i);
//
//
//                    fs.collection("TransactionDetail").whereEqualTo("day_itemID", date_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                Log.i(TAG, "onSuccess: " + item_string + " " + sum);
//                                doSwitchMakananSales(item_string, sum);
//                            }
//                        }
//                    });
//
//                    fs.collection("Stock").whereEqualTo("itemID", makananList.get(i)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMakananInventory(item_string, sum);
//                            }
//                        }
//                    });
//
//
//                }
//                String date_minuman = "";
//                for (int i = 0; i < minumanList.size(); i++) {
//                    date_minuman = getDate() + "_" + minumanList.get(i);
//
//
//
//                    fs.collection("TransactionDetail").whereEqualTo("day_itemID", date_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object item = map.get("itemID");
//                                Object subtotal = map.get("quantity");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMinumanSales(item_string, sum);
//
//                            }
//                        }
//                    });
//
//                    fs.collection("Stock").whereEqualTo("itemID", minumanList.get(i)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMinumanInventory(item_string, sum);
//                            }
//                        }
//
//                    });
//
//
//
//
//                }
//
//                break;
//
//            case "month":
////                monthButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.buttonSelected)));
//                pendaptanKapanTextView.setText("Pendapatan Bulan ini");
//                countRevenue(getMonth());
//               String month_makanan = "";
//                for (int i = 0; i < makananList.size(); i++) {
//                    month_makanan = getMonth() + "_" + makananList.get(i);
//
//
//                    fs.collection("TransactionDetail").whereEqualTo("month_itemID", month_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                Log.i(TAG, "onSuccess: " + item_string + " " + sum);
//                                doSwitchMakananSales(item_string, sum);
//                            }
//                        }
//                    });
//
//                    fs.collection("Stock").whereEqualTo("itemID", makananList.get(i)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMakananInventory(item_string, sum);
//                            }
//                        }
//                    });
//
//
//
//
//                }
//                String month_minuman = "";
//                for (int i = 0; i < minumanList.size(); i++) {
//                    month_minuman = getMonth() + "_" + minumanList.get(i);
//
//
//
//                    fs.collection("TransactionDetail").whereEqualTo("month_itemID", month_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object item = map.get("itemID");
//                                Object subtotal = map.get("quantity");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMinumanSales(item_string, sum);
//
//                            }
//                        }
//                    });
//
//                    fs.collection("Stock").whereEqualTo("itemID", minumanList.get(i)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMinumanInventory(item_string, sum);
//                            }
//                        }
//
//                    });
//
//
//                }
//
//                break;
//            case "year":
//                pendaptanKapanTextView.setText("Pendapatan Tahun ini");
//                countRevenue(getYear());
//
//                String year_makanan = "";
//                for (int i = 0; i < makananList.size(); i++) {
//                    year_makanan = getYear() + "_" + makananList.get(i);
//
//
//                    fs.collection("TransactionDetail").whereEqualTo("year_itemID", year_makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                Log.i(TAG, "onSuccess: " + item_string + " " + sum);
//                                doSwitchMakananSales(item_string, sum);
//                            }
//                        }
//                    });
//
//                    fs.collection("Stock").whereEqualTo("itemID", makananList.get(i)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMakananInventory(item_string, sum);
//                            }
//                        }
//                    });
//
//
//
//                }
//                String year_minuman = "";
//                for (int i = 0; i < minumanList.size(); i++) {
//                    year_minuman = getYear() + "_" + minumanList.get(i);
//
//
//
//                    fs.collection("TransactionDetail").whereEqualTo("year_itemID", year_minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object item = map.get("itemID");
//                                Object subtotal = map.get("quantity");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMinumanSales(item_string, sum);
//
//                            }
//                        }
//                    });
//
//                    fs.collection("Stock").whereEqualTo("itemID", minumanList.get(i)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMinumanInventory(item_string, sum);
//                            }
//                        }
//
//                    });
//
//                }
//                break;
//            case "alltime":
//                pendaptanKapanTextView.setText("Pendapatan All Time");
//                countRevenue("all");
//
//                String makanan = "";
//                for (int i = 0; i < makananList.size(); i++) {
//                    makanan = makananList.get(i);
//
//
//                    fs.collection("TransactionDetail").whereEqualTo("itemID", makanan).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                Log.i(TAG, "onSuccess: " + item_string + " " + sum);
//                                doSwitchMakananSales(item_string, sum);
//                            }
//                        }
//                    });
//
//                    fs.collection("Stock").whereEqualTo("itemID", makananList.get(i)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMakananInventory(item_string, sum);
//                            }
//                        }
//                    });
//
//
//
//
//                }
//                String minuman = "";
//                for (int i = 0; i < minumanList.size(); i++) {
//                    minuman =  minumanList.get(i);
//
//
//
//                    fs.collection("TransactionDetail").whereEqualTo("itemID", minuman).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object item = map.get("itemID");
//                                Object subtotal = map.get("quantity");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMinumanSales(item_string, sum);
//
//                            }
//                        }
//                    });
//
//                    fs.collection("Stock").whereEqualTo("itemID", minumanList.get(i)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Object subtotal = map.get("quantity");
//                                Object item = map.get("itemID");
//                                String item_string = item.toString();
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                doSwitchMinumanInventory(item_string, sum);
//                            }
//                        }
//
//                    });
//
//
//                }
//
//                break;
//        }
//        ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Fetching Data...");
//        progressDialog.show();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.i("Sales", makananSales.toString());
//                Log.i("Inventory", makananInventory.toString());
//                changeValue();
//                progressDialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Query is done... Swipe up to Refresh", Toast.LENGTH_SHORT).show();
//
//            }
//        }, 1500);

















    //    void GetData(final FirebaseCallback firebaseCallback, String time, ArrayList items) {
//        ArrayList<Integer> salesCallback = new ArrayList<>();
//        ArrayList<Integer> stockCallback = new ArrayList<>();
//        int size = 0;
//        while (size < items.size()) {
//            salesCallback.add(0);
//            stockCallback.add(0);
//        }
//        for (int i = 0; i < items.size(); i++) {
//            int finalI = i;
//            fs.collection("TransactionDetail").orderBy("day_itemID").startAt(time).endAt(time + "\uf8ff").whereEqualTo("itemID", items.get(i))
//                    .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                @Override
//                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                    int sum = 0;
//                    for (DocumentSnapshot snapshot : snapshotList) {
//                        Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                        Object subtotal = map.get("quantity");
//                        int pValue = Integer.parseInt(String.valueOf(subtotal));
//                        sum += pValue;
//                        salesCallback.set(finalI, sum);
//                    }
//
//                    firebaseCallback.onCallback(salesCallback);
//
//                }
//            });
//
//
//        }
//
//
//    }



    //Makanan Query
//    ValueEventListener makananQuery = new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//            String makanan_string = "";
//            if (dataSnapshot.exists()) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
//                    int i = 0;
//                    while (i < makananList.size()) {
//                        makanan_string = makananList.get(i);
//
//                        Query foodSalesQuery = reff.orderByChild("itemID").startAt(makanan_string).endAt(makanan_string + "\uf8ff");
//                        Query foodInventoryQuery = reffStock.orderByChild("itemID").startAt(makanan_string).endAt(makanan_string + "\uf8ff");
//                        Log.i("Query terisi", "makanan query");
//                        foodSalesQuery.addListenerForSingleValueEvent(makananSalesQuery);
//                        foodInventoryQuery.addListenerForSingleValueEvent(makananInventoryQuery);
//                        i++;
//                    }
//                }
//
//            }
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    };
//
//    //Makanan Sales Query
//    ValueEventListener makananSalesQuery = new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//            int sales = 0;
//            if (dataSnapshot.exists()) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
//                    Object subtotal = map.get("quantity");
//                    int pValue = Integer.parseInt(String.valueOf(subtotal));
//                    sales += pValue;
//                    makananSales.add(sales);
//                    Log.i("Query terisi", "makanan sales query");
//                }
//            } else {
//                makananSales.add(999);
//            }
//        }
//
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    };
//
//    //Makanan Stock Query
//    ValueEventListener makananInventoryQuery = new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//            int inventory = 0;
//            if (dataSnapshot.exists()) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
//                    Object subtotal = map.get("stockChange");
//                    int pValue = Integer.parseInt(String.valueOf(subtotal));
//                    inventory += pValue;
//                    makananInventory.add(inventory);
//                }
//            } else {
//                makananInventory.add(0);
//
//            }
//        }
//
//        ;
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    };
//
//    //Minuman Query
//    ValueEventListener minumanQuery = new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//            String minuman_string = "";
//            if (dataSnapshot.exists()) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
//                    int i = 0;
//                    while (i < minumanList.size()) {
//                        minuman_string = minumanList.get(i);
//                        Query drinksSalesQuery = reff.orderByChild("itemID").startAt(minuman_string).endAt(minuman_string + "\uf8ff");
//                        Query drinksInventoryQuery = reffStock.orderByChild("itemID").startAt(minuman_string).endAt(minuman_string + "\uf8ff");
//
//                        drinksSalesQuery.addListenerForSingleValueEvent(minumanSalesQuery);
//                        drinksInventoryQuery.addListenerForSingleValueEvent(minumanInventoryQuery);
//                        i++;
//                    }
//                }
//            }
//
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    };
//
//    //Minuman Sales Query
//    ValueEventListener minumanSalesQuery = new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//            int sales = 0;
//            if (dataSnapshot.exists()) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
//                    Object subtotal = map.get("quantity");
//                    int pValue = Integer.parseInt(String.valueOf(subtotal));
//                    sales += pValue;
//                    minumanSales.add(sales);
//                }
//            } else {
//                minumanSales.add(99);
//
//            }
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    };
//
//    //Minuman Inventory Query
//    ValueEventListener minumanInventoryQuery = new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//            int invetory = 0;
//            if (dataSnapshot.exists()) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
//                    Object subtotal = map.get("stockChange");
//                    int pValue = Integer.parseInt(String.valueOf(subtotal));
//                    invetory += pValue;
//                    minumanInventory.add(invetory);
//                }
//            } else {
//                minumanInventory.add(0);
//                Log.i("MIQ", "added 0 here");
//
//            }
//
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    };




//    public void countRevenue(String timeFrame) {
//
//        if (timeFrame.equals("all")) {
//            fs.collection("TransactionDetail").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                @Override
//                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                    int sum = 0;
//                    for (DocumentSnapshot snapshot : snapshotList) {
//                        Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                        Log.i("TAG", "onSuccess: " + snapshot.getData());
//                        Object subtotal = map.get("lineTotal");
//                        int pValue = Integer.parseInt(String.valueOf(subtotal));
//                        sum += pValue;
//                        nominalPendapatanTextView.setText("Rp." + sum);
//                    }
//                }
//            });
//        } else {
//            fs.collection("TransactionDetail").orderBy("timeStamp").startAt(timeFrame).endAt(timeFrame + '\uf8ff')
//                    .get()
//                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                        @Override
//                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                            List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                            int sum = 0;
//                            for (DocumentSnapshot snapshot : snapshotList) {
//                                Map<String, Object> map = (Map<String, Object>) snapshot.getData();
//                                Log.i("TAG", "onSuccess: " + snapshot.getData());
//                                Object subtotal = map.get("lineTotal");
//                                int pValue = Integer.parseInt(String.valueOf(subtotal));
//                                sum += pValue;
//                                nominalPendapatanTextView.setText("Rp." + sum);
//                            }
//                        }
//                    });
//        }
//
//    }



//    public void sterilizeValue() {
//
//        //Makanan
//        baksoSales.setText("N/A");
//        baksoStock.setText("N/A");
//        kentangSales.setText("N/A");
//        kentangStock.setText("N/A");
//        mieAyamSales.setText("N/A");
//        mieAyamStock.setText("N/A");
//        nasbungASales.setText("N/A");
//        nasbungAStock.setText("N/A");
//        nasbungBSales.setText("N/A");
//        nasbungBStock.setText("N/A");
//        nasiAyamSales.setText("N/A");
//        nasiAyamStock.setText("N/A");
//        nasiPindangSales.setText("N/A");
//        nasiPindangStock.setText("N/A");
//        nasiTelurSales.setText("N/A");
//        nasiTelurStock.setText("N/A");
//        pisangGorengSales.setText("N/A");
//        pisangGorengStock.setText("N/A");
//        popmieSales.setText("N/A");
//        popmieStock.setText("N/A");
//        serealSales.setText("N/A");
//        serealStock.setText("N/A");
//        tahuGorengSales.setText("N/A");
//        tahuGorengStock.setText("N/A");
//        siomaySales.setText("N/A");
//        siomayStock.setText("N/A");
//        sosisNagetSales.setText("N/A");
//        sosisNagetStock.setText("N/A");
//
//        //Minuman
//        aquaSales.setText("N/A");
//        aquaStock.setText("N/A");
//        cocaColaSales.setText("N/A");
//        cocaColaStock.setText("N/A");
//        esKopiDurianSales.setText("N/A");
//        esKopiDurianStock.setText("N/A");
//        tehGelasSales.setText("N/A");
//        tehGelasStock.setText("N/A");
//        fantaSales.setText("N/A");
//        fantaStock.setText("N/A");
//        floridinaSales.setText("N/A");
//        floridinaStock.setText("N/A");
//        fresteaSales.setText("N/A");
//        fresteaStock.setText("N/A");
//        isoplusSales.setText("N/A");
//        isoplusStock.setText("N/A");
//        kopiHitamSales.setText("N/A");
//        kopiHitamStock.setText("N/A");
//        miloSales.setText("N/A");
//        miloStock.setText("N/A");
//        spriteSales.setText("N/A");
//        spriteStock.setText("N/A");
//        tehPucukHarumSales.setText("N/A");
//        tehPucukHarumStock.setText("N/A");
//    }

    }
