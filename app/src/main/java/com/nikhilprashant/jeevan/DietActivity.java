package com.nikhilprashant.jeevan;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class DietActivity extends AppCompatActivity {

    private EditText itemDiet, etDeleteDiet;
    private Button addDiet, deleteDiet;
    private TextView showDietList;
    private DatabaseReference DietData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        itemDiet = findViewById(R.id.itemDiet);
        etDeleteDiet = findViewById(R.id.etDeleteDiet);
        addDiet = findViewById(R.id.addDiet);
        deleteDiet = findViewById(R.id.deleteDiet);
        showDietList = findViewById(R.id.showDietList);
        DietData = FirebaseDatabase.getInstance().getReference().child("DietData");
        addDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDataActivity();
            }
        });
        deleteDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteDataActivity();
            }
        });
        DietData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dietList = "";
                int i = 1;
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    dietList = dietList + "  " + i++ + "- " + dataSnapshot.child("DietList").getValue().toString()+"\n";
                }
                showDietList.setText(dietList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void AddDataActivity() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("DietList", itemDiet.getText().toString());

        DietData.push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.i("dietData", "Complete ");
                itemDiet.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("dietData", "Failed "+e.toString());
            }
        });
    }
    public void DeleteDataActivity() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = databaseReference.child("DietData").orderByChild("DietList").equalTo(etDeleteDiet.getText().toString());

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();
                    etDeleteDiet.setText("");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}