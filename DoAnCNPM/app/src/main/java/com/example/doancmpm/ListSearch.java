package com.example.doancmpm;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListSearch extends AppCompatActivity {
    private ListView listViewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        loadData();
    }

    private void initView() {
        listViewContact = findViewById(R.id.listViewContact);
        registerForContextMenu(listViewContact);
    }

    private void loadData() {
        DBHelperSearch databaseHelper = new DBHelperSearch(getApplicationContext());
        List<Book> contacts = databaseHelper.FindAll();
        if (contacts != null) {
            listViewContact.setAdapter(new BookAdapter(getApplicationContext(), contacts));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchView).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchContact(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchContact(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void searchContact(String keyword) {
        DBHelperSearch databaseHelper = new DBHelperSearch(getApplicationContext());
        List<Book> contacts = databaseHelper.Search(keyword);
        if (contacts != null) {
            listViewContact.setAdapter(new BookAdapter(getApplicationContext(), contacts));
        }
    }
}
