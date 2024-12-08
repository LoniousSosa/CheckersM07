package com.example.checkers_first;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReciclerAdapter extends RecyclerView.Adapter<ReciclerAdapter.FriendsViewHolder> {
    private final ArrayList<Friend> datos;
    Context context;

    public ReciclerAdapter(ArrayList<Friend> datos) {
        super();
        this.datos = datos;
    }
    public static final class FriendsViewHolder extends RecyclerView.ViewHolder {

        private final TextView username;
        private final TextView status;
        private final View item;


        public FriendsViewHolder(View item) {
            super(item);
            this.item = item;
            this.username = item.findViewById(R.id.usernameFriends);
            this.status = item.findViewById(R.id.statusFriends);
        }

        public TextView getUsername() {
            return this.username;
        }
        public TextView getStatus() {
            return this.status;
        }
        public View getItem() {return this.item;}

        public void bindFriend(Friend friend) {
            this.username.setText(friend.getNombre());
            if (friend.isStatus()){
                this.status.setText("Online");
            }
            else this.status.setText("Offline");
        }
    }

    @NonNull
    @Override
    public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.visual_recicler, parent, false);
        return new FriendsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {
        Friend friend = datos.get(position);
        holder.bindFriend(friend);
        holder.username.startAnimation(AnimationUtils.loadAnimation(
                holder.item.getContext(),R.anim.animation_one
        ));

        holder.status.startAnimation(AnimationUtils.loadAnimation(
                holder.item.getContext(),R.anim.animation_one
        ));
    }

    @Override
    public int getItemCount() {
        return this.datos.size();
    }

}
