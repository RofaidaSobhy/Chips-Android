package com.example.day3lab2;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ChipGroup chipGroup;
    String chipChecked="";

    RecyclerView recyclerView;
    List<item> items_samsung;
    List<item> items_Apple;
    List<item> items_OPPO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);

        items_samsung=new ArrayList<item>();
        items_samsung.add(new item("samsung1",R.drawable.username));
        items_samsung.add(new item("samsung2",R.drawable.username));
        items_samsung.add(new item("samsung3",R.drawable.username));
        items_samsung.add(new item("samsung4",R.drawable.username));
        items_samsung.add(new item("samsung5",R.drawable.username));

        items_Apple=new ArrayList<item>();
        items_Apple.add(new item("Apple1",R.drawable.email));
        items_Apple.add(new item("Apple2",R.drawable.email));
        items_Apple.add(new item("Apple3",R.drawable.email));
        items_Apple.add(new item("Apple4",R.drawable.email));
        items_Apple.add(new item("Apple5",R.drawable.email));

        items_OPPO=new ArrayList<item>();
        items_OPPO.add(new item("OPPO1",R.drawable.password));
        items_OPPO.add(new item("OPPO2",R.drawable.password));
        items_OPPO.add(new item("OPPO3",R.drawable.password));
        items_OPPO.add(new item("OPPO4",R.drawable.password));
        items_OPPO.add(new item("OPPO5",R.drawable.password));

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



        chipGroup=findViewById(R.id.chipGroup);

        setUpChoiceChip();
    }

    private void setUpChoiceChip() {
        for(int i=0; i<chipGroup.getChildCount();i++){
            Chip chip =(Chip) chipGroup.getChildAt(i);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        chipChecked=chip.getText().toString();
                        //Toast.makeText(getApplicationContext(),chipChecked,Toast.LENGTH_LONG).show();
                        if(chipChecked.equals("samsung")){
                            recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items_samsung));

                        }else if(chipChecked.equals("Apple")){
                            recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items_Apple));

                        }else if(chipChecked.equals("OPPO")){
                            recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items_OPPO));

                        }
                    }
                }
            });
        }
    }
}