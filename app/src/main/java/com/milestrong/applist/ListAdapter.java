package com.milestrong.applist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Miles Lawrence on 30/08/2017.
 */

public class ListAdapter extends BaseAdapter{
    private final Activity context;
    private final ArrayList<Application> apps;

    public ListAdapter (Activity context, ArrayList<Application> apps) {
        this.context = context;
        this.apps = apps;
    }

    @Override
    public View getView (int pos, View view, ViewGroup parent) {
        View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, null);

        ImageView image = (ImageView) retval.findViewById(R.id.list_image);
        image.setImageDrawable(apps.get(pos).getIcon());
        TextView title = (TextView) retval.findViewById(R.id.list_text);
        title.setText(apps.get(pos).getTitle());

        return retval;
    }

    @Override
    public int getCount() {
        return apps.size();
    }

    @Override
    public Object getItem(int pos) {
        return apps.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }
}
