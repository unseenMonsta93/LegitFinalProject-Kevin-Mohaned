package datanapps.retrofitkotlin.view

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import datanapps.retrofitkotlin.services.network.RetrofitEventListener
//import datanapps.retrofitkotlin.services.network.ApiUserRestClient
import datanapps.retrofitkotlin.services.users.model.ProductsList
import retrofit2.Call
//import android.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(datanapps.retrofitkotlin.R.layout.activity_host)
        getUserListData();
    }

    internal fun getUserListData() {

       // ApiUserRestClient.instance.getUserList( object : RetrofitEventListener {
           // override  fun onSuccess(call: Call<*>, response: Any) {
             //   if (response is ProductsList) {
             //       Log.d("NETWORK", "Request is made, response count: ${response.data!!.size}")
                }
            }

          //  override fun onError(call: Call<*>, t: Throwable) {
         //       Log.e("NETWORK", "Unable to Connec to ${t.message}")
       //     }
     //   })
  //  }

    private fun setRecycleViewList(userList: List<ProductsList>) {
        //val recyclerView = findViewById<RecyclerView>(datanapps.retrofitkotlin.R.id.notification_main_column)
       // val mLayoutManager = LinearLayoutManager(applicationContext)
       // recyclerView.layoutManager = mLayoutManager
      //  recyclerView.itemAnimator = DefaultItemAnimator()
    }
//}
