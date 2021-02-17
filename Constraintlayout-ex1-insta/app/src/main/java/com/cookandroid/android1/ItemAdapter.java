package com.cookandroid.android1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private final List<String> movies;
    private final Context mContext;

    public ItemAdapter(List<String> movies, Context mContext){
        this.movies = movies;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. 부모 컨텍스트 가져오기
        Context context = parent.getContext();
        // 2. 인플레이터 객체 생성 완료
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater inflater2 = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.list_item, parent);

        return view;
    }
}
