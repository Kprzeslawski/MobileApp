package com.example.app1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.app1.dataStorage.AsyncFetchMethods;
import com.example.app1.dataStorage.DataStorage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InventoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InventoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    public InventoryFragment() {
        // Required empty public constructor
    }

    public static InventoryFragment newInstance() {
        InventoryFragment fragment = new InventoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void init(View v) {

        AsyncFetchMethods.fetchHero(hero -> {
            ((TextView) v.findViewById(R.id.inv_frag_data_level)).setText("Level: " + hero.getLevel());
            ((TextView) v.findViewById(R.id.inv_frag_data_exp)).setText("Exp: " + hero.getExp());
            ((TextView) v.findViewById(R.id.inv_frag_data_health)).setText("Health: " + hero.getStats().getHealth());
            ((TextView) v.findViewById(R.id.inv_frag_data_attack_dmg)).setText("Attack damage: " + hero.getStats().getAttack_dmg());
            ((TextView) v.findViewById(R.id.inv_frag_data_armor)).setText("Armor: " + hero.getStats().getArmor());
            ((TextView) v.findViewById(R.id.inv_frag_data_defense)).setText("Defense: " + hero.getStats().getDef());
            ((TextView) v.findViewById(R.id.inv_frag_data_power)).setText("Power: " + hero.getStats().getPow());
            ((TextView) v.findViewById(R.id.inv_frag_data_agile)).setText("Agile: " + hero.getStats().getAgile());
            ((TextView) v.findViewById(R.id.inv_frag_data_c_rate)).setText("Critical rate: " + hero.getStats().getC_rate());
            ((TextView) v.findViewById(R.id.inv_frag_data_c_dmg)).setText("Critical damage: " + hero.getStats().getC_dmg());

        },getActivity());

        AsyncFetchMethods.fetchPlayerInventory(inventoryResponse -> {

        }, DataStorage.getInstance().getPlayerId(), getActivity());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        init(view);
        return view;
    }
}