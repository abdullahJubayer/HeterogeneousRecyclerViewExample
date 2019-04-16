package com.example.hetarogeneousrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int MODEL1 =1 ;
    private static final int MODEL2 = 2;
    ArrayList<Object> list;
    public MyRecyclerAdapter(ArrayList<Object> list) {
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof Model1){
            return MODEL1;
        }
        if (list.get(position) instanceof Model2){
            return MODEL2;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        switch (i){
            case MODEL1:
                View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model1_view,viewGroup,false);
                return new Model1Viewholder(v);

            case MODEL2:
                View v2= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model2_view,viewGroup,false);
                 return new Model2ViewHolder(v2);
        }

        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()){
            case MODEL1:
                Model1 medel1= (Model1) list.get(i);
                Model1Viewholder medel1Viewholder= (Model1Viewholder) viewHolder;
                medel1Viewholder.bf.setText(medel1.getBoyFriend());
                medel1Viewholder.gf.setText(medel1.getGirlFriend());
                break;
            case MODEL2:
                Model2 model= (Model2) list.get(i);
                Model2ViewHolder modelViewHolder= (Model2ViewHolder) viewHolder;
                modelViewHolder.hus.setText(model.getHusbend());
                modelViewHolder.wif.setText(model.getWife());
                modelViewHolder.son.setText(model.getBoy());
                modelViewHolder.girl.setText(model.getGirl());
                break;

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class Model1Viewholder extends RecyclerView.ViewHolder{

        TextView gf,bf;
        public Model1Viewholder(@NonNull View itemView) {
            super(itemView);

            gf=itemView.findViewById(R.id.gf_id);
            bf=itemView.findViewById(R.id.bf_id);
        }
    }


    class Model2ViewHolder extends  RecyclerView.ViewHolder{

        TextView hus,wif,son,girl;
        public Model2ViewHolder(@NonNull View itemView) {
            super(itemView);

            hus=itemView.findViewById(R.id.hus_id);
            wif=itemView.findViewById(R.id.wife_id);
            son=itemView.findViewById(R.id.son_id);
            girl=itemView.findViewById(R.id.girl_id);
        }
    }
}
