package the_martian_chronicles.android.the_martian_chronicles;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DateActivity extends AppCompatActivity {
    long from;
    long to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        ButterKnife.bind(this);
        SharedPreferences preferences = getSharedPreferences("common", MODE_PRIVATE);
        from=preferences.getLong("from",System.currentTimeMillis());
        to=preferences.getLong("to",System.currentTimeMillis()+1000*60*60*24*7);

    }

    @OnClick(R.id.from)
    void onFromClick(View view){
        Calendar calendar=getCalendarByDate(from);
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,day);
                from=calendar.getTimeInMillis();
                Toast.makeText(getApplicationContext(), "Selected ", Toast.LENGTH_SHORT).show();
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.to)
    void onToClick(View view){
        Calendar calendar=getCalendarByDate(to);
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,day);
                to=calendar.getTimeInMillis();
                Toast.makeText(getApplicationContext(), "Selected ", Toast.LENGTH_SHORT).show();
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.save)
    void onSaveClick(View view){
        SharedPreferences preferences = getSharedPreferences("common",MODE_PRIVATE);
        preferences.edit().putLong("from",from).apply();
        preferences.edit().putLong("to",to).apply();
        finish();
    }

    public static Calendar getCalendarByDate(long date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        return calendar;
    }

}
