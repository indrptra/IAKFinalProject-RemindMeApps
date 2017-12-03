package digital.iakfinalproject_remindmeapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import digital.iakfinalproject_remindmeapps.R;
import digital.iakfinalproject_remindmeapps.ViewDetailActivity;
import digital.iakfinalproject_remindmeapps.model.ListDataResponse;

/**
 * Created by apc-lap008 on 03/12/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    String[] SubjectValues;
    Context context;
    View view1;
    ViewHolder viewHolder1;
    List<ListDataResponse> data =  new ArrayList<>();
    TextView textView;

    public RecyclerViewAdapter(Context context1, List<ListDataResponse> datas){

        this.data = datas;
        this.context = context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_tittle, tv_content;
        public LinearLayout ln_content;

        public ViewHolder(View v){

            super(v);

            tv_tittle = (TextView)v.findViewById(R.id.tv_tittle);
            tv_content = (TextView)v.findViewById(R.id.tv_content);
            ln_content = (LinearLayout)v.findViewById(R.id.ln_content);

        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        view1 = LayoutInflater.from(context).inflate(R.layout.recyclerview_items,parent,false);

        viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        final ListDataResponse datas = data.get(position);

        holder.tv_tittle.setText(datas.getTitle());
        holder.tv_content.setText(datas.getContent());
        holder.ln_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ViewDetailActivity.class);
                i.putExtra("tittle", datas.getTitle().toString());
                i.putExtra("content", datas.getContent().toString());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount(){

        return data.size();
    }
}