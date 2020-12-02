package com.bchong.sutdeets;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerView_Confg {
    private Context mContext;
    private EventsAdapter mEventsAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Events> events,List<String> keys){
        mContext=context;
        mEventsAdapter=new EventsAdapter(events,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mEventsAdapter);
    }
    class EventItemview extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDate;
        private TextView mLocation;
        private TextView mTimeStart;
        private TextView mTimeEnd;
        private TextView mDescription;
//        private ImageView mPurl;

        private String key;
        public EventItemview(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.event_list_item,parent,false));
            mTitle=(TextView) itemView.findViewById(R.id.title_txtView);
            mDate=(TextView) itemView.findViewById(R.id.Date_txtView);
            mLocation=(TextView) itemView.findViewById(R.id.location_txtView);
            mTimeStart=(TextView) itemView.findViewById(R.id.timeStart_txtView);
            mTimeEnd=(TextView) itemView.findViewById(R.id.timeEnd_txtView);
            mDescription=(TextView) itemView.findViewById(R.id.Description_txtView);
//            mPurl=(ImageView) itemView.findViewById(R.id.image_txtView);

        }
        public void  bind(Events events,String key,EventItemview holder){
            mTitle.setText(events.getTitle());
            mDate.setText(events.getDate());
            mLocation.setText(events.getLocation());
            mTimeEnd.setText(events.getTimeEnd());
            mTimeStart.setText(events.getTimeStart());
            mDescription.setText(events.getDescription());
//            Glide.with(holder.mPurl.getContext()).load(events.getPurl()).into(mPurl);
            this.key=key;
        }
    }
    class EventsAdapter extends RecyclerView.Adapter<EventItemview>{
        private List<Events> mEventList;
        private List<String> mKeys;

        public EventsAdapter(List<Events> mEventList, List<String> mKeys) {
            this.mEventList = mEventList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public EventItemview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new EventItemview(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull EventItemview holder, int position) {
            holder.bind(mEventList.get(position),mKeys.get(position),holder);
        }

        @Override
        public int getItemCount() {
            return mEventList.size();
        }
    }
}