package com.lnsantos.arcore

class ModelMock {

    private val models : ArrayList<Model> = arrayListOf()

    init {
        models.addAll(arrayListOf(
            Model("Raposa 1", R.raw.raposa, R.drawable.raposa,false),
            Model("Raposa 2", R.raw.raposa, R.drawable.raposa,false ),
            Model("Raposa 3", R.raw.raposa, R.drawable.raposa,false),
            Model("Raposa 4", R.raw.raposa, R.drawable.raposa,false),
            Model("Raposa 5", R.raw.raposa, R.drawable.raposa,false)
        ))
    }

    fun getModels() : List<Model> = models
}