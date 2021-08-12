package com.clearscore.donutview.utilities

import android.content.Context
import java.io.*

class StorageManager {

    fun saveObjectByKey(context: Context, obj: Object, key: String) {
        try {
            val fos: FileOutputStream = context.openFileOutput(key, Context.MODE_PRIVATE)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(obj)
            oos.close()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getObjectByKey(context: Context, key: String?): Object? {
        try {
            val fis: FileInputStream = context.openFileInput(key)
            val ois = ObjectInputStream(fis)
            return ois.readObject() as Object
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return null
    }

}