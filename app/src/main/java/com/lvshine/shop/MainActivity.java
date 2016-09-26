package com.lvshine.shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.lvshine.shop.bean.Tab;
import com.lvshine.shop.fragment.CartFragment;
import com.lvshine.shop.fragment.CategoryFragment;
import com.lvshine.shop.fragment.HomeFragment;
import com.lvshine.shop.fragment.HotFragment;
import com.lvshine.shop.fragment.MineFragment;
import com.lvshine.shop.widget.FragmentTabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LayoutInflater mInflater;
            private FragmentTabHost mTabhost;
            private ArrayList<Tab> mTabs= new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {
        Tab tab_Home = new Tab(HomeFragment.class,R.string.home,R.drawable.selector_icon_home);
        Tab tab_Cart = new Tab(CartFragment.class,R.string.cart,R.drawable.selector_icon_cart);
        Tab tab_Category = new Tab(CategoryFragment.class,R.string.catagory,R.drawable.selector_icon_category);
        Tab tab_Hot = new Tab(HotFragment.class,R.string.hot,R.drawable.selector_icon_hot);
        Tab tab_Mine = new Tab(MineFragment.class,R.string.mine,R.drawable.selector_icon_mine);

        mTabs.add(tab_Home);
        mTabs.add(tab_Cart);
        mTabs.add(tab_Category);
        mTabs.add(tab_Hot);
        mTabs.add(tab_Mine);


        mInflater = LayoutInflater.from(this);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

        for (Tab tab : mTabs){

            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));






            tabSpec.setIndicator(buildIndicator(tab));

            mTabhost.addTab(tabSpec,tab.getFragment(),null);



        }

        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);
    }

    private View buildIndicator(Tab tab) {
        View view =mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);
        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return view;

    }

}
