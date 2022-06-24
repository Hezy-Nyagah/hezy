package com.project.hezy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnCarClickListener {
    private lateinit var carRecyclerView: RecyclerView
    private lateinit var carItem: ArrayList<CarItems>
    lateinit var ivcar_item: Array<Int>
    lateinit var carName: Array<String>
    lateinit var amount: Array<String>
    lateinit var seller: Array<String>
    lateinit var currency:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title="BEST SAND CHEAP PRICE"

        ivcar_item = arrayOf(
            R.drawable.yellow_sand,
            R.drawable.darkbbrown,
            R.drawable.desert_sand,
            R.drawable.construction_sand,
            R.drawable.construction_river_sand,
            R.drawable.plastering_river_sand,
            R.drawable.white,
            R.drawable.brown,
            R.drawable.mineral_sand,
            R.drawable.foundation_sand,
            R.drawable.plaster_sand,
            R.drawable.which_sand,
        )
      carName = arrayOf(
            "Yellow Sand",
            "Darkbrown Sand",
            "Desert Sand",
            "Smooth Sand",
            "River Sand",
            "White Sand",
            "Brown construction Sand",
            "Plastering Sand",
             "Mineral Sand",
             "Foundation Sand",
             "Plaster Sand",
              "Which Sand",
        )
        amount = arrayOf(
            "23000",
            "20000",
            "20000",
            "32500",
            "30000",
            "25500",
            "35000",
            "25000",
            "35000",
            "30000",
            "26500",
            "40000",

        )
        currency = arrayOf(
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
            "Ksh",
        )
        seller = arrayOf(
            "Timboni Sands Co Ltd",
            "Mnarani Sands Co",
            "Jaribuni Construction",
            "Baraka Sands",
            "Pumwani Sales Ltd",
            "Makuti Villa Sands ",
            "Majaoni sales",
            "Vipingo Sands",
            "Tezo Sand Co Ltd",
            "Makutano Sands Co",
            "Kiwapa Sales Co",
            "Makao Sands Ltd"
        )

        carRecyclerView = findViewById(R.id.rvHorizontal)
        carRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        carRecyclerView.setHasFixedSize(true)

        carItem = arrayListOf<CarItems>()
        getCarData()

    }
    private fun getCarData() {
        for (i in ivcar_item.indices) {
            val food = CarItems(carName[i], amount[i]
                ,currency[i], seller[i] , ivcar_item[i],)
            carItem.add(food)
        }

        carRecyclerView.adapter = CarAdapter(carItem,this)

    }

    override fun onCarClicked(position: Int) {
        val intent= Intent(this, CarDetailsActivity::class.java)
        intent.putExtra("carImage", carItem[position].image)
        intent.putExtra("carName",carItem[position].name)
        intent.putExtra("carAmount",carItem[position].amount)
        intent.putExtra("currency",carItem[position].currency)
        intent.putExtra("seller",carItem[position].seller)
        startActivity(intent)
    }
}