package io.kiwik.ibkapp.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent

class SharedTextUtil {
    companion object {

        fun getSharedText(
            accountNumber: String
        ): String {
            return "Mi numero de cuenta: \n $accountNumber"
        }

        fun shareContent(context: Context, content: String) {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, content)
                type = "text/plain"
            }
            try {
                val shareIntent = Intent.createChooser(sendIntent, null)
                context.startActivity(shareIntent)
            } catch (ex: ActivityNotFoundException) {
                context.showToast("No tiene ningun app para poder compartir.")
            }
        }

    }

}