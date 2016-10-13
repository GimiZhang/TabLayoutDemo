package com.example.gimi.tablayoutdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */

public class FragmentAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private Context mContext;
    private List<InfoBean> data_list;
    private  LayoutInflater mLayoutInflater;

    public FragmentAdapter(Context context,List<InfoBean> list){
        super();
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
        data_list = list;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater,R.layout.layout_item,parent,false);

        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        InfoBean infoBean = data_list.get(position);
        holder.getBinding().setVariable(com.example.gimi.tablayoutdemo.BR.info,infoBean);
    }

    @Override
    public int getItemCount() {
        return data_list == null ? 0 : data_list.size();
    }
}
