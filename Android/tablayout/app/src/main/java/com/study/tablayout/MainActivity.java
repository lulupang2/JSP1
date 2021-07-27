package com.study.tablayout;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setSupportActionBar : 액션바 설정
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //액션바 기본 타이틀 보여지지 않게
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        //Fragment : 탭 클릭시 보여줄 화면들
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        //기본으로 첫번째 Fragment를 보여지도록 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();


        //TabLayout에 Tab 3개 추가
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setIcon(R.drawable.cat));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.dog));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.bunny));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.horse));

        //탭 선택리스너
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //탭선택시
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                } else if (position == 2) {
                    selected = fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            //탭선택해제시
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            //선탭된탭을 다시 클릭시
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
