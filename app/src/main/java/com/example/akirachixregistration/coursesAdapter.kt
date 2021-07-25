package

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.resources.R
import androidx.recyclerview.widget.RecyclerView
import com.example.akirachixregistration.courses

class CoursesAdapter(var courseList: List<courses>): RecyclerView.Adapter<CoursesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.course_item_list,parent,false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(coursesViewHolder: CoursesViewHolder, position: Int) {
        var currentCourse = courseList.get(position)
        coursesViewHolder.tvcoursename.text = currentCourse.coursename
        coursesViewHolder.tvcode.text = currentCourse.Code
        coursesViewHolder.tvDescription.text = currentCourse.Description
        coursesViewHolder.tvInstructor.text = currentCourse.Instructor
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}

class CoursesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvcoursename = itemView.findViewById<TextView>(R.id.tvcoursename)
    var tvcode = itemView.findViewById<TextView>(R.id.tvcode)
    var tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    var tvInstructor = itemView.findViewById<TextView>(R.id.tvInstructor)
    var etemail=itemView.findViewById<TextView>(R.id.etemail)
    var etpassword=itemView.findViewById<TextView>(R.id.etpassword)
}