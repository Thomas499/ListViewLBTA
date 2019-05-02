package letsbuildthatapp.com.listviewlbta

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.row_main.*
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.main_listview)
        val temppausebutton = findViewById<Button>(R.id.temp_pause_button)

//        val redColor = Color.parseColor("#FF0000")
//        listView.setBackgroundColor(redColor)

        listView.adapter = MyCustomAdapter() // this needs to be my custom adapter telling my list what to render
//        //No idea why below crashes app
          temppausebutton.setOnClickListener {
            //temp_pause_button.visibility=View.GONE
            //temp_resume_button.visibility=View.VISIBLE
        }
          //temp_resume_button.setOnClickListener {
          //  temp_pause_button.visibility=View.VISIBLE
          //  temp_resume_button.visibility=View.GONE
            //temp_pause_button.text="9"
        //}
//
    }

    private class MyCustomAdapter: BaseAdapter() {

//        private val mContext: Context

        private val names = arrayListOf<String>(
                "www.youtube.com" , "www.google.com" , "pagead2.googlesyndication.com" , "nrdp512appboot.netflix.com"
        )
        private val status = arrayListOf<String>(
                "ok" , "blocked" , "ok" , "blocked"
        )
        private val timestamp = arrayListOf<String>(
                "10:31:04" , "10:31:10" , "10:31:14" , "10:31:16"
        )
//        init {
//            mContext = context
//        }
        // responsible for how many rows in my list
        override fun getCount(): Int {
            return names.size
        }

        // you can also ignore this
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // you can ignore this for now
        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        // responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val rowMain: View

            // checking if convertView is null, meaning we have to inflate a new row
            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

//                Log.v("getView", "calling findViewById which is expensive")
//                val nTextView = rowMain.name_textView
//                val pTextView = rowMain.position_textview
//                val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
//                val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
                //val viewHolder2 = rowMain.tag as ViewHolder
                //viewHolder2.nameTextView.text = names.get(position)

                val viewHolder = ViewHolder(rowMain.name_textView, rowMain.blockstatus_textview, rowMain.timestamp_textView)
                //if (viewHolder2.nameTextView.text == "ok")
                //{
                //}
                rowMain.tag = viewHolder
                //if (rowMain.position_textview== "ok")


            } else {
                // well, we have our row as convertView, so just set rowMain as that view
                rowMain = convertView
            }


            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = names.get(position)
            viewHolder.positionTextView.text = status.get(position)//"Row number: $position"
            viewHolder.timestampTextView.text = timestamp.get(position)
            //viewHolder.temp_pause_button.text = "resume"
            //val temp_resume_button = findViewById<Button>(R.id.temp_resume_button)
            return rowMain
        }
        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView, val timestampTextView: TextView)

    }


}
