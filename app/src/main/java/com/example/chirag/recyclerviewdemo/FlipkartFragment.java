package com.example.chirag.recyclerviewdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.recyclerviewdemo.Adapters.FlipkartAdapter;
import com.example.chirag.recyclerviewdemo.Model.Flipkart;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlipkartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlipkartFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRvFlipkart;
    private ArrayList<Flipkart> flipkartArrayList = new ArrayList<>();


    public FlipkartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlipkartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlipkartFragment newInstance(String param1, String param2) {
        FlipkartFragment fragment = new FlipkartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        return inflater.inflate(R.layout.fragment_flipkart, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRvFlipkart = (RecyclerView) view.findViewById(R.id.rv_flipkart);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRvFlipkart.setLayoutManager(layoutManager);
        createDummyData();
        FlipkartAdapter flipkartAdapter = new FlipkartAdapter(getActivity(), flipkartArrayList);
        mRvFlipkart.setAdapter(flipkartAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

    private void createDummyData() {
        for (int i = 0; i < 10; i++) {
            Flipkart flipkart = new Flipkart();
            flipkart.setProductName("MOTO G4 PLUS");
            flipkart.setProductPrice("14000");
            String imageUrl;
            imageUrl = "https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg";
            flipkart.setImageUrl(imageUrl);
            flipkartArrayList.add(flipkart);
        }
    }
}