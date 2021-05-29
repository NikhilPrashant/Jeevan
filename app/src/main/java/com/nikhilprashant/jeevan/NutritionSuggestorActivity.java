package com.nikhilprashant.jeevan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NutritionSuggestorActivity extends AppCompatActivity {

    String[] nutrients = {"Calcium", "Iron", "Magnesium", "Potassium", "Vitamin A", "Vitamin C", "Vitamin D", "Vitamin E", "Vitamin B3", "Vitamin B12", "Biotin", "Omega 3"};
    ListView lView;
    com.nikhilprashant.jeevan.ListAdapter lAdapter;
    private String userName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_suggestor);

        lView = (ListView) findViewById(R.id.list_view);

        lAdapter = new com.nikhilprashant.jeevan.ListAdapter(NutritionSuggestorActivity.this, nutrients);

        lView.setAdapter(lAdapter);

        userName = getIntent().getStringExtra("name");

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String nutrientID;
                switch(position) {
                    case 0:
                        nutrientID = nutrients[0];
                        Intent calc = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        calc.putExtra("nutriUrl", "https://www.healthline.com/nutrition/15-calcium-rich-foods");
                        calc.putExtra("nutrient", nutrientID);
                        startActivity(calc);
                        break;
                    case 1:
                        nutrientID = nutrients[1];
                        Intent iron = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        iron.putExtra("nutriUrl", "https://www.healthline.com/nutrition/healthy-iron-rich-foods#1.-Shellfish");
                        iron.putExtra("nutrient", nutrientID);
                        startActivity(iron);
                        break;
                    case 2:
                        nutrientID = nutrients[2];
                        Intent magnesium = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        magnesium.putExtra("nutriUrl", "https://www.healthline.com/nutrition/10-foods-high-in-magnesium#_noHeaderPrefixedContent");
                        magnesium.putExtra("nutrient", nutrientID);
                        startActivity(magnesium);
                        break;
                    case 3:
                        nutrientID = nutrients[3];
                        Intent pot = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        pot.putExtra("nutriUrl", "https://www.healthline.com/nutrition/high-potassium-foods");
                        pot.putExtra("nutrient", nutrientID);
                        startActivity(pot);
                        break;
                    case 4:
                        nutrientID = nutrients[4];
                        Intent vitA = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        vitA.putExtra("nutriUrl", "https://www.healthline.com/nutrition/foods-high-in-vitamin-a#TOC_TITLE_HDR_2");
                        vitA.putExtra("nutrient", nutrientID);
                        startActivity(vitA);
                        break;
                    case 5:
                        nutrientID = nutrients[5];
                        Intent vitC = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        vitC.putExtra("nutriUrl", "https://www.healthline.com/nutrition/vitamin-c-foods");
                        vitC.putExtra("nutrient", nutrientID);
                        startActivity(vitC);
                        break;
                    case 6:
                        nutrientID = nutrients[6];
                        Intent vitD = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        vitD.putExtra("nutriUrl", "https://www.healthline.com/nutrition/9-foods-high-in-vitamin-d");
                        vitD.putExtra("nutrient", nutrientID);
                        startActivity(vitD);
                        break;
                    case 7:
                        nutrientID = nutrients[7];
                        Intent vitE = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        vitE.putExtra("nutriUrl", "https://www.healthline.com/nutrition/foods-high-in-vitamin-e");
                        vitE.putExtra("nutrient", nutrientID);
                        startActivity(vitE);
                        break;
                    case 8:
                        nutrientID = nutrients[8];
                        Intent vitB3 = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        vitB3.putExtra("nutriUrl", "https://www.healthline.com/nutrition/foods-high-in-niacin");
                        vitB3.putExtra("nutrient", nutrientID);
                        startActivity(vitB3);
                        break;
                    case 9:
                        nutrientID = nutrients[9];
                        Intent vitB12 = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        vitB12.putExtra("nutriUrl", "https://www.healthline.com/nutrition/vitamin-b12-dosage");
                        vitB12.putExtra("nutrient", nutrientID);
                        startActivity(vitB12);
                        break;
                    case 10:
                        nutrientID = nutrients[10];
                        Intent biotin = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        biotin.putExtra("nutriUrl", "https://www.healthline.com/nutrition/best-biotin-supplement#1");
                        biotin.putExtra("nutrient", nutrientID);
                        startActivity(biotin);
                        break;
                    case 11:
                        nutrientID = nutrients[11];
                        Intent omega3 = new Intent(NutritionSuggestorActivity.this, com.nikhilprashant.jeevan.SixthActivity.class);
                        omega3.putExtra("nutriUrl", "https://www.healthline.com/nutrition/how-much-omega-3");
                        omega3.putExtra("nutrient", nutrientID);
                        startActivity(omega3);
                        break;
                }

//                Toast.makeText(getApplicationContext(),"You Selected "+ foodArr[position-1]+ " as Food",Toast.LENGTH_SHORT).show();
            }
        });
    }
}