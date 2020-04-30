package com.az.lettersort;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.az.lettersort.azList.AZSideBarView;
import com.az.lettersort.azList.AZTitleDecoration;
import com.az.lettersort.azList.BaseSortBean;
import com.az.lettersort.azList.SortUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据首字母快速排序分类定位
 */
public class MainActivity extends AppCompatActivity {


    List<BaseSortBean> list = new ArrayList<>();
    List<String> strList = new ArrayList<>();


    private Context mContext;
    private RecyclerView mRecyclerView;
    private AZSideBarView mBarList;
    private ItemAdapter mAdapter;
    List<String> letterList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mRecyclerView = findViewById(R.id.recycler_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new AZTitleDecoration(new AZTitleDecoration.TitleAttributes(mContext)));
        mBarList = findViewById(R.id.bar_list);

        initData();
        initSortList();
        initEvent();

    }

    /**
     * 初始化，排序数据
     */
    private void initSortList() {
        SortUtils.sortForListToInitials(list, true);

        letterList.clear();
        for (BaseSortBean sortBean : list){
            if (!letterList.contains(sortBean.getInitials())){
                letterList.add(sortBean.getInitials());
            }
        }

        mAdapter = new ItemAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
        mBarList.setmLetters(letterList);

    }

    private void initEvent() {
        mBarList.setOnLetterChangeListener(new AZSideBarView.OnLetterChangeListener() {
            @Override
            public void onLetterChange(String letter) {
                int position = mAdapter.getSortLettersFirstPosition(letter);
                if (position != -1) {
                    if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                        LinearLayoutManager manager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                        manager.scrollToPositionWithOffset(position, 0);
                    } else {
                        mRecyclerView.getLayoutManager().scrollToPosition(position);
                    }
                }
            }
        });
    }

    private void initData() {
        strList.add("兄弟");
        strList.add("UI");
        strList.add("禅道");
        strList.add("当然");
        strList.add("而且");
        strList.add("个人");
        strList.add("领取");
        strList.add("好人");
        strList.add("天天");
        strList.add("接口");
        strList.add("考虑");
        strList.add("不是");
        strList.add("牧师");
        strList.add("牛逼");
        strList.add("欧赔");
        strList.add("脾气");
        strList.add("期望");
        strList.add("飞哥");
        strList.add("人事");
        strList.add("收到");
        strList.add("爱情");
        strList.add("VB");
        strList.add("晚上");
        strList.add("详情");
        strList.add("用的");
        strList.add("阵容");
        strList.add("安心");


        list.add(new SortBean("兄弟", "i"));
        list.add(new SortBean("UI", "u"));
        list.add(new SortBean("禅道", "c"));
        list.add(new SortBean("当然", "d"));
        list.add(new SortBean("而且", "e"));
        list.add(new SortBean("个人", "g"));
        list.add(new SortBean("领取", "l"));
        list.add(new SortBean("好人", "h"));
        list.add(new SortBean("天天", "t"));
        list.add(new SortBean("接口", "j"));
        list.add(new SortBean("考虑", "k"));
        list.add(new SortBean("不是", "b"));
        list.add(new SortBean("牧师", "m"));
        list.add(new SortBean("牛逼", "n"));
        list.add(new SortBean("欧赔", "o"));
        list.add(new SortBean("脾气", "p"));
        list.add(new SortBean("期望", "q"));
        list.add(new SortBean("飞哥", "f"));
        list.add(new SortBean("人事", "r"));
        list.add(new SortBean("收到", "s"));
        list.add(new SortBean("爱情", "a"));
        list.add(new SortBean("VB", "v"));
        list.add(new SortBean("晚上", "w"));
        list.add(new SortBean("详情", "x"));
        list.add(new SortBean("用的", "y"));
        list.add(new SortBean("阵容", "z"));
        list.add(new SortBean("安心", "a"));



    }
}
