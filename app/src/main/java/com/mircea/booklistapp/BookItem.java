package com.mircea.booklistapp;

import android.os.Parcel;
import android.os.Parcelable;

public class BookItem implements Parcelable {
    private int mImageResource;
    private String title;
    private String author;
    private String genre;
    private String year;
    private int fav ;

    public BookItem(int mImageResource, String title, String author, String genre, String year, int fav) {
        this.mImageResource = mImageResource;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.fav = fav;
    }

    protected BookItem(Parcel in) {
        mImageResource = in.readInt();
        title = in.readString();
        author = in.readString();
        genre = in.readString();
        year = in.readString();
        fav = in.readInt() ;
    }

    public static final Creator<BookItem> CREATOR = new Creator<BookItem>() {
        @Override
        public BookItem createFromParcel(Parcel in) {
            return new BookItem(in);
        }

        @Override
        public BookItem[] newArray(int size) {
            return new BookItem[size];
        }
    };

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public int getFav() {
        return fav;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mImageResource);
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(genre);
        parcel.writeString(year);
        parcel.writeInt(fav);
    }
}
