package com.homefinder.jeremybroutin.homefinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.homefinder.jeremybroutin.homefinder.ListingViewHolder;
import com.homefinder.jeremybroutin.homefinder.R;
import com.homefinder.jeremybroutin.homefinder.model.Listing;

import java.util.List;

/**
 * Created by jeremybroutin on 5/24/16.
 */
public class AdsListingAdapter extends ArrayAdapter<Object> {

    public AdsListingAdapter(Context context, List<Object> items){
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Listing item = (Listing) getItem(position);
        ListingViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder = ListingViewHolder.create(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ListingViewHolder) convertView.getTag();
        }

        viewHolder.populateView(item);

        return convertView;

    }

}
