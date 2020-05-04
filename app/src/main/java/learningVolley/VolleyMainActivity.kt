package learningVolley

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.kush.learningkotlin.R
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class VolleyMainActivity : AppCompatActivity() {

    var volleyRequest: RequestQueue? = null
    val stringLink = "http://magadistudio.com/complete-android-developer-course-source-files/string.html"
    var earthLinks = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley_main_acrtivity)

        volleyRequest = Volley.newRequestQueue(this)

        getString(stringLink)
        //getJSONArray(stringLink)
        getJSONObject(earthLinks)
    }

    private fun getJSONObject(earthLinks: String) {

        val jsonObject = JsonObjectRequest(Request.Method.GET, earthLinks,
            Response.Listener {
                    response: JSONObject ->
                var type = response.getString("type")
                Log.d("Type is: ", type)

                var metaData = response.getJSONObject("metadata")
                var metaDataTitle = metaData.getString("title")

                var featuresArray = response.getJSONArray("features")

                for (i in 0 until featuresArray.length() - 1) {
                    var propertiesInFeatures = featuresArray.getJSONObject(i).getJSONObject("properties")
                    var propertiesTitle = propertiesInFeatures.getString("title")

                    Log.d("propertiesTitle", propertiesTitle.toString())

                    var geometryArray = featuresArray.getJSONObject(i).getJSONObject("geometry")
                    var coordinateGeometry = geometryArray.getJSONArray("coordinates")

                    Log.d("coordinateGeometry", coordinateGeometry.toString())

                    for (c in 0 until coordinateGeometry.length() - 1) {
                        var firstCoordinate = coordinateGeometry.get(c)

                        Log.d("First Co-ordinate", firstCoordinate.toString())
                    }
                }
            },
            Response.ErrorListener {
                    error: VolleyError? ->
                try {
                    Log.d("Error is: ", error.toString())
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            })

        volleyRequest!!.add(jsonObject)
    }

    private fun getJSONArray(stringLink: String) {

        val jsonArray = JsonArrayRequest(Request.Method.GET, stringLink,
                    Response.Listener {
                        response: JSONArray ->
                            try {
                                Log.d("Response is: ==> ", response.toString())

                                for (i in 0 until response.length()) {
                                    var jsonObject = response.getJSONObject(i)
                                    var showTitle = jsonObject.getString("show_title")
                                    Log.d("Show Title is: ", showTitle)
                                }

                            } catch (e: java.lang.Exception) {
                                Log.d("Exception is: ", e.toString())
                            }
                    },
                    Response.ErrorListener {
                        error: VolleyError? ->
                        try {
                            Log.d("Error is: ", error.toString())
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    })
        volleyRequest!!.add(jsonArray)
    }

    private fun getString(Url: String) {

        val stringReq = StringRequest(Request.Method.GET, Url,
            Response.Listener {
                response: String? ->
                    try {
                        Log.d("Response: ", response)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

            }, Response.ErrorListener {
                error: VolleyError? ->
                try {
                    Log.d("Error is: " , error.toString())
                } catch (e: Exception) {
                }
            })

        volleyRequest!!.add(stringReq)

    }
}
