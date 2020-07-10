package com.mircea.booklistapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        BookItem bookItem = intent.getParcelableExtra("Book Item");

        int imageRes = bookItem.getmImageResource();
        String title = bookItem.getTitle();
        String author = bookItem.getAuthor();
        String year = bookItem.getYear();
        String genre = bookItem.getGenre();

        ImageView imageView = findViewById(R.id.book_activity2);
        imageView.setImageResource(imageRes);

        TextView titlu = findViewById(R.id.title_Activity);
        titlu.setText(title);

        TextView autor = findViewById(R.id.author_Activity);
        autor.setText(author);

        TextView an = findViewById(R.id.year_Activity);
        an.setText(year);

        TextView gen = findViewById(R.id.genre_Activity);
        gen.setText(genre);
    }
}