package com.example.gimi.tablayoutdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gimi.tablayoutdemo.databinding.LayoutFragmentBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/5.
 */
public class MyFragment extends Fragment {

    private TextView tv;
    private LayoutFragmentBinding binding;
    private List<InfoBean> list = new ArrayList<>();

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
//        View view = inflater.inflate(R.layout.layout_fragment,container,false);
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment,container,false);
        for (int i = 'a'; i < 'z'; i++) {

            list.add(new InfoBean(i+""));
        }
        Bundle bundle = getArguments();
        String data = bundle.getString("DATA");
        binding.idRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.idRecycle.setAdapter(new FragmentAdapter(getActivity(),list));
        return binding.getRoot();
    }
}
