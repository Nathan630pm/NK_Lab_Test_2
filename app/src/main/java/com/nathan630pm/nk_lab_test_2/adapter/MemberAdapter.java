package com.nathan630pm.nk_lab_test_2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nathan630pm.nk_lab_test_2.R;
import com.nathan630pm.nk_lab_test_2.activities.MemberActivity;
import com.nathan630pm.nk_lab_test_2.database.model.Member;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MyViewHolder> {
    private ArrayList<Member> members;
    private Context context;
    public MemberAdapter(ArrayList<Member> members, Context context) {
        this.members = members;
        this.context = context;
    }


    @NonNull
    @Override
    public MemberAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAdapter.MyViewHolder holder, int position) {
        Member item = members.get(position);
        holder.tvTitle.setText(item.name);
        holder.tvEmail.setText(item.email);
        Picasso.get()
                .load(R.drawable.ic_person)
                .placeholder(R.drawable.ic_person)
                .into(holder.img);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MemberActivity.class);
                i.putExtra("member", item.MemberId);
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return members.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvEmail;
        private ImageView img;
        private RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            img = itemView.findViewById(R.id.img);
            layout = itemView.findViewById(R.id.membersLayout);
        }

    }

}
