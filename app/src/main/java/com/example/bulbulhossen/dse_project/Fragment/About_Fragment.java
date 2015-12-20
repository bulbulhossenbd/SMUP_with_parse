package com.example.bulbulhossen.dse_project.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bulbulhossen.dse_project.All_adapter.ListAdapter;
import com.example.bulbulhossen.dse_project.R;


/**
 * Created by Md.Bulbul Hossen on 11/12/15.
 */
public class About_Fragment extends Fragment {

    Intent i;
    public About_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.about_fragment, container, false);




        String[] data =new String[]{" Introduction To DSE"," Mission & Vision",
        " DSE at a Glance"," Board of Directors"," DSE Management"," Legal Control"

                ," Function of DSE"," Clearing & Settelment"," DSE Indeces",
                " Holiday & Trading Sessions"," DSE Branch Offices"," DSE President/Chairman"
                ," Department of DSE"," TREC Holders Directory"," Articles of Association"
                ," Surveillance"," Annual Report"
        };

       // int image[]={R.drawable.aiub, R.drawable.aiub, R.drawable.aiub, R.drawable.aiub,R.drawable.du,R.drawable.aiub, R.drawable.aiub, R.drawable.aiub,R.drawable.aiub,R.drawable.aiub,R.drawable.aiub,R.drawable.aiub,R.drawable.aiub,};
        ListView lv=(ListView) rootView.findViewById(R.id.firstListView);

        final ListAdapter ad =(new ListAdapter(getActivity(),data));//,image

        lv.setAdapter(ad);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

             //   Toast.makeText(getActivity(), "You Just Clicked:" + ad.getItem(position), Toast.LENGTH_LONG);

                switch (position) {

                    case 0:
                        i = new Intent(getActivity(),Market_Statistics.class);

                }

                startActivity(i);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}