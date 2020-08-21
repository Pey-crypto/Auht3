package com.SecureWk.Auht.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.SecureWk.Auht.R;
import com.SecureWk.Auht.entity.Local;

import io.realm.Realm;
import io.realm.RealmResults;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.Holders> {

    private Context context;
    private Realm realm;
    private RealmResults<Local> realmResults;
    private LayoutInflater inflater;

    public LocalAdapter(Context context, Realm realm, RealmResults<Local> realmResults, LayoutInflater inflater) {
        this.context = context;
        this.realm = realm;
        this.realmResults = realmResults;
        this.inflater = inflater;
    }
    @NonNull
    @Override
    public Holders onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view = inflater.inflate(R.layout.local_list_layout);
        Holders holders = new Holders(view);
        return holders;
    }


    public class Holders extends RecyclerView.ViewHolder{
        private int position;
        private TextView


        public Holders(@NonNull View itemView) {
            super(itemView);
        }


    }
}
