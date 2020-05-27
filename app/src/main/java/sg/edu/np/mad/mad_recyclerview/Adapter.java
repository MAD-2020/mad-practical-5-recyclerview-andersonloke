
package sg.edu.np.mad.mad_recyclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    final String TAG = "Adapter";
    ArrayList<ToDo> data;


    public Adapter(ArrayList<ToDo> input) {
        data = input;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        return new ViewHolder(item);
    }

    public void onBindViewHolder(ViewHolder holder,final int position) {
        String s = data.get(position).getName();
        holder.txt.setText(s);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "onClicked CLicked");
                String positionName = data.get(position).getName();
                Log.v(TAG, String.valueOf(positionName));
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Delete");
                builder.setTitle("Are you sure you want to delete\n" + positionName + "?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        notifyDataSetChanged();
                        dialog.cancel();
                    }
                });

                AlertDialog alert = builder.create();
                alert.setCancelable(false);
                alert.show();
            }
        });
    }
    public int getItemCount() {
        return data.size();
    }
}
