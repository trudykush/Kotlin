package databases.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kush.learningkotlin.R
import databases.data.ChoreListAdapter
import databases.data.ChoresDatabaseHandler
import databases.model.ChoreModel
import kotlinx.android.synthetic.main.activity_chore_list.*
import kotlinx.android.synthetic.main.popup.view.*

class ChoreListActivity : AppCompatActivity() {
    var dbHandler: ChoresDatabaseHandler? = null

    private var adapter: ChoreListAdapter? = null
    private var choreList: ArrayList<ChoreModel>? = null
    private var choreListItems: ArrayList<ChoreModel>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    private var dialogBuilder: AlertDialog.Builder? = null
    private var dialog: AlertDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chore_list)

        dbHandler = ChoresDatabaseHandler(this)

        choreList = ArrayList<ChoreModel>()
        choreListItems = ArrayList()
        layoutManager = LinearLayoutManager(this)
        adapter = ChoreListAdapter(choreListItems!!, this)

        // setup list = recyclerview
        recyclerViewForChores.layoutManager = layoutManager
        recyclerViewForChores.adapter = adapter

        //Load our chores
        choreList = dbHandler!!.readChore()
        choreList!!.reverse()

        for (c in choreList!!.iterator()) {

            val chore = ChoreModel()
            chore.choreName = "Chore: ${c.choreName.toString()}"
            chore.assignBy = "Assigned By: ${c.assignBy.toString()}"
            chore.assignTo = "Assigned to: ${c.assignTo.toString()}"
            chore.id = c.id
            chore.showHumanDate(c.timeAssigned!!)

            choreListItems!!.add(chore)

        }

        adapter!!.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item_chore, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.addChore) {
            createPopUpDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    fun createPopUpDialog() {
        var view = layoutInflater.inflate(R.layout.popup, null)
        var choreName = view.popUpChoreName
        var assignedBy = view.popUpassignByID
        var assignedTo = view.popUpassignToID

        var saveButton = view.popUpsaveChoreBtn

        dialogBuilder = AlertDialog.Builder(this).setView(view)
        dialog = dialogBuilder!!.create()
        dialog?.show()

        saveButton.setOnClickListener {

            var name  = choreName.text.toString().trim()
            var aBy = assignedBy.text.toString().trim()
            var aTo = assignedTo.text.toString().trim()
            if(!TextUtils.isEmpty(name)
                && !TextUtils.isEmpty(aBy)
                && !TextUtils.isEmpty(aTo)) {

                var chore = ChoreModel()

                chore.choreName = name
                chore.assignBy = aBy
                chore.assignTo = aTo
                dbHandler!!.createChore(chore)

                dialog!!.dismiss()

                startActivity(Intent(this, ChoreListActivity::class.java))
                finish()

            } else {

            }
        }
    }
}
