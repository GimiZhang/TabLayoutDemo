package com.example.gimi.tablayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/5.
 */
public class MyFragment extends Fragment {

    private TextView tv;

    static MyFragment newInstance(String s){
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DATA",s);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment,container,false);
        Bundle bundle = getArguments();
        String data = bundle.getString("DATA");
        tv = (TextView) view.findViewById(R.id.id_fm_tv);
        if(data != null){
            tv.setText(data);
        }
        return view;
    }
}
