package com.lnsantos.arcore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()
        setupBottomSheet()

    }

    private fun setupRecycler(){


        recycler_models_3d.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ModelAdapter(ModelMock().getModels()){

            }
        }

    }

    private fun setupBottomSheet() {

        val configPeekHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50f, resources.displayMetrics)
        val configCallback = object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                bottomSheet.bringToFront()
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        }

        BottomSheetBehavior.from(options_bottom_sheet).apply {
            peekHeight = configPeekHeight.toInt()
            addBottomSheetCallback(configCallback)
        }

    }

}