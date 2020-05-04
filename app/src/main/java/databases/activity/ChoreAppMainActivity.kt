package databases.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kush.learningkotlin.R
import databases.data.ChoresDatabaseHandler
import databases.model.ChoreModel
import kotlinx.android.synthetic.main.activity_chore_app_main.*

class ChoreAppMainActivity : AppCompatActivity() {

    var dbHandler: ChoresDatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chore_app_main)

        dbHandler = ChoresDatabaseHandler(this)

        checkDB()

        saveChoreBtn.setOnClickListener {
            if (!TextUtils.isEmpty(enterAChoreID.text.toString())
                && !TextUtils.isEmpty(assignByID.text.toString())
                &&  !TextUtils.isEmpty(assignToID.text.toString())) {
                //save to database
                var chore = ChoreModel()
                chore.choreName = enterAChoreID.text.toString()
                chore.assignTo = assignToID.text.toString()
                chore.assignBy = assignByID.text.toString()

                saveChore(chore)

                startActivity(Intent(this, ChoreListActivity::class.java))


            } else {
                Toast.makeText(this, "Please enter a chore", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun checkDB() {
        if (dbHandler!!.choreCount() > 0) {
            startActivity(Intent(this, ChoreListActivity::class.java))
        }
    }

    private fun saveChore(chore: ChoreModel) {
        dbHandler?.createChore(chore)
    }

}
