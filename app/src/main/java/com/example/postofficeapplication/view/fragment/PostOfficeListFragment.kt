package com.example.postofficeapplication.view.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.postofficeapplication.R
import com.example.postofficeapplication.helper.gone
import com.example.postofficeapplication.model.pojo.PostOfficeX
import com.example.postofficeapplication.model.repo.Outcome
import com.example.postofficeapplication.view.adapter.PostOfficeListAdapter
import com.example.postofficeapplication.viewModel.PostOfficeViewModel
import kotlinx.android.synthetic.main.fragment_post_office_list.*
import kotlinx.android.synthetic.main.post_details_dialoge_lay.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostOfficeListFragment : Fragment() {

    private lateinit var postcode:String
    private val postOfficeViewModel: PostOfficeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            postcode = it.getString("postcode").toString()
        }

        Log.i("postcode",postcode)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_office_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getPostOffice(postcode)
    }


    private fun getPostOffice(postcode: String){
        postOfficeViewModel.getPostOffice(postcode).observe(viewLifecycleOwner, { outcome ->
            progress_bar.gone()
            when(outcome){
                is Outcome.Success ->{
                    if (outcome.data.first().status == "Success"){
                        postoffice_recycler.adapter = PostOfficeListAdapter(outcome.data[0].postOffice,requireActivity())

                    }else{
                        Toast.makeText(activity,"error !!!", Toast.LENGTH_SHORT).show()
                    }
                }
                is Outcome.Failure<*> ->{
                    Toast.makeText(activity,outcome.e.message, Toast.LENGTH_SHORT).show()
                    outcome.e.printStackTrace()
                    Log.i("status",outcome.e.cause.toString())
                }
            }
        })
    }

}