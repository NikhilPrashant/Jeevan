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

public class NotesActivity extends AppCompatActivity {

    private EditText itemNotes, etDeleteNotes;
    private Button addNotes, deleteNotes;
    private TextView showNotesList;
    private DatabaseReference NotesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        itemNotes = findViewById(R.id.itemNotes);
        etDeleteNotes = findViewById(R.id.etDeleteNotes);
        addNotes = findViewById(R.id.addNotes);
        deleteNotes = findViewById(R.id.deleteNotes);
        showNotesList = findViewById(R.id.showNotesList);
        NotesData = FirebaseDatabase.getInstance().getReference().child("NotesData");
        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDataActivity();
            }
        });
        deleteNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteDataActivity();
            }
        });
        NotesData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String notesList = "";
                int i = 1;
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    notesList = notesList + "  " + i++ + "- " + dataSnapshot.child("NotesList").getValue().toString()+"\n";
                }
                showNotesList.setText(notesList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void AddDataActivity() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("NotesList", itemNotes.getText().toString());

        NotesData.push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.i("notesData", "Complete ");
                itemNotes.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("notesData", "Failed "+e.toString());
            }
        });
    }
    public void DeleteDataActivity() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = databaseReference.child("NotesData").orderByChild("NotesList").equalTo(etDeleteNotes.getText().toString());

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();
                    etDeleteNotes.setText("");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}