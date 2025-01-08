//Fetch Data from FireBase
package com.example.trendvault.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.trendvault.Model.CategoryModel
import com.example.trendvault.Model.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Locale.Category

class MainRepository {
    // Repository uses Firebase Realtime Database as the backend
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    // LiveData to observe and provide updates to the UI components when data changes in the database
    fun loadBanner(): LiveData<MutableList<SliderModel>> {
        val listData = MutableLiveData<MutableList<SliderModel>>()
        val ref = firebaseDatabase.getReference("Banner")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<SliderModel>()
                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(SliderModel::class.java)
                    item?.let { lists.add(it) }
                }
                listData.value = lists

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
        return listData

    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        val listData = MutableLiveData<MutableList<CategoryModel>>()
        val ref = firebaseDatabase.getReference("Category")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<CategoryModel>()
                for (childSnapshot in snapshot.children) {
                    val item = childSnapshot.getValue(CategoryModel::class.java)
                    item?.let { lists.add(it) }
                }
                listData.value = lists

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
        return listData

    }

}
