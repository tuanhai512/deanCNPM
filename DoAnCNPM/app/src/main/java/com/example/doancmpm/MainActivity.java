package com.example.doancmpm;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   private ListView lvBook;
   private BookAdapter bookAdapter;
   private List<Book> mbook;
   private DBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvBook = (ListView) findViewById(R.id.lstDS);
        mDBHelper = new DBHelper(getApplicationContext());

       //Book newBook = new Book("DayLaTen");
      // mDBHelper.ThemSach(newBook);
        mbook = mDBHelper.LayTatCaSach();
        bookAdapter = new BookAdapter(getApplicationContext(),mbook);
        lvBook.setAdapter(bookAdapter);

        lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Click "+ position,Toast.LENGTH_SHORT).show();
            }
        });



    }


}
