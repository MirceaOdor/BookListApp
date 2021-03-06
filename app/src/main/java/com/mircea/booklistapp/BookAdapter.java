package com.mircea.booklistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<BookItem> mBookList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTitle;
        public TextView mAuthor;


        public BookViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTitle=itemView.findViewById(R.id.textView);
            mAuthor = itemView.findViewById(R.id.textView2);
            //reference to the views

            itemView.setOnClickListener(new View.OnClickListener(){


                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public BookAdapter(List bookList){
        mBookList = bookList;

    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        BookViewHolder bvh = new BookViewHolder(v, mListener);
        return bvh;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
    //pass values to the views
    BookItem currentItem = mBookList.get(position);

    holder.mImageView.setImageResource(currentItem.getmImageResource());
    holder.mTitle.setText((currentItem.getTitle()));
    holder.mAuthor.setText(currentItem.getAuthor());

    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }

    public void filterList(ArrayList<BookItem> filteredList){
        mBookList = filteredList;
        notifyDataSetChanged();
    }
}
