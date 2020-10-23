package sheridan.jawedzak.collegedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sheridan.jawedzak.collegedata1.databinding.ActivityOutputBinding
import sheridan.jawedzak.collegedata1.model.CollegeData

class OutputActivity : AppCompatActivity() {

    companion object{
        const val COLLEGE_DATA = "college_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //view Binding
        val college = intent.getSerializableExtra(COLLEGE_DATA) as CollegeData
        with (binding){
            lblStudentNme.text = "Student Name: " + college.stuName.toString()
            lblProgram.text = "Program: " + college.program

            btnBack.setOnClickListener { finish() }
        }
    }
}