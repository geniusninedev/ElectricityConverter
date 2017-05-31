package com.nineinfosys.electricityconverter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nineinfosys.electricityconverter.ConverterActivity.ChargeConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ConductanceConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ConductivityConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.CurrentConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectricFieldStrengthActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectricPotentialActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectricResistanceConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectricResistivityConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectrostaticCapacitanceActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.InductanceConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.LinearChargeDensityConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.LinearCurrentDensityActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.SurfaceChargeDensityConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.SurfaceCurrentDensityActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.VolumeChargeDensityActivity;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemObject;

import java.util.List;


/**
 * Created by AndriodDev5 on 18-04-2017.
 */

public class RecyclerViewElectricityAdapter extends RecyclerView.Adapter<RecyclerViewElectricityAdapter.RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewElectricityAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView countryName;
        public ImageView countryPhoto;


        public RecyclerViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            countryName = (TextView)itemView.findViewById(R.id.country_name);
            countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);

        }

        @Override
        public void onClick(View view) {

            switch (getPosition())
            {
                case 0:
                    Intent i=new Intent(context,ChargeConverterActivity.class);
                    context.startActivity(i);
                    break;
                case 1:
                    Intent i1=new Intent(context,LinearChargeDensityConverterActivity.class);
                    context.startActivity(i1);
                    break;
                case 2:
                    Intent i2=new Intent(context,SurfaceChargeDensityConverterActivity.class);
                    context.startActivity(i2);
                    break;
                case 3:
                    Intent i3=new Intent(context,VolumeChargeDensityActivity.class);
                    context.startActivity(i3);

                    break;
                case 4:
                    Intent i4=new Intent(context,CurrentConverterActivity.class);
                    context.startActivity(i4);
                    break;
                case 5:
                    Intent i5=new Intent(context,LinearCurrentDensityActivity.class);
                    context.startActivity(i5);
                    break;
                case 6:
                    Intent i6=new Intent(context,SurfaceCurrentDensityActivity.class);
                    context.startActivity(i6);
                    break;
                case 7:
                    Intent i7=new Intent(context,ElectricFieldStrengthActivity.class);
                    context.startActivity(i7);
                    break;
                case 8:
                    Intent i8=new Intent(context,ElectricPotentialActivity.class);
                    context.startActivity(i8);
                    break;
                case 9:
                    Intent i9=new Intent(context,ElectricResistanceConverterActivity.class);
                    context.startActivity(i9);
                    break;
                case 10:
                    Intent i10=new Intent(context,ElectricResistivityConverterActivity.class);
                    context.startActivity(i10);
                    break;
                case 11:
                    Intent i11=new Intent(context,ConductanceConverterActivity.class);
                    context.startActivity(i11);
                    break;

                case 12:
                    Intent i12=new Intent(context,ConductivityConverterActivity.class);
                    context.startActivity(i12);
                    break;

                case 13:
                    Intent i13=new Intent(context,ElectrostaticCapacitanceActivity.class);
                    context.startActivity(i13);
                    break;
                case 14:
                    Intent i14=new Intent(context,InductanceConverterActivity.class);
                    context.startActivity(i14);
                    break;

            }


        }



    }
}