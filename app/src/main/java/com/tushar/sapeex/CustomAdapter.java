package com.tushar.sapeex;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolders> {
    private List<ExpencessModel> listExpense;
    private Context context;

    public CustomAdapter(List<ExpencessModel> listExpense) {
        this.listExpense = listExpense;
    }

    @NonNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolders holder, int position) {
        holder.tvType.setText(listExpense.get(position).getCost_type());
        holder.tvAmount.setText("" + listExpense.get(position).getAmmoutn());
        holder.tvDate.setText(listExpense.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return listExpense.size();
    }

    class ViewHolders extends RecyclerView.ViewHolder{
        private TextView tvType, tvAmount, tvDate;
        private ConstraintLayout cl;

        public ViewHolders(@NonNull View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tvType);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvDate = itemView.findViewById(R.id.tvType);
            cl = itemView.findViewById(R.id.cl);
        }
    }

}
