package com.happiestminds.animalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A fragment representing a list of Items.
 */
class AnimalFragment : Fragment() {

    private var columnCount = 1
    private var animaltype= 1//1-domestic,2-wild
    val wildAnimalList = mutableListOf<Animal>()
    val domesticAnimalList= mutableListOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
            animaltype = it.getInt(ARG_ANIMAL_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        populateData()

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                when(animaltype){
                  1->  adapter = AnimalAdapter(domesticAnimalList)
                    2-> adapter = AnimalAdapter(wildAnimalList)

                }

            }
        }
        return view
    }

    private fun populateData() {
        domesticAnimalList.add(Animal("Cat"))
        domesticAnimalList.add(Animal("Dog"))
        domesticAnimalList.add(Animal("parrot"))
        domesticAnimalList.add(Animal("cow"))
        domesticAnimalList.add(Animal("rabbit"))

        wildAnimalList.add(Animal("bear"))
        wildAnimalList.add(Animal("fox"))
        wildAnimalList.add(Animal("giraffe"))
        wildAnimalList.add(Animal("lion"))
        wildAnimalList.add(Animal("tiger"))
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"
        const val ARG_ANIMAL_TYPE="animal_type"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int,animalType:Int) =
            AnimalFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                    putInt(ARG_ANIMAL_TYPE,animalType)
                }
            }
    }
}