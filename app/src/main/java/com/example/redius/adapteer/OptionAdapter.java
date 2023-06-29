package com.example.redius.adapteer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.redius.R;
import com.example.redius.di.base.MyApplication;
import com.example.redius.model.Option;

import java.util.List;

import javax.inject.Inject;

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.ChildViewHolder> {

    private List<Option> ChildItemList;
    private OptionAdapter.ClickListener clickListener;
    private int selectedPosition = -1;

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Inject
    OptionAdapter(List<Option> childItemList) {
        this.ChildItemList = childItemList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(
                        R.layout.child_item,
                        viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position) {
        Option childItem = ChildItemList.get(position);
        if (childItem.getIsChecked()) {
            selectedPosition = childViewHolder.getAdapterPosition();
            childItem.setIsChecked(false);
        }
        if (selectedPosition == position) {
            childViewHolder.cardView.setSelected(true); //using selector drawable
            childViewHolder.cardView.setBackgroundResource(R.drawable.background_selected);
        } else {
            childViewHolder.cardView.setSelected(false);
            childViewHolder.cardView.setBackgroundResource(R.drawable.background_unselected);
        }

        int id = MyApplication.getInstance().getResources().getIdentifier(childItem.getIcon(), "drawable", MyApplication.getInstance().getPackageName());
        childViewHolder.imageView.setImageResource(id);
        if (childItem.getIcon().equalsIgnoreCase("no-room"))
            childViewHolder.imageView.setImageResource(R.drawable.no_room);
        childViewHolder.cardView.setOnClickListener(v -> {

            if (selectedPosition >= 0)
                notifyItemChanged(selectedPosition);
            selectedPosition = childViewHolder.getAdapterPosition();
            notifyItemChanged(selectedPosition);
            clickListener.onItemClick(selectedPosition, childItem.getId());
        });
        childViewHolder.ChildItemTitle.setText(childItem.getName());

    }

    @Override
    public int getItemCount() {
        return ChildItemList.size();
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {

        TextView ChildItemTitle;
        CardView cardView;
        ImageView imageView;

        ChildViewHolder(View itemView) {
            super(itemView);
            ChildItemTitle = itemView.findViewById(R.id.child_item_title);
            cardView = itemView.findViewById(R.id.card);
            imageView = itemView.findViewById(R.id.img_child_item);
        }
    }

    public interface ClickListener {
        void onItemClick(int selectedPosition, String id);
    }
}
