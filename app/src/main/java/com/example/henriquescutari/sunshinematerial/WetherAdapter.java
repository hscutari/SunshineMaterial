package com.example.henriquescutari.sunshinematerial;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by henriquescutari on 2/11/15.
 */
public class WetherAdapter extends RecyclerView.Adapter<WetherAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView card;
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.list_item);
            card = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public WetherAdapter(Context context, String[] myDataset) {
        mDataset = myDataset;
        mContext = context;
    }

    public void addArray(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WetherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_forecast_textview, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);
        setAnimation(holder.card, position);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    private int lastPosition = -1;
    private void setAnimation(View viewToAnimate, int position)
    {
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.abc_slide_in_top);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
