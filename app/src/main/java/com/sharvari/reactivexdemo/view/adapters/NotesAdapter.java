package com.sharvari.reactivexdemo.view.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sharvari.reactivexdemo.R;
import com.sharvari.reactivexdemo.network.model.response.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sharvari on 19-Jun-18.
 */

public class NotesAdapter  extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private Context context;
    private List<Note> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.note)
        TextView note;

        @BindView(R.id.dot)
        TextView dot;

        @BindView(R.id.timestamp)
        TextView timestamp;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public NotesAdapter(Context context, List<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.note.setText(note.getNote());
        holder.dot.setText(Html.fromHtml("&#8226;"));
        holder.dot.setTextColor(getRandomMaterialColor("400"));
        holder.timestamp.setText(formatDate(note.getTimestamp()));
    }

    private String formatDate(String timestamp) {
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(timestamp);
            SimpleDateFormat toDateFormat = new SimpleDateFormat("MMM d");
            return toDateFormat.format(date);

        }catch (Exception e){}
        return "";
    }

    private int getRandomMaterialColor(String typeColor) {
        int returnColor = Color.GRAY;
        int arrayId = context.getResources().getIdentifier("mdcolor_"+typeColor, "array",context.getPackageName());
        if(arrayId != 0){
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return  returnColor;
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }
    
}
