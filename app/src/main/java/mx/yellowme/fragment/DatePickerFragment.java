package mx.yellowme.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;


/**
 * Created by javikin on 5/23/16.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private NoticeDialogListener mListener;

    public static DatePickerFragment newInstance(Long dateLimit, int year, int month, int day) {
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putInt("year", year);
        args.putInt("month", month);
        args.putInt("day", day);
        if(dateLimit != null)
            args.putLong("dateLimit", dateLimit);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year = getArguments().getInt("year");
        int month = getArguments().getInt("month");
        int day = getArguments().getInt("day");
        Long dateLimit = null;
        try{
            dateLimit = getArguments().getLong("dateLimit");
        }catch (Exception ex){}
        DatePickerDialog dpd =  new DatePickerDialog(getActivity(), this, year, month, day);
        if(dateLimit!=null)
            dpd.getDatePicker().setMinDate(dateLimit);
        return dpd;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        mListener.onDateSet(view, year, month, day);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " no seas pato no pusiste el NoticeDialogListener al activity");
        }
    }

    public interface NoticeDialogListener {
        public void onDateSet(DatePicker view, int year, int month, int day);
    }
}