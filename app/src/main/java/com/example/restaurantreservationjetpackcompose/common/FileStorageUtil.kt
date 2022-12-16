package com.example.restaurantreservationjetpackcompose.common

import android.content.Context
import com.example.restaurantreservationjetpackcompose.RestaurantApp
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

class FileStorageUtil (context: Context) {

    private val appContext = context.applicationContext

    fun <T : Serializable?> saveSerializable(objectToSave: T, fileName: String?) {
        try {
            val fileOutputStream = appContext.openFileOutput(fileName, Context.MODE_PRIVATE)
            val objectOutputStream = ObjectOutputStream(fileOutputStream)
            objectOutputStream.writeObject(objectToSave)
            objectOutputStream.close()
            fileOutputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Serializable?> readSerializable(fileName: String?): T? {
        var objectToReturn: T? = null
        try {
            val fileInputStream = appContext.openFileInput(fileName)
            val objectInputStream = ObjectInputStream(fileInputStream)
            objectToReturn = objectInputStream.readObject() as T
            objectInputStream.close()
            fileInputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return objectToReturn
    }

    /**
     * Removes a specified file.
     *
     * @param filename The name of the file.
     */
    fun removeSerializable(filename: String?) {
        RestaurantApp.instance.deleteFile(filename)
    }
}