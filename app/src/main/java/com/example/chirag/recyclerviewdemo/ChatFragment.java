package com.example.chirag.recyclerviewdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.recyclerviewdemo.Adapters.ChatAdapter;
import com.example.chirag.recyclerviewdemo.Model.Chat;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRvChat;
    private ArrayList<Chat> chatArrayList = new ArrayList<>();

    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

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
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRvChat = (RecyclerView) view.findViewById(R.id.rv_chat);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRvChat.setLayoutManager(layoutManager);
        createDummyData();

        ChatAdapter chatAdapter = new ChatAdapter(getActivity(),chatArrayList);
        mRvChat.setAdapter(chatAdapter);

    }
    private void createDummyData() {
        for (int i = 0; i < 10 ; i++) {
            Chat chat = new Chat();
            chat.setChatName("Chirag");
            chat.setChatContent("Hi i am using chat");
            String imageUrl;
            imageUrl = "https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg";
            chat.setThumb(imageUrl);
            chatArrayList.add(chat);
        }
    }
}
