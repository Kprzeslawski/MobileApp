package com.example.app1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.app1.dataStorage.AsyncFetchMethods;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdventureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdventureFragment extends Fragment {

    public AdventureFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AdventureFragment.
     */
    public static AdventureFragment newInstance() {
        AdventureFragment fragment = new AdventureFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public void init(View v) {

        TableLayout stk = (TableLayout) v.findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(requireContext());

        TextView tv0 = new TextView(requireContext());
        tv0.setText("Location Name");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(requireContext());
        tv1.setText("Requied Level");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);
        stk.addView(tbrow0);

        AsyncFetchMethods.fetchLocations(location -> {
            TableRow tbrow = new TableRow(requireContext());

            TextView t1v = new TextView(requireContext());
            t1v.setText(location.getName());
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);

            TextView t2v = new TextView(requireContext());
            t2v.setText(location.getMin_lv().toString());
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);

            stk.addView(tbrow);
        },getActivity());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adventure, container, false);
        init(view);
        return view;
    }
}