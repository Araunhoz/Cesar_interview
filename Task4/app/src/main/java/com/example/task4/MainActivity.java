/*

Developed: Paulo Henrique Araújo Munhoz    data: 2020/04/10

*/


package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> contactsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsList = new ArrayList<>();
        contactsList.add("Ana Fernanda");
        contactsList.add("Bianca Duarte");
        contactsList.add("Carolina Ferreira");
        contactsList.add("Diana Pedrosa");
        contactsList.add("Ericka Silva");
        contactsList.add("Flavia Alessandra");
        contactsList.add("George Amorim");
        contactsList.add("Henrique Emanoel");
        contactsList.add("Ianca Suliver");
        contactsList.add("Joao Arruda");
        contactsList.add("Kelly Key");
        contactsList.add("Luan Antonio");
        contactsList.add("Mario de Aquino");
        contactsList.add("Naiana Pitzel");
        contactsList.add("Olivia Angela");
        contactsList.add("Paulo Henrique");
        contactsList.add("Queiroz Pluton");
        contactsList.add("Renata Lima");
        contactsList.add("Sarah Silva Sale");
        contactsList.add("Thiago Bruce");


        recyclerView = findViewById(R.id.reciclerView);

        recyclerAdapter = new RecyclerAdapter(contactsList);
        recyclerView.setAdapter(recyclerAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item  = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
