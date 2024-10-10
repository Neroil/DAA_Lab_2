package ch.heigvd.iict.daa.template

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class PickNameContract : ActivityResultContract<String?, String?>() {
    override fun createIntent(context: Context, input: String?): Intent =
        Intent(context, UsernameInputActivity::class.java).apply {
            putExtra("existingName", input)
        }


    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if(resultCode != Activity.RESULT_OK) {
            return null
        }

        return intent?.getStringExtra(UsernameInputActivity.USERNAME_KEY)
    }
}