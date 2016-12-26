package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;
import com.example.mamingzhang.androidstructuretest.parcel.entity.Family;
import com.example.mamingzhang.androidstructuretest.parcel.entity.Man;
import com.example.mamingzhang.androidstructuretest.parcel.entity.Person;
import com.example.mamingzhang.androidstructuretest.parcel.entity.Woman;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mamingzhang on 16/12/26.
 * <p>
 * 验证Android Parceler库对序列化的支持
 * <p>
 * 相关参考资料：
 * 1. https://github.com/johncarl81/parceler
 * 2. http://www.jianshu.com/p/2d7ffaa60185
 * 3. http://ryanharter.com/blog/2016/04/08/autovalue-deep-dive/
 * 4. http://ryanharter.com/blog/2016/03/22/autovalue/
 * 5. https://nullpointer.wtf/android/using-retrofit-realm-parceler/
 */

public class BasicParcelerExampleFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;

    @BindView(R.id.txtView)
    TextView txtView;

    @Override
    protected void configArguments() {
        Bundle argument = new Bundle();

        List<Person> familyPersons1 = new ArrayList<>();
        Man man1 = new Man();
        man1.setName("man1");
        familyPersons1.add(man1);
        Woman woman1 = new Woman();
        woman1.setName("woman1");
        familyPersons1.add(woman1);

        List<Person> familyPersons2 = new ArrayList<>();
        Man man2 = new Man();
        man2.setName("man2");
        familyPersons2.add(man2);
        Woman woman2 = new Woman();
        woman2.setName("woman2");
        familyPersons2.add(woman2);

        Family family = new Family(familyPersons1, familyPersons2);

        argument.putParcelable("family", Parcels.wrap(family));

        setArguments(argument);
    }

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_basicparcel;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        Bundle argument = getArguments();

        Family family = Parcels.unwrap(argument.getParcelable("family"));

        StringBuilder builder = new StringBuilder();

        builder.append("Begin FamilyPerson1").append("\n\n");
        if (family != null && family.getFamilyPersons1() != null && family.getFamilyPersons1().size() > 0) {

            for (Person person : family.getFamilyPersons1()) {
                builder.append(person.getClass().getSimpleName()).append("---").append(person.getName()).append("\n");
            }

        }
        builder.append("\n").append("End FamilyPerson1").append("\n\n");

        builder.append("Begin FamilyPerson2").append("\n\n");
        if (family != null && family.getFamilyPersons2() != null && family.getFamilyPersons2().size() > 0) {

            for (Person person : family.getFamilyPersons2()) {
                builder.append(person.getClass().getSimpleName()).append("---").append(person.getName()).append("\n");
            }

        }
        builder.append("\n").append("End FamilyPerson2").append("\n\n");

        txtView.setText(builder.toString());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }
}
