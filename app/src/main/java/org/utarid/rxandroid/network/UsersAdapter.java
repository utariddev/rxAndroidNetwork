package org.utarid.rxandroid.network;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.utarid.rxandroid.network.network.model.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.PostViewHolder> {

    private Context context;
    private List<User> usersList;

    public UsersAdapter(Context context, List<User> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_row, parent, false);

        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        User user = usersList.get(position);
        holder.tv_title.setText(user.getName());
        holder.tv_id.setText(String.valueOf(user.getId()));
        holder.tv_body.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_id;
        public TextView tv_title;
        public TextView tv_body;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_body = itemView.findViewById(R.id.tv_body);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_id = itemView.findViewById(R.id.tv_id);

        }
    }
}
