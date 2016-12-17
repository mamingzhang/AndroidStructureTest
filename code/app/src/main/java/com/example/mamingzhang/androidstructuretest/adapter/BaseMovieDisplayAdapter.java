package com.example.mamingzhang.androidstructuretest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieSubject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by horsege on 2016/12/17.
 */

public class BaseMovieDisplayAdapter extends RecyclerView.Adapter<BaseMovieDisplayAdapter.BaseMovieDisplayHolder> {

    private Context context;

    private List<MovieSubject> movieSubjectsList;

    public BaseMovieDisplayAdapter(Context context) {
        this.context = context;
    }

    public void refreshSource(List<MovieSubject> movieSubjectsList) {
        this.movieSubjectsList = movieSubjectsList;
        notifyDataSetChanged();
    }

    @Override
    public BaseMovieDisplayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseMovieDisplayHolder(LayoutInflater.from(context).inflate(R.layout.recycleviewitem_basemoviedisplay, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseMovieDisplayHolder holder, int position) {
        MovieSubject movieSubject = movieSubjectsList.get(position);
        holder.bindMovieSubject(context, movieSubject);
    }

    @Override
    public int getItemCount() {
        return movieSubjectsList == null ? 0 : movieSubjectsList.size();
    }

    public static class BaseMovieDisplayHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_imgview)
        ImageView movieImgView;
        @BindView(R.id.moviechname_txtview)
        TextView movieChNameTxtView;
        @BindView(R.id.movieengname_txtview)
        TextView movieEngNameTxtView;
        @BindView(R.id.movieyear_txtview)
        TextView movieYearTxtView;

        public BaseMovieDisplayHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        public void bindMovieSubject(Context context, MovieSubject movieSubject) {
            movieChNameTxtView.setText(movieSubject.getTitle());
            movieEngNameTxtView.setText(movieSubject.getOriginal_title());
            movieYearTxtView.setText(movieSubject.getYear());

            Glide.with(context).load(movieSubject.getImages().getMedium()).into(movieImgView);
        }
    }
}
