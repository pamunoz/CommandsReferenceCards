package com.pfariasmunoz.commandsreferencecards;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pablo Farias on 24-09-16.
 */

public class CommandAdapter extends ArrayAdapter<Command> {

    private int mColorResourceId;

    public CommandAdapter(Context context, ArrayList<Command> commands, int colorResourceId) {
        super(context, 0, commands);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Command currentCommand = getItem(position);



        TextView sectionTitleView = (TextView) listItemView.findViewById(R.id.section_title);
        if (currentCommand.hasSectionTitle()) {
            sectionTitleView.setText(currentCommand.getSectionTitle());
            sectionTitleView.setVisibility(View.VISIBLE);


        } else {
            sectionTitleView.setVisibility(View.GONE);
        }

        TextView commandView = (TextView) listItemView.findViewById(R.id.command_item);
        commandView.setText(currentCommand.getCommand());

        TextView functionView = (TextView) listItemView.findViewById(R.id.function_item);
        functionView.setText(currentCommand.getFunction());

        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        sectionTitleView.setBackgroundColor(color);

        return listItemView;
    }
}
