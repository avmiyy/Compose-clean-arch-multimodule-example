package ru.vafeen.data.local_database

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.vafeen.data.local_database.entity.TestEntity
import ru.vafeen.domain.local_database.TestLocalRepository
import javax.inject.Inject

internal class RoomTestLocalRepository @Inject constructor(
    private val db: AppDatabase
) : TestLocalRepository {
    init {
        Log.d("init", "init")
        GlobalScope.launch(Dispatchers.IO) {
            db.testDao().insert(
                listOf(
                    TestEntity(data = "data1"),
                    TestEntity(data = "data2")
                )
            )
        }
    }
}