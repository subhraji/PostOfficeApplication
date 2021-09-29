package com.example.postofficeapplication.view.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.postofficeapplication.R
import com.example.postofficeapplication.helper.inflate
import com.example.postofficeapplication.model.pojo.PostOfficeX
import kotlinx.android.synthetic.main.post_details_dialoge_lay.view.*
import kotlinx.android.synthetic.main.post_office_list_item.view.*

class PostOfficeListAdapter(private val postList: List<PostOfficeX>, private val context: Context): RecyclerView.Adapter<PostOfficeListAdapter.PostOfficeListViewHolder>() {

    inner class PostOfficeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostOfficeListViewHolder {
        return PostOfficeListViewHolder(parent.inflate(R.layout.post_office_list_item))
    }
    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostOfficeListAdapter.PostOfficeListViewHolder, position: Int) {

        val data = postList[position]
        holder.itemView.apply {
            post_office_name_txt.text = data.name


            post_list_item_root_view.setOnClickListener {
                showDialog(
                    data.name,
                    data.branchType,
                    data.deliveryStatus,
                    data.circle,
                    data.district,
                    data.division,
                    data.region,
                    data.block,
                    data.state,
                    data.country,
                    data.pincode
                )
            }

        }
    }

    private fun showDialog(
        postName:String,
        branchType:String,
        deliveryStatus:String,
        circle:String,
        district:String,
        division:String,
        region:String,
        block:String,
        state:String,
        country:String,
        pincode:String
    ) {
        val dialogBox = LayoutInflater.from(context).inflate(R.layout.post_details_dialoge_lay, null)
        val dialogBoxBuilder = AlertDialog.Builder(context).setView(dialogBox)
        dialogBox.post_name.text = "Name: "+postName
        dialogBox.post_branch_type.text = "BranchType: "+branchType
        dialogBox.post_delevery_status.text = "DeliveryStatus: "+deliveryStatus
        dialogBox.post_circle.text = "Circle: "+circle
        dialogBox.post_district.text = "District: "+district
        dialogBox.post_division.text = "Division: "+division
        dialogBox.post_region.text = "Region: "+region
        dialogBox.post_block.text = "Block: "+block
        dialogBox.post_state.text = "State: "+state
        dialogBox.post_country.text = "Country: "+country
        dialogBox.post_code.text = "Pincode: "+pincode
        val  dialogBoxInstance = dialogBoxBuilder.show()

        dialogBox.dialog_cancel_btn.setOnClickListener(){
            dialogBoxInstance.dismiss()
        }
    }


}