package sheridan.jawedzak.collegedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import sheridan.jawedzak.collegedata1.databinding.ActivityInputBinding
import sheridan.jawedzak.collegedata1.model.CollegeData

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener { send() }
    }

    private fun send(){

        val studentName = binding.txtStudentName.text.toString()
        var program = ""

        program = if (binding.chkDiploma.isChecked){
            "Diploma"
        }
        else {
            "Degree"
        }

        if (studentName.isNotEmpty() ){
            val collegeData = CollegeData(studentName.toString(), program.toString())
            val intent = Intent(this, OutputActivity::class.java).apply {
                putExtra(OutputActivity.COLLEGE_DATA, collegeData)
            }
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Student name field is required", Toast.LENGTH_SHORT).show()
        }
    }
}