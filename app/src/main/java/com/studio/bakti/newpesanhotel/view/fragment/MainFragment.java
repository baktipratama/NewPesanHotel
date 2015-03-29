package com.studio.bakti.newpesanhotel.view.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.app.DatePickerDialog.OnDateSetListener;
import com.studio.bakti.newpesanhotel.R;
import com.studio.bakti.newpesanhotel.SearchActivity;
import com.studio.bakti.newpesanhotel.controller.DataController;
import com.studio.bakti.newpesanhotel.model.SearchResult;
import com.studio.bakti.newpesanhotel.model.Token;
import com.studio.bakti.newpesanhotel.task.IResponse;
import com.studio.bakti.newpesanhotel.util.ConstantaUtil;
import com.studio.bakti.newpesanhotel.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by bakti on 3/28/15.
 */
public class MainFragment extends BaseFragment {
    private String token;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText etFrom,etTo,etKey,etRoom,etPerson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container,
                false);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        final EditText etData = (EditText)rootView.findViewById(R.id.etData);
        Button bSearch = (Button) rootView.findViewById(R.id.bSearch);
        etFrom = (EditText) rootView.findViewById(R.id.etFrom);
        etTo = (EditText) rootView.findViewById(R.id.etTo);
        etKey = (EditText) rootView.findViewById(R.id.etData);
        etRoom = (EditText) rootView.findViewById(R.id.etRoomNumber);
        etPerson = (EditText) rootView.findViewById(R.id.etPerson);

        etFrom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fromDatePickerDialog.show();
                return false;
            }
        });
        etTo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                toDatePickerDialog.show();
                return false;
            }
        });
        bSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String key = etKey.getText().toString();
                String dayFrom = etFrom.getText().toString();
                String dayTo = etTo.getText().toString();
                int night = DateUtil.diff(dayFrom,dayTo);
                int room = Integer.parseInt(etRoom.getText().toString());
                int person = Integer.parseInt(etPerson.getText().toString());
                searchHotel(key,dayFrom,night,dayTo,room,person);
            }
        });
        setDateTimeField();
        Log.i("Fragment", "OK");
        return rootView;
    }
    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(getCurrentContext(), new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etFrom.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(getCurrentContext(), new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etTo.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void searchHotel(String key, String sDate, int night, String eDate, int room, int adult){
        DataController.getInstance(getApplicationContext())
                .getAllSearch(new IResponse() {
                    @Override
                    public void onSuccess(Object o) {
                        dismissProgressDialog();
                        SearchResult result = (SearchResult)o;
                        Intent i = new Intent(getCurrentContext(), SearchActivity.class);
                        i.putExtra(ConstantaUtil.extraSearch,result);
                        getCurrentContext().startActivity(i);
                    }

                    @Override
                    public void onError(Object o) {
                        dismissProgressDialog();
                        Exception t = (Exception) o;
                        Toast.makeText(getActivity().getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStart() {
                        showProgressDialog("Load your data","Please Wait");
                    }

                },key,sDate,night,eDate,room,adult);
    }
}
