package com.example.mamingzhang.androidstructuretest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mamingzhang.androidstructuretest.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {

  private Context mContext;
  private List<String> dataList = new ArrayList<>();

  public RecyclerAdapter(Context context, List dataList) {
      this.mContext = context;
      this.dataList.addAll(dataList);
  }

  @Override
  public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
    final View view = inflater.inflate(R.layout.recycler_item, viewGroup, false);

    return new ListViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ListViewHolder viewHolder, int position) {
    String current = dataList.get(position);

    Glide.with(mContext)
            .load(current)
            .into(viewHolder.image);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public int getItemCount() {
    return dataList.size();
  }

  @Override
  public int getItemViewType(int position) {
    return 0;
  }

  public static final class ListViewHolder extends RecyclerView.ViewHolder {

    private final ImageView image;

    public ListViewHolder(View itemView) {
      super(itemView);
      image = (ImageView) itemView.findViewById(R.id.image);
    }
  }
}
