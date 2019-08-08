package datanapps.retrofitkotlin.view.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar

import datanapps.retrofitkotlin.R
import datanapps.retrofitkotlin.services.adapters.ProductRecyclerViewAdapter
import datanapps.retrofitkotlin.services.network.Endpoints
import datanapps.retrofitkotlin.services.users.model.Product
import datanapps.retrofitkotlin.services.users.model.ProductsList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {




            val adapter = ProductRecyclerViewAdapter { product ->
                val bundle = Bundle()
                bundle.putString(getString(R.string.EMP_length), product.length)
                bundle.putString(getString(R.string.EMP_ID), product.id)
                bundle.putString(getString(R.string.EMP_height), product.height)
                bundle.putString(getString(R.string.EMP_width), product.width)
                bundle.putString(getString(R.string.EMP_image), product.profileImage)

                findNavController().navigate(R.id.action_blankFragment_to_endFragment, bundle)

            }

        recyclerView.apply {
            this.adapter = adapter

            context?.let{
                this.layoutManager = LinearLayoutManager(it)
            }
        }

//        displayTestData(adapter)
//
        fetchDataFromServer(adapter)


        }

    private fun fetchDataFromServer(adapter: ProductRecyclerViewAdapter) {

        val apiCalls = RetroFitInstance.retrofit

        val request = apiCalls.create(Endpoints::class.java).getProductList()


        request.enqueue(object : Callback<ProductsList> {

            override fun onFailure(call: Call<ProductsList>, t: Throwable) {

                Log.w(javaClass.name, "getProductList() failed. Error: ${t.message}")

                constraintLayout?.let {
                    Snackbar.make(it, "Network request failed", Snackbar.LENGTH_LONG).show()
                }
            }

            override fun onResponse(call: Call<ProductsList>, response: Response<ProductsList>) {

                when (response.code()) {
                    200 -> {
                        response.body()?.let {

                            adapter.submitList(it.data)
                        }
                    }

                    else -> {
                        constraintLayout?.let {
                            Snackbar.make(it, "Something went wrong. CODE: ${response.code()}", Snackbar.LENGTH_LONG).show()
                        }
                    }
                }

            }


        })

    }
    private fun displayTestData(adapter: ProductRecyclerViewAdapter) {
        val testData = listOf(
                Product("1", "1", "1", "1", ""),
                Product("2", "2", "2", "2",""),
                Product("3", "3", "3", "3", ""))
        adapter.submitList(testData)
    }
}

