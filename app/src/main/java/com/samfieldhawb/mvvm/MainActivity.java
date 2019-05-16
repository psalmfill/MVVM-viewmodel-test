package com.samfieldhawb.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.samfieldhawb.mvvm.adapters.RecyclerAdapter;
import com.samfieldhawb.mvvm.models.NicePlace;
import com.samfieldhawb.mvvm.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private FloatingActionButton mFab;
    private RecyclerAdapter mAdapter;
    private MainActivityViewModel mMainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv);
        mProgressBar = findViewById(R.id.progressBar);
        mFab = findViewById(R.id.floatingActionButton);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNiceplaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(@Nullable List<NicePlace> nicePlaces) {
                mAdapter.notifyDataSetChanged();
                mRecyclerView.scrollToPosition(mMainActivityViewModel.getNiceplaces().getValue().size()-1);
            }
        });
        mMainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(mMainActivityViewModel.getIsUpdating().getValue()){
                    showProgressBar();
                }else {
                    hideProgressBar();
                }
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 NicePlace nicePlace = new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/BordeauxVineyard2013Cadillac.jpg","Uyo");
                 mMainActivityViewModel.addNiceplace(nicePlace);
            }
        });
        mAdapter = new RecyclerAdapter(this,mMainActivityViewModel.getNiceplaces().getValue());
        mRecyclerView.setAdapter(mAdapter);
        hideProgressBar();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void showProgressBar(){mProgressBar.setVisibility(View.VISIBLE);}
    public void hideProgressBar(){mProgressBar.setVisibility(View.GONE);}
}
