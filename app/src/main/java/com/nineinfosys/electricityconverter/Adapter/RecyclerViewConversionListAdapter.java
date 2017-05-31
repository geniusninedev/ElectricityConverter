package com.nineinfosys.electricityconverter.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;

import java.util.List;


/**
 * Created by AndriodDev5 on 18-04-2017.
 */

public class RecyclerViewConversionListAdapter extends RecyclerView.Adapter<RecyclerViewConversionListAdapter.RecyclerViewHolders> {

   // private List<ItemObject> itemList;
    private Context context;
    private String [] unitNameList;
    private List<ItemList> unitvalue;
    View layoutView;
    private final View.OnClickListener mOnClickListener = new MyItemClickListener ();


    public RecyclerViewConversionListAdapter(Context context, List<ItemList> unitvalue) {

        this.context = context;
        //this.unitNameList=unitNameList;
        this.unitvalue = unitvalue;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversion_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        layoutView.setOnClickListener(mOnClickListener);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.unitshortForm.setText(unitvalue.get(position).getUnitnameshortform());
        holder.unitName.setText(unitvalue.get(position).getUnitname());
        holder.unitValue.setText(unitvalue.get(position).getUnitvalue());
        holder.unitvaluename.setText(unitvalue.get(position).getUnitvaluename());


    }

    @Override
    public int getItemCount() {
        return this.unitvalue.size();
    }




    public class RecyclerViewHolders extends RecyclerView.ViewHolder {

        public TextView unitshortForm,unitName;
        public TextView unitValue,unitvaluename;


        public RecyclerViewHolders(View itemView) {
            super(itemView);
         //   itemView.setOnClickListener(this);

            unitshortForm = (TextView)itemView.findViewById(R.id.Unitshortform);
            unitName = (TextView)itemView.findViewById(R.id.Unitname);
            unitValue = (TextView)itemView.findViewById(R.id.unitvalue);
            unitvaluename = (TextView)itemView.findViewById(R.id.unitvaluename);


        }



    }
}