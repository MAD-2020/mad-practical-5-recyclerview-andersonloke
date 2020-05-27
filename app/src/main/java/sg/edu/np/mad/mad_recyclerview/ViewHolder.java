package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    CheckBox checkBox;
    public ViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.txt1);
        checkBox = itemView.findViewById(R.id.checkbox1);
    }


}
