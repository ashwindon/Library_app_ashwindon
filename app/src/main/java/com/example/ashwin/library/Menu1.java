package com.example.ashwin.library;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Menu1 extends Fragment {

    private RecyclerView bookgallery;
    private DatabaseReference ref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ref = FirebaseDatabase.getInstance().getReference().child("Books");
        ref.keepSynced(true);

        bookgallery = (RecyclerView)getView().findViewById(R.id.galleryrecycle);
        bookgallery.setHasFixedSize(true);
        bookgallery.setLayoutManager(new LinearLayoutManager(getActivity()));

        getActivity().setTitle("Book Gallery");
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<BookInfo, BookViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<BookInfo, BookViewHolder>
                (BookInfo.class, R.layout.cardview_row, BookViewHolder.class, ref) {
            @Override
            protected void populateViewHolder(BookViewHolder viewHolder, BookInfo model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setAuthorname(model.getAuthor());
                viewHolder.setImage(getActivity().getApplicationContext(), model.getImage());
            }
        };

        bookgallery.setAdapter(firebaseRecyclerAdapter);
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        View view;

        public BookViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setTitle(String title) {
            TextView booktitle = (TextView)view.findViewById(R.id.booktitle);
            booktitle.setText(title);
        }

        public void setAuthorname(String name) {
            TextView bookauthor = (TextView)view.findViewById(R.id.bookauthor);
            bookauthor.setText(name);
        }

        public void setImage(Context context, String image) {
            ImageView imageView = (ImageView)view.findViewById(R.id.bookimage);

            Picasso.with(context).load(image).into(imageView);
        }
    }
}
