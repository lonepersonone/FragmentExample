package com.example.buttontest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.buttontest.R;
import com.example.buttontest.ui.choice.ChoiceFragment;
import com.example.buttontest.ui.like.LikeFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private LikeFragment likeFragment;
    private ChoiceFragment choiceFragment;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        likeFragment = LikeFragment.newInstance();
        choiceFragment = ChoiceFragment.newInstance();
        getChildFragmentManager().beginTransaction().replace(R.id.linearLayout,choiceFragment).commit();
        TabLayout tabLayout = (TabLayout)root.findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getActivity(),tab.getText(),Toast.LENGTH_SHORT).show();
                if (tab.getText().equals("爱看")){
                    getChildFragmentManager().beginTransaction().replace(R.id.linearLayout,likeFragment).commit();
                }
                if (tab.getText().equals("精选")){
                    getChildFragmentManager().beginTransaction().replace(R.id.linearLayout,choiceFragment).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return root;
    }
}