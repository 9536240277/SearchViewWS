package com.example.searchviewws.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.searchviewws.R;
import com.example.searchviewws.entities.Countries;

import java.util.List;

public class CountryListAdapter extends ArrayAdapter<Countries> {
    private Context context;
    private List<Countries> countriesList;

    public CountryListAdapter(Context context,List<Countries> countriesList){
        super(context, R.layout.country_list_layout, countriesList);
        this.context= context;
        this.countriesList= countriesList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        convertView= layoutInflater.inflate(R.layout.country_list_layout,parent,false);
        Countries countries= countriesList.get(position);


        TextView textViewCountry= convertView.findViewById(R.id.textViewCountry);
        textViewCountry.setText(countries.getCountry());


        TextView textViewCases= convertView.findViewById(R.id.textViewCases);
        textViewCases.setText(String.valueOf(countries.getCases()));

        TextView textViewTodayCases= convertView.findViewById(R.id.textViewTodayCases);
        textViewTodayCases.setText(String.valueOf(countries.getTodayCases()));

        TextView textViewDeaths= convertView.findViewById(R.id.textViewDeaths);
        textViewDeaths.setText(String.valueOf(countries.getDeaths()));

        TextView textViewTodayDeaths= convertView.findViewById(R.id.textViewTodayDeaths);
        textViewTodayDeaths.setText(String.valueOf(countries.getTodayDeaths()));

        TextView textViewRecovered= convertView.findViewById(R.id.textViewRecovered);
        textViewRecovered.setText(String.valueOf(countries.getRecovered()));

        TextView textViewActive= convertView.findViewById(R.id.textViewActive);
        textViewActive.setText(String.valueOf(countries.getActive()));

        TextView textViewCritical= convertView.findViewById(R.id.textViewCritical);
        textViewCritical.setText(String.valueOf(countries.getCritical()));


        return convertView;
    }
}
