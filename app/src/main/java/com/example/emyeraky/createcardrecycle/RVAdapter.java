package com.example.emyeraky.createcardrecycle;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Emy Eraky on 12/6/2017.
 */
//1
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {
    List<Person> persons;

    //add a constructor to the custom adapter so that it has a handle to the data that the RecyclerView displays.
    RVAdapter(List<Person> persons) {
        this.persons = persons;
    }

    //this method is called when the custom ViewHolder needs to be initialized after layout item called.
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    // to specify the contents of each item of the RecyclerView.      4
    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int position) {
        personViewHolder.personName.setText(persons.get(position).name);
        personViewHolder.personAge.setText(persons.get(position).age);
        personViewHolder.personPhoto.setImageResource(persons.get(position).photoId);

        personViewHolder.cv.setTag(position);
    }

    //Returns the total number of items in the data set held by the adapter
    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    //view holder design pattern    2
    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            personName = (TextView) itemView.findViewById(R.id.person_name);
            personAge = (TextView) itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView) itemView.findViewById(R.id.person_photo);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = (int) view.getTag();

            Toast.makeText(view.getContext(),Integer.toString(position), Toast.LENGTH_SHORT).show();
        }
    }


}
