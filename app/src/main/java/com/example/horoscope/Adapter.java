package com.example.horoscope;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Horoscope> horoscopeList;
    Context context;

    public Adapter(List<Horoscope> horoscopeList, Context context) {
        this.horoscopeList = horoscopeList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        Horoscope horoscope = horoscopeList.get(position);
        holder.sunsinename.setText(horoscope.ssname);
        int id = context.getResources().getIdentifier(horoscope.ssimagename,"drawable","com.example.horoscope");
        holder.imageView.setBackgroundResource(id);

    }

    @Override
    public int getItemCount() {
        return horoscopeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linearLayout;
        TextView sunsinename;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearlayout);
            sunsinename = itemView.findViewById(R.id.sunsinename);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(),Answer_Activity.class);
                    intent.putExtra("sunsinename",sunsinename.getText().toString());
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
