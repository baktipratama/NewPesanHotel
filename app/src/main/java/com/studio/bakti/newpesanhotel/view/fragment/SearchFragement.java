package com.studio.bakti.newpesanhotel.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studio.bakti.newpesanhotel.R;
import com.studio.bakti.newpesanhotel.model.SearchResult;
import com.studio.bakti.newpesanhotel.util.CardUtil;
import com.studio.bakti.newpesanhotel.util.ConstantaUtil;

import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by bakti on 3/29/15.
 */
public class SearchFragement extends BaseFragment {

    CardListView lvData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container,
                false);
        lvData = (CardListView) rootView.findViewById(R.id.myList);
        SearchResult result = (SearchResult) getActivity().getIntent().getSerializableExtra(ConstantaUtil.extraSearch);

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(
                getActivity(), CardUtil.getCards(getApplicationContext(),result.getItems()));
        lvData.setAdapter(mCardArrayAdapter);

         return rootView;
    }
}
