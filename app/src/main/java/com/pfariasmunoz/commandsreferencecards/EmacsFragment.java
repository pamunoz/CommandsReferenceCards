package com.pfariasmunoz.commandsreferencecards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmacsFragment extends Fragment {

    private String[] emacsSections;
    private String[] emacsCommands;
    private String[] emacsFunctions;
    private ArrayList<Command> commands;
    private int[] indices;

    public EmacsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.command_list, container, false);

        emacsSections = getResources().getStringArray(R.array.emacs_section_titles);
        emacsCommands = getResources().getStringArray(R.array.emacs_commands);
        emacsFunctions = getResources().getStringArray(R.array.emacs_functions);
        indices = getResources().getIntArray(R.array.section_indices);
        commands = new ArrayList<>();

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        /** Add the commands to the ArrayList adding sections titles */
        addCommand();

        CommandAdapter adapter = new CommandAdapter(getActivity(), commands, R.color.category_emacs);

        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void addCommand() {

        if (emacsCommands.length == emacsFunctions.length) {

            int j = 0;
            for (int i = 0; i < emacsCommands.length; i++) {
                if (i == 0 || i == 1 || i == 3 || i == 9 || i == 16 || i == 21 || i == 31 ||
                    i == 47 || i == 58 || i == 66 || i == 75 || i == 90 || i == 103 || i == 109) {
                    commands.add(new Command(emacsCommands[i], emacsFunctions[i], emacsSections[j++]));
                } else {
                    commands.add(new Command(emacsCommands[i], emacsFunctions[i]));
                }
            }
        }
    }
}
