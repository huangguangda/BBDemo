package cn.edu.gdmec.android.bbdemo.fragment;

/**
 * Created by apple on 18/3/27.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.gdmec.android.BBDemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExercisesFragment extends Fragment {


    public ExercisesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercises, container, false);
    }

}
