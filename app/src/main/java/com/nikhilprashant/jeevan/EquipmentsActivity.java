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

public class EquipmentsActivity extends AppCompatActivity {

    private EditText itemEquipments, etDeleteEquipments;
    private Button addEquipments, deleteEquipments;
    private TextView showEquipmentsList;
    private DatabaseReference EquipmentsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipments);
        itemEquipments = findViewById(R.id.itemEquipments);
        etDeleteEquipments = findViewById(R.id.etDeleteEquipments);
        addEquipments = findViewById(R.id.addEquipments);
        deleteEquipments = findViewById(R.id.deleteEquipments);
        showEquipmentsList = findViewById(R.id.showEquipmentsList);
        EquipmentsData = FirebaseDatabase.getInstance().getReference().child("EquipmentsData");
        addEquipments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDataActivity();
            }
        });
        deleteEquipments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteDataActivity();
            }
        });
        EquipmentsData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String equipmentsList = "";
                int i = 1;
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    equipmentsList = equipmentsList + "  " + i++ + "- " + dataSnapshot.child("EquipmentsList").getValue().toString()+"\n";
                }
                showEquipmentsList.setText(equipmentsList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void AddDataActivity() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("EquipmentsList", itemEquipments.getText().toString());

        EquipmentsData.push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.i("equipmentsData", "Complete ");
                itemEquipments.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("equipmentsData", "Failed "+e.toString());
            }
        });
    }
    public void DeleteDataActivity() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = databaseReference.child("EquipmentsData").orderByChild("EquipmentsList").equalTo(etDeleteEquipments.getText().toString());

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();
                    etDeleteEquipments.setText("");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}