package com.example.chirag.recyclerviewdemo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chirag.recyclerviewdemo.Model.Chat;
import com.example.chirag.recyclerviewdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by chirag on 07-Apr-17.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private Context context;
    private ArrayList<Chat> chatArrayList;

    public ChatAdapter(Context context,ArrayList<Chat> chatArrayList){
        this.context = context;
        this.chatArrayList = chatArrayList;
    }


    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chat,parent,false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ChatViewHolder holder, int position) {
        Chat chat = chatArrayList.get(position);
        holder.mTvChatContent.setText(chat.getChatContent());
        holder.mTvChatName.setText(chat.getChatName());
        Picasso.with(context).load(chat.getThumb()).into(holder.mIvChatImage);

    }

    @Override
    public int getItemCount() {
        return chatArrayList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvChatImage;
        private TextView mTvChatName;
        private TextView mTvChatContent;


        public ChatViewHolder(View itemView){
            super(itemView);
            mIvChatImage = (ImageView) itemView.findViewById(R.id.iv_chat_image);
            mTvChatName = (TextView) itemView.findViewById(R.id.tv_chat_name);
            mTvChatContent = (TextView) itemView.findViewById(R.id.tv_chat_content);
        }
    }
}
