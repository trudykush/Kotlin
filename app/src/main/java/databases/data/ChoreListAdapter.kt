package databases.data

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.kush.learningkotlin.R
import databases.model.ChoreModel
import kotlinx.android.synthetic.main.popup.view.*

class ChoreListAdapter(private val list: ArrayList<ChoreModel>,
                       private val context: Context ) : RecyclerView.Adapter<ChoreListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_rows_chores, parent,false)
        return MyViewHolder(view, context, list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(list[position])
    }


    inner class MyViewHolder(
        itemView: View,
        context: Context,
        list: ArrayList<ChoreModel>
    ): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var mContext = context
        var mList = list

        var choreName = itemView.findViewById(R.id.choreNameInList) as TextView
        var assignedBy = itemView.findViewById(R.id.assignByInList) as TextView
        var assignedDate = itemView.findViewById(R.id.choreDateInList) as TextView
        var assignedTo = itemView.findViewById(R.id.assignToInList) as TextView

        var editButton = itemView.findViewById(R.id.editButton) as Button
        var deleteButton = itemView.findViewById(R.id.deleteButton) as Button

        fun bindView(chore: ChoreModel) {
            choreName.text = chore.choreName
            assignedBy.text = chore.assignBy
            assignedDate.text = chore.showHumanDate(System.currentTimeMillis())
            assignedTo.text = chore.assignTo

            deleteButton.setOnClickListener(this)
            editButton.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            var mPosition: Int = adapterPosition
            var chore = mList[mPosition]

            when(v!!.id) {
                deleteButton.id -> {
                    deleteChore(chore.id!!)
                    mList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                }
                editButton.id -> {
                    editChore(chore)
                }
            }
            }

        fun deleteChore(id: Int) {
            var db: ChoresDatabaseHandler = ChoresDatabaseHandler(context)
            db.deleteChore(id)
        }

        fun editChore(chore: ChoreModel) {

            var dialogBuilder: AlertDialog.Builder?
            var dialog: AlertDialog?
            var dbHandler: ChoresDatabaseHandler = ChoresDatabaseHandler(context)

            var view = LayoutInflater.from(context).inflate(R.layout.popup, null)
            var choreName = view.popUpChoreName
            var assignedBy = view.popUpassignByID
            var assignedTo = view.popUpassignToID

            var saveButton = view.popUpsaveChoreBtn

            dialogBuilder = AlertDialog.Builder(context).setView(view)
            dialog = dialogBuilder!!.create()
            dialog.show()

            saveButton.setOnClickListener {

                var name = choreName.text.toString().trim()
                var aBy = assignedBy.text.toString().trim()
                var aTo = assignedTo.text.toString().trim()
                if (!TextUtils.isEmpty(name)
                    && !TextUtils.isEmpty(aBy)
                    && !TextUtils.isEmpty(aTo)
                ) {
                    chore.choreName = name
                    chore.assignBy = aBy
                    chore.assignTo = aTo

                    dbHandler.updateChore(chore)
                    notifyItemChanged(adapterPosition, chore)
                    dialog.dismiss()

                } else {

                }
            }
        }
    }
}