package com.xrzj.decoration.ui.other.collection.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xrzj.decoration.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialCollectionFragment extends Fragment {


    public MaterialCollectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.material_collection_fragment, container, false);
    }

}
