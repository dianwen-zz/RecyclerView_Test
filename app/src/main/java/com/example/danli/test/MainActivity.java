package com.example.danli.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerAdapter(Arrays.asList("hi", "this", "is", "some", "text"));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("clicked", view.toString());
            }
        });
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {
        public class Holder extends RecyclerView.ViewHolder {
            protected TextView textView;

            public Holder(TextView itemView) {
                super(itemView);
                this.textView = itemView;
            }

        }

        private List<String> contents;

        public RecyclerAdapter(List<String> contents) {
            this.contents = contents;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(new TextView(parent.getContext()));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.textView.setText(contents.get(position));
        }

        @Override
        public int getItemCount() {
            return contents.size();
        }

    }
}
