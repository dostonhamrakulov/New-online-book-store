package com.idoston.e_book_store;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class Inserting_ebook extends AppCompatActivity {

    DatabaseHelper myDB;
    Context context = this;
    SQLiteDatabase sqLiteDatabase;

    private EditText edit_category, edit_author, edit_title, edit_year, edit_price, edit_pages;
    private Button btn_insert;
    private String Category;
    private String Author;
    private String Title;
    private String Year;
    private String Pages;
    private String Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting_ebook);


        //To add icon to actionBar

        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayUseLogoEnabled(true);
        myActionBar.setDisplayShowHomeEnabled(true);
        myActionBar.setLogo(R.drawable.ic_phone_android_black_24dp);


        myDB = new DatabaseHelper(this);

        edit_category = (EditText) findViewById(R.id.id_insert_book_category);
        edit_author = (EditText) findViewById(R.id.id_insert_book_Author);
        edit_title = (EditText) findViewById(R.id.id_insert_book_title);
        edit_year = (EditText) findViewById(R.id.id_insert_book_year);
        edit_pages = (EditText) findViewById(R.id.id_insert_book_pages);
        edit_price = (EditText) findViewById(R.id.id_insert_book_price);

        btn_insert = (Button) findViewById(R.id.id_btn_insert);

        //A_book book = new A_book();
//        List<A_book> list = new LinkedList<A_book>();
//
//        A_book b1 = new A_book("Technology", "HTML development", "Doston Hamrakulov", 2017, 500, 25, 100, 15);
//        A_book b2 = new A_book("Fiction", "My daily story", "John Adam", 2018, 100, 35, 50, 15);
//        A_book b3 = new A_book("Economic", "Buniss issues", "James Chanies", 2017, 400, 5, 78, 20);
//
//        list.add(b1);
//        list.add(b2);
//        list.add(b3);
//
//        boolean defaultValues = false;
//        for(A_book b : list){
//            defaultValues = myDB.insertDefaultBook(b.getCategory(), b.getTitle(), b.getAuthor(), b.getYear(), b.getPages(), b.getBought(), b.getAvailable(), b.getPrice());
//        }
//
//        if (defaultValues = true){
//            Toast.makeText(Inserting_ebook.this, "Default stored books are added!!!", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(Inserting_ebook.this, "Unfortunately NOT added!!!", Toast.LENGTH_LONG).show();
//        }



    }
    public void AddBook(View view){
        btn_insert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Category = edit_category.getText().toString();
                        Author = edit_author.getText().toString();
                        Title = edit_title.getText().toString();
                        Year = edit_year.getText().toString();
                        Pages = edit_pages.getText().toString();
                        Price = edit_price.getText().toString();

                        myDB = new DatabaseHelper(context);
                        sqLiteDatabase = myDB.getReadableDatabase();
                        myDB.addInformation(Category, Author, Title, Year, Pages, Price, sqLiteDatabase);
                        Toast.makeText(Inserting_ebook.this, "New Book is inserted!!!", Toast.LENGTH_LONG).show();
                        myDB.close();
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_values, menu);

        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.icon_action_settings) {
            Toast.makeText(Inserting_ebook.this, "Sorry, there is no any option for setting!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        switch(id){
            case R.id.icon_about_us:
                Toast.makeText(Inserting_ebook.this, "I am Junior Android Developer!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.icon_contact_us:
                Toast.makeText(Inserting_ebook.this, "If you want to cantact me, please write email to doston2509@gmail.com!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.icon_exit_app:
                finish();
                System.exit(0);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}