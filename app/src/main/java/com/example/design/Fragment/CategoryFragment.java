package com.example.design.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.model.Categories;
import com.example.design.Adapter.CategoryAdapter;
import com.example.design.R;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private RecyclerView category_recycler;
    private CategoryAdapter categoryAdapter;
    private Toolbar category_toolbar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_fragment, container, false);

        category_recycler = view.findViewById(R.id.category_recycler);

        //category_toolbar = view.findViewById(R.id.category_toolbar_layout);

        categoryList();
        return view;
    }

    public void categoryList() {

        categoryAdapter = new CategoryAdapter(getContext());

        category_recycler.setAdapter(categoryAdapter);
        category_recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<Categories> categories = new ArrayList<>();

        categories.add(new Categories("action", 11));
        categories.add(new Categories("advent", 12));
        categories.add(new Categories("anim", 13));
        categories.add(new Categories("com", 14));
        categories.add(new Categories("dram", 15));
        categories.add(new Categories("fanta", 16));
        categories.add(new Categories("horr", 17));
        categories.add(new Categories("music", 18));
        categories.add(new Categories("myster", 19));
        categories.add(new Categories("roman", 20));
        categories.add(new Categories("science", 21));
        categories.add(new Categories("thrill", 22));
        categories.add(new Categories("west", 23));

        categoryAdapter.setCategories(categories);
    }

}