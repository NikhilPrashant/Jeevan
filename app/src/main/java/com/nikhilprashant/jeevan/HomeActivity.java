package com.nikhilprashant.jeevan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    TextView tvStepCounter;
    Button button, button2, button3, button4, diet, equipments, notes, feed, camera, bike, contact, button15, button16, button17, button18, button19, button20,button21, button29;
    ImageButton menuOpen, menuClose, discover, notifications;
    CardView navigationDrawer;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvStepCounter = findViewById(R.id.tvStepCounter);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        diet = findViewById(R.id.diet);
        equipments = findViewById(R.id.equipments);
        notes = findViewById(R.id.notes);
        feed = findViewById(R.id.feed);
        camera = findViewById(R.id.camera);
        bike = findViewById(R.id.bike);
        contact = findViewById(R.id.contact);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button29 = findViewById(R.id.button29);
        menuOpen = findViewById(R.id.menuOpen);
        menuClose = findViewById(R.id.menuClose);
        discover = findViewById(R.id.discover);
        notifications = findViewById(R.id.notifications);
        navigationDrawer = findViewById(R.id.navigationDrawer);
        mFirebaseAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, StepsCounterActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WaterIntakeActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BMICalculatorActivity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NutritionSuggestorActivity.class);
                startActivity(intent);
            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DietActivity.class);
                startActivity(intent);
            }
        });
        equipments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EquipmentsActivity.class);
                startActivity(intent);
            }
        });
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feed = new Intent(HomeActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                feed.putExtra("nutriUrl", "https://www.lastminutepreparation.com/blog/categories/jeevan");
                startActivity(feed);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent(HomeActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                contact.putExtra("nutriUrl", "https://www.lastminutepreparation.com/contact-8");
                startActivity(contact);
            }
        });
        menuOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationDrawer.setVisibility(View.VISIBLE);
            }
        });
        menuClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationDrawer.setVisibility(View.INVISIBLE);
            }
        });
        discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notifications = new Intent(HomeActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                notifications.putExtra("nutriUrl", "https://www.lastminutepreparation.com/notifications-1");
                startActivity(notifications);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, StepsCounterActivity.class);
                startActivity(intent);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BMICalculatorActivity.class);
                startActivity(intent);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, WaterIntakeActivity.class);
                startActivity(intent);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NutritionSuggestorActivity.class);
                startActivity(intent);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DietActivity.class);
                startActivity(intent);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EquipmentsActivity.class);
                startActivity(intent);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirebaseAuth.signOut();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}