/*

Developed: Paulo Henrique Araújo Munhoz    data: 2020/04/10

 */


package com.example.task4;

import android.text.LoginFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.lang.CharSequence;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {

    //private static final String TAG = "RecyclerAdapter";
    //int count =0;

    List<String> contactsList;
    List<String> contactsListAll;

    public RecyclerAdapter(List<String> contactsList) {
        this.contactsList = contactsList;
        this.contactsListAll =new ArrayList<>(contactsList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       // Log.i(TAG, "OnCreateViewHolder: " + count++);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(contactsList.get(position));

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String>filteredList =new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filteredList.addAll(contactsListAll);
            }else{
                for(String contact: contactsListAll){
                    if(contact.toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(contact);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            contactsList.clear();
            contactsList.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();

        }
    };

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView imageView;

        TextView textView, rowCountTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView4);
            textView = itemView.findViewById(R.id.textView);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Toast.makeText(view.getContext(), contactsList.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();

        }
    }


}
