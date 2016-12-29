package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.data.http.realm.entity.RealmString;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;
import com.example.mamingzhang.androidstructuretest.parcel.entity.Country;
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
import io.realm.RealmList;

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
 * <p>
 * TODO 1: 源码中对于ParcelClass注解中value值得使用理解上需要研究，结合RealmObject序列化深入验证
 * TODO 2: 不同序列化策略及其混合使用验证
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

        Country country = new Country();
        country.countryName = "China";
        RealmList<RealmString> languages = new RealmList<>();
        languages.add(new RealmString("Chinese"));
        country.languages = languages;
        argument.putParcelable("country", Parcels.wrap(country));

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

        Country country = Parcels.unwrap(argument.getParcelable("country"));
        builder.append("countryname---").append(country.countryName).append("\n");
        if (country.languages != null && country.languages.size() > 0) {
            for (RealmString language : country.languages) {
                builder.append("lanuage---").append(language.getVal()).append("\n");
            }
        }

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
