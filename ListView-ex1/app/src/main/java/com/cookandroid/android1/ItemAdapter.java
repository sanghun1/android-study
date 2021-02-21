package com.cookandroid.android1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
//
public class ItemAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    public ItemAdapter(List<Movie> movies){
        this.movies = movies;
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
        Log.d(TAG, "getView: " + position);
        if(convertView == null){
            Log.d(TAG, "convertView가 null입니다");
        }
        else{
            Log.d(TAG, "convertView가 null이 아닙니다");
        }
        // 1. 부모 컨텍스트 가져오기
        MainActivity MainActivitycontext = (MainActivity)parent.getContext();
        // 2. 인플레이터 객체 생성 완료
        LayoutInflater inflater = (LayoutInflater)MainActivitycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater inflater2 = LayoutInflater.from(context);

        // 강제성이 없다
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubTitle = view.findViewById(R.id.tv_subtitle);
        tvTitle.setText(movies.get(position).getTitle());
        tvSubTitle.setText(movies.get(position).getSubTitle());

        view.setOnClickListener(v -> {
            //Toast.makeText(context, "클릭됨" + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivitycontext, DetailActivity.class);
            intent.putExtra("title", movies.get(position).getTitle());
            MainActivitycontext.startActivity(intent);
        });

        view.setOnLongClickListener(v -> {
            Toast.makeText(MainActivitycontext, "롱클릭됨" + position, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "movies 사이즈 : " + movies.size());
            movies.remove(position);
            Log.d(TAG, "movies 사이즈 : " + movies.size());
            this.notifyDataSetChanged(); // 데이터 변경후 UI동기화시 호출해야함
            return true;
        });


        return view;
    }
}
