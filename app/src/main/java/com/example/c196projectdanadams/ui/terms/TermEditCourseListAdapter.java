package com.example.c196projectdanadams.ui.terms;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.data.entity.CourseEntity;
import com.example.c196projectdanadams.data.entity.TermEntity;
import com.example.c196projectdanadams.ui.courses.CourseEditAssessmentListActivity;

import java.util.List;

public class TermEditCourseListAdapter extends RecyclerView.Adapter<TermEditCourseListAdapter.CourseViewHolder> {

    private final LayoutInflater mInflater;
    private final Context context;
    private List<CourseEntity> mCourses;

    public TermEditCourseListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseItemView;

        private CourseViewHolder(View itemView){
            super(itemView);
            courseItemView = itemView.findViewById(R.id.course_item_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    int position = getAdapterPosition();
                    final CourseEntity currentCourse = mCourses.get(position);
                    Intent intent = new Intent(context, CourseEditAssessmentListActivity.class);
                    intent.putExtra("courseID", currentCourse.getCourseID());
                    intent.putExtra("termID", currentCourse.getTermID());
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_list_item, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        if(mCourses != null) {
            final CourseEntity currentCourse = mCourses.get(position);
            holder.courseItemView.setText((currentCourse.getCourseTitle()));

        } else {
            holder.courseItemView.setText("no title");
        }
    }

    @Override
    public int getItemCount() {
        if (mCourses != null)
            return mCourses.size();
        else return 0;
    }

    public void setCourses(List<CourseEntity> courses) {
        mCourses = courses;
        notifyDataSetChanged();
    }
}
