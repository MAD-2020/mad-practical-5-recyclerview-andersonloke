package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<ToDo> data = new ArrayList<>();
    Button Add;
    private static final String TAG = "Recycler Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = findViewById(R.id.Name);
        Add = findViewById(R.id.Submit);

        /**Init ToDo list*/
        data.add(new ToDo("Buy Milk"));
        data.add(new ToDo("Send Postage"));
        data.add(new ToDo("Buy Android development book"));

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Adapter mAdapter = new Adapter(data);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = getName(text);
                if (name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Try Again!",Toast.LENGTH_SHORT).show();
                }
                else{
                    data.add(new ToDo(name));
                    showNewEntry(recyclerView, data);
                }
            }
        });


    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data) {
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }

    public String getName(TextView textView){
        return textView.getText().toString();
    }
}



