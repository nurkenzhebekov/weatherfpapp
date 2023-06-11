package com.example.weather

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText

object DialogManager {
    fun locationSettingDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Enable location?")
        dialog.setMessage("Location disabled, do you want enable location?")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { _,_ ->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    fun searchCityDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val edtName = EditText(context)
        builder.setView(edtName)
        val dialog = builder.create()
        dialog.setTitle("City name:")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { _,_ ->
            listener.onClick(edtName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    interface Listener {
        fun onClick(name: String?)
    }
}