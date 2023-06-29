package com.example.redius.adapteer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.redius.R;
import com.example.redius.model.FacilityResponse;

import java.util.List;

import javax.inject.Inject;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ParentViewHolder> implements OptionAdapter.ClickListener{

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<FacilityResponse> itemList;
    Context context;
    private ClickListenerFacility clickListener;


    @Inject
    public FacilityAdapter(Context context, List<FacilityResponse> facilityResponses) {
        this.context = context;
        this.itemList=facilityResponses;
    }
    public void setOnClickListener(ClickListenerFacility clickListener) {
        this.clickListener = clickListener;
    }

    public void setData(List<FacilityResponse> itemList) {
        this.itemList  = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_item,
                        viewGroup, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder parentViewHolder, int position) {

        FacilityResponse parentItem = itemList.get(position);

        parentViewHolder.ParentItemTitle.setText(parentItem.getName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(parentViewHolder.ChildRecyclerView.getContext(), LinearLayoutManager.HORIZONTAL,
                false);

        layoutManager.setInitialPrefetchItemCount(parentItem.getOptions().size());

        OptionAdapter childItemAdapter = new OptionAdapter(parentItem.getOptions());
        childItemAdapter.setOnClickListener(this);
        parentViewHolder.ChildRecyclerView.setLayoutManager(layoutManager);
        parentViewHolder.ChildRecyclerView.setAdapter(childItemAdapter);
        parentViewHolder.ChildRecyclerView.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onItemClick(int selectedPosition, String id) {
        for(int i=0; i<itemList.size(); i++){
            for (int j=0;j < itemList.get(i).getOptions().size(); j++){
                if(itemList.get(i).getOptions().get(j).getId().equalsIgnoreCase(id));
                clickListener.onChildClick(selectedPosition, id, itemList.get(i).getFacilityId());
            }
        }

    }

    class ParentViewHolder
            extends RecyclerView.ViewHolder {

        private TextView ParentItemTitle;
        private RecyclerView ChildRecyclerView;

        ParentViewHolder(final View itemView) {
            super(itemView);

            ParentItemTitle = itemView.findViewById(
                            R.id.parent_item_title);
            ChildRecyclerView = itemView.findViewById(
                            R.id.child_recyclerview);
        }
    }

    public interface ClickListenerFacility {
        void onChildClick(int selectedPosition, String s, String id);
    }
}