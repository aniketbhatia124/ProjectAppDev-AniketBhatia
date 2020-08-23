package com.example.android.homedesignar;

import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;


class FireBaseUpdate {


    interface CloudAnchorIdListener {
        void onCloudAnchorIdAvailable(String cloudAnchorId);

    }

    interface ShortCodeListener {
        void onShortCodeAvailable(Integer shortCode);
    }


    private static final String TAG = FireBaseUpdate.class.getName();
    private static final String KEY = "Shared Anchor and Model";
    private static final String KEY_PREFIX = "anchor-";
    private static final int INITIAL_SHORT_CODE = 0;
    private final DatabaseReference Ref;

    FireBaseUpdate(Context context) {
        FirebaseApp firebaseApp = FirebaseApp.initializeApp(context);
        Ref = FirebaseDatabase.getInstance(firebaseApp).getReference().child(KEY);
        DatabaseReference.goOnline();
    }


    void nextShortCode(ShortCodeListener listener) {

               Ref
                .child("nextshortcode and selected model")
                .runTransaction(
                        new Transaction.Handler() {
                            @Override
                            public Transaction.Result doTransaction(MutableData currentData) {
                                Integer shortCode = currentData.getValue(Integer.class);
                                if (shortCode == null) {
                                    shortCode = INITIAL_SHORT_CODE - 1;
                                }
                                currentData.setValue(shortCode + 1);
                                return Transaction.success(currentData);
                            }

                            @Override
                            public void onComplete(
                                    DatabaseError error, boolean committed, DataSnapshot currentData) {
                                if (!committed) {
                                    Log.e(TAG, "Firebase Error", error.toException());
                                    listener.onShortCodeAvailable(null);
                                } else {
                                    listener.onShortCodeAvailable(currentData.getValue(Integer.class));
                                }
                            }
                        });
    }


    void storeUsingShortCode(int shortCode, String cloudAnchorId) {
        Ref.child(KEY_PREFIX + shortCode).setValue(cloudAnchorId);

    }



    void getCloudAnchorID(int shortCode, CloudAnchorIdListener listener) {
               Ref
                .child(KEY_PREFIX + shortCode)
                .addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                listener.onCloudAnchorIdAvailable(String.valueOf(dataSnapshot.getValue()));

                            }

                            @Override
                            public void onCancelled(DatabaseError error) {
                                Log.e(TAG, "The database operation for getCloudAnchorID was cancelled.",
                                        error.toException());
                                listener.onCloudAnchorIdAvailable(null);
                            }
                        });
    }
}