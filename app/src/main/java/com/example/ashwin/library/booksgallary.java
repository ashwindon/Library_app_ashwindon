package com.example.ashwin.library;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;
import static android.support.constraint.Constraints.TAG;

public class booksgallary extends Fragment {

    // String u="";
    data d = new data();
    View view;
    Context context;
    private DatabaseReference dref;
    private TextView t;
    // int uid=0;
    private ListView mUserList;
    private ArrayList<String> mUserName = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.booksgallary, container, false);
        onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Books Gallary");
        context = container.getContext();
        //String uid = "";
        //FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        //uid = currentFirebaseUser.getUid();
        mUserList = (ListView) view.findViewById(R.id.user_list);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, mUserName);
        //String uid = "";
        //uid = currentFirebaseUser.getUid();
        dref = FirebaseDatabase.getInstance().getReference("books/0");
        mUserList.setAdapter(arrayAdapter);
        dref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String x;
                Log.d("TAG", dataSnapshot.child("bname").toString());
                //data i = dataSnapshot.getValue(data.class);

                //mUserName.add();
                //arrayAdapter.notifyDataSetChanged();

// String x = "";
//                 x = dataSnapshot.getValue("bname");

//                //x = b.getBname();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // t = view.findViewById(R.id.data);
//        dref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.d(TAG,dataSnapshot.toString());
//                data d  = dataSnapshot.getValue(data.class);
//                t.setText("Name :"+d.getName());
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}
