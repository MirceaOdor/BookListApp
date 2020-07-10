package com.mircea.booklistapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<BookItem> mBookList;

    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        createBookList();
        buildRecyclerView();

        final EditText search = findViewById(R.id.search_box);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<BookItem> filteredList = new ArrayList<>();

        for (BookItem item : mBookList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }


//    public void createBookList() {
//        mBookList = new ArrayList<>();
//        mBookList.add(new BookItem(R.drawable.book_menu, "In Search of Lost Time", "Marcel Proust", "Modernist", "1913", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "Ulysses", "James Joyce ", "Modernist", "1922", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "Don Quixote", "Miguel de Cervantes", "Novel", "1605 - 1612", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "The Great Gatsby", "F. Scott Fitzgerald", "Tragedy", "1925", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "One Hundred Years of Solitude", "Gabriel García Márquez", "Magic Realism", "1967", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "Moby Dick", "Herman Melville", "Novel", "1851", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "War and Peace", "Leo Tolstoy", "Historical Novel", "1869", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "Lolita", "Vladimir Nabokov", "Novel", "1955", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "Hamlet", "William Shakespeare", "Tragedy", "somewhere between 1599-1601", false));
//        mBookList.add(new BookItem(R.drawable.book_menu, "The Catcher in the Rye", "J. D. Salinger", "Realistic", "1951", false));
//
//    }


    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        copyDatabase(this);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        mBookList = databaseHelper.getBookList();
        mAdapter = new BookAdapter(mBookList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                intent.putExtra("Book Item", mBookList.get(position));
                startActivity(intent);
            }
        });

    }

    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


