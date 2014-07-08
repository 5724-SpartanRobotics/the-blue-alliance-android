package com.thebluealliance.androidclient.listitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.thebluealliance.androidclient.R;

/**
 * File created by phil on 4/23/14.
 */
public class StatsListElement extends ListElement {

    private String mTeamNumber;
    private String mTeamName;
    private String mTeamStat;

    public StatsListElement(String key, String number, String name, String stat) {
        super(key);
        mTeamNumber = number;
        mTeamName = name;
        mTeamStat = stat;
    }

    @Override
    public View getView(Context c, LayoutInflater inflater, View convertView) {
        ViewHolder holder;
        if (convertView == null || !(convertView.getTag() instanceof ViewHolder)) {
            convertView = inflater.inflate(R.layout.list_item_stats, null);

            holder = new ViewHolder();
            holder.teamNumber = (TextView) convertView.findViewById(R.id.team_number);
            holder.teamName = (TextView) convertView.findViewById(R.id.team_name);
            holder.teamStat = (TextView) convertView.findViewById(R.id.team_stat);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.teamNumber.setText("" + mTeamNumber);

        if (!mTeamName.isEmpty()) {
            holder.teamName.setText(mTeamName);
        } else {
            holder.teamName.setVisibility(View.GONE);
        }

        holder.teamStat.setText(mTeamStat);

        return convertView;
    }

    private static class ViewHolder {
        TextView teamNumber;
        TextView teamName;
        TextView teamStat;
    }

}