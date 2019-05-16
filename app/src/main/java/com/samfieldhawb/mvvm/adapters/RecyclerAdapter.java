package com.samfieldhawb.mvvm.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samfieldhawb.mvvm.R;
import com.samfieldhawb.mvvm.models.NicePlace;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<NicePlace> mNicePlaces;

    public RecyclerAdapter(Context context, List<NicePlace> nicePlaces) {
        mContext = context;
        mNicePlaces = nicePlaces;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NicePlaceHolder(LayoutInflater.from(mContext).inflate(R.layout.single_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        NicePlace nicePlace = mNicePlaces.get(i);
        ((NicePlaceHolder) viewHolder).mTitle.setText(nicePlace.getTitle());
        Glide.with(mContext).load(nicePlace.getImageUrl()).into(((NicePlaceHolder) viewHolder).mImageView);
    }

    @Override
    public int getItemCount() {
        return mNicePlaces != null? mNicePlaces.size():0;
    }

    class NicePlaceHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTitle;
        public NicePlaceHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
        }
    }
}
