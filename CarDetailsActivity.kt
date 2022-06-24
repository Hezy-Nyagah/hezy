package com.project.hezy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_car_details.*

class CarDetailsActivity : AppCompatActivity() {

    private var orderNumber: Int=0
    private var totalOrderAmount:Int= 0


    private lateinit var photoRecyclerView:RecyclerView
    private lateinit var photoRecommendedItem: ArrayList<RecommendedItem>
    lateinit var recommendedItemimage:Array<Int>
    lateinit var recommendedItemName:Array<String>
    lateinit var recommendedItemDesc:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        supportActionBar?.title= "WELCOME   HOME  BEST  SAND ALWAYS"


        val name=intent.getStringExtra("carName")
        carName.text=name
        val image = intent.getIntExtra("carImage",0)
        ivcar_item.setImageResource(image)
        val amount = intent.getStringExtra("carAmount")
        tvamount.text=amount
        val seller = intent.getStringExtra("seller")
        tvseller.text=seller

        btnIncrement.setOnClickListener {
            orderNumber++
            tvTotalOrder.text= orderNumber.toString()
            totalOrderAmount= ((tvamount.text as String).toInt() * (tvTotalOrder.text as String).toInt())
            tvTotalAmount.text=totalOrderAmount.toString()
//
        }
        btnDecrement.setOnClickListener {
            orderNumber--
            if (orderNumber<0){
                orderNumber=0
            }
            tvTotalOrder.text=orderNumber.toString()
            totalOrderAmount= ((tvamount.text as String).toInt() * (tvTotalOrder.text as String).toInt())
            tvTotalAmount.text=totalOrderAmount.toString()
        }

        recommendedItemimage= arrayOf(
            R.drawable.brown,
            R.drawable.brownsand,
            R.drawable.construction_river_sand,
            R.drawable.desert_sand,
            R.drawable.darkbbrown,
            R.drawable.yellow_sand,
        )

        recommendedItemName= arrayOf(
            "Brown Sand",
            "Desert Sand",
            "White Sand",
            "Yellow Sand",
            "Msand",
            "Construction Sand",
        )
        recommendedItemDesc= arrayOf(
            "Best Sand in town",
            "Buy from us",
            "I bought it",
            "Yellow Sand",
            "Klamamu ndefu",
            "Construction Sand",
        )

        photoRecyclerView= findViewById(R.id.recommendedRv)
        photoRecyclerView.layoutManager=
            GridLayoutManager(this, 2)
        photoRecyclerView.setHasFixedSize(true)

        photoRecommendedItem= arrayListOf<RecommendedItem>()
        getRecommendedData()
    }
    private fun getRecommendedData() {
        for (i in photoRecommendedItem.indices){
            val recommendedCar= RecommendedItem(recommendedItemimage[i],recommendedItemName[i],recommendedItemDesc[i],
                )
            photoRecommendedItem.add(recommendedCar)
        }
        photoRecyclerView.adapter= RecommendedAdapter(photoRecommendedItem)
    }
}