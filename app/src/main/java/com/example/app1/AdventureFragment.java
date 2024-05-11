package com.example.app1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;


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
    public ConstraintLayout createNewTabElem(String name){
        //create element
        ConstraintLayout record = new ConstraintLayout(requireContext());
        record.setId(View.generateViewId());
        record.setLayoutParams(new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                160
        ));
        record.setBackgroundColor(Color.CYAN);

        //create and add textview
        TextView textView = new TextView(requireContext());
        textView.setId(View.generateViewId());
        textView.setText(name);
        textView.setTextColor(Color.WHITE);
        record.addView(textView);

        //create and add btn1
        ImageButton imageButton = new ImageButton(requireContext());
        imageButton.setId(View.generateViewId());
        imageButton.setLayoutParams(new ConstraintLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT));
        imageButton.setImageResource(R.drawable.more);
        record.addView(imageButton);

        //create and add btn2
        ImageButton imageButton2 = new ImageButton(requireContext());
        imageButton2.setId(View.generateViewId());
        imageButton2.setLayoutParams(new ConstraintLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT));
        imageButton2.setImageResource(R.drawable.adventure);
        record.addView(imageButton2);

        //setup positions
        ConstraintSet res_set =  new ConstraintSet();
        res_set.clone(record);

        res_set.connect(textView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        res_set.connect(textView.getId(), ConstraintSet.END, imageButton.getId(), ConstraintSet.START, 0);
        res_set.connect(textView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        res_set.connect(textView.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);

        res_set.connect(imageButton.getId(),ConstraintSet.END,imageButton2.getId(),ConstraintSet.START,0);

        res_set.connect(imageButton2.getId(),ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,0);

        res_set.applyTo(record);
        return record;
    }

    public void init(View v) {

//        <androidx.constraintlayout.widget.ConstraintLayout
//        android:id="@+id/list_elem_2"
//        android:layout_width="0dp"
//        android:layout_height="80dp"
//        app:layout_constraintLeft_toLeftOf="parent"
//        app:layout_constraintRight_toRightOf="parent"
//        app:layout_constraintTop_toBottomOf="@+id/list_elem_1">
//            <TextView
//        android:id="@+id/rec2"
//        android:layout_width="0dp"
//        android:layout_height="0dp"
//        android:textColor="@color/white"
//        android:text="TextView"
//        app:layout_constraintBottom_toBottomOf="parent"
//        app:layout_constraintEnd_toEndOf="parent"
//        app:layout_constraintStart_toStartOf="parent"
//        app:layout_constraintTop_toTopOf="parent" />
//        </androidx.constraintlayout.widget.ConstraintLayout>


        ConstraintLayout par = v.findViewById(R.id.adv_list_parent);

        ConstraintLayout rec = createNewTabElem("test");
        ConstraintLayout rec2 = createNewTabElem("test2");
        par.addView(rec);
        par.addView(rec2);

        ConstraintSet res_set =  new ConstraintSet();
        res_set.clone(par);

        res_set.connect(
                rec.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0
        );
        res_set.connect(
                rec.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0
        );
        res_set.connect(
                rec.getId(), ConstraintSet.TOP, R.id.list_elem_1, ConstraintSet.BOTTOM, 0
        );

        res_set.connect(
                rec2.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0
        );
        res_set.connect(
                rec2.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0
        );
        res_set.connect(
                rec2.getId(), ConstraintSet.TOP, rec.getId(), ConstraintSet.BOTTOM, 0
        );

        res_set.applyTo(par);



//        TextView tv_rec = new TextView(requireContext());
//        tv_rec.setText("Location Name");
//        tv_rec.setTextColor(Color.WHITE);
//
//
//
//        TableLayout stk = (TableLayout) v.findViewById(R.id.table_main);
//        TableRow tbrow0 = new TableRow(requireContext());
//
//        TextView tv0 = new TextView(requireContext());
//        tv0.setText("Location Name");
//        tv0.setTextColor(Color.WHITE);
//        tbrow0.addView(tv0);
//        TextView tv1 = new TextView(requireContext());
//        tv1.setText("Requied Level");
//        tv1.setTextColor(Color.WHITE);
//        tbrow0.addView(tv1);
//        stk.addView(tbrow0);

//        AsyncFetchMethods.fetchLocations(location -> {
//            TableRow tbrow = new TableRow(requireContext());
//
//            TextView t1v = new TextView(requireContext());
//            t1v.setText(location.getName());
//            t1v.setTextColor(Color.WHITE);
//            t1v.setGravity(Gravity.CENTER);
//            tbrow.addView(t1v);
//
//            TextView t2v = new TextView(requireContext());
//            t2v.setText(location.getMin_lv().toString());
//            t2v.setTextColor(Color.WHITE);
//            t2v.setGravity(Gravity.CENTER);
//            tbrow.addView(t2v);
//
//            stk.addView(tbrow);
//        },getActivity());

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