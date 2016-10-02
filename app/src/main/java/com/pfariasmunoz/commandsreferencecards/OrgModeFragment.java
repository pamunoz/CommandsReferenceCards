package com.pfariasmunoz.commandsreferencecards;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrgModeFragment extends Fragment {
    private String[] mSections;
    private String[] mCommands;
    private String[] mFunctions;
    private ArrayList<Command> mCommandsList;
    private int[] mSectionsIndices;
    private int mColorResourceId;

    public OrgModeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.command_list, container, false);

        mSections = getResources().getStringArray(R.array.org_mode_section_titles);
        mCommands = getResources().getStringArray(R.array.org_mode_commands);
        mFunctions = getResources().getStringArray(R.array.org_mode_functions);
        mSectionsIndices = getResources().getIntArray(R.array.org_mode_section_indices);
        mCommandsList = new ArrayList<>();
        mColorResourceId = R.color.category_org_mode;

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        /** Add the commands to the ArrayList adding sections titles */
        addCommands();


        CommandAdapter adapter = new CommandAdapter(getActivity(), mCommandsList, mColorResourceId);

        listView.setAdapter(adapter);

        return rootView;
    }

    private void addCommands() {
        // don't add elements to the arraylist if functions and its command don't have the same length
        if (mCommands.length == mFunctions.length) {

            int j = 0;
            for (int i = 0; i < mCommands.length; i++) {
                if (j < mSectionsIndices.length  && i == mSectionsIndices[j]) {
                    mCommandsList.add(new Command(mCommands[i], mFunctions[i], mSections[j]));
                    j++;
                    // this line if for avoiding indices access errors for the section indices
                    if (j == mSectionsIndices.length) j+= mSectionsIndices.length;
                } else {
                    mCommandsList.add(new Command(mCommands[i], mFunctions[i]));
                }
            }
        }

    }

}
