package io.kiwik.ibkapp.workers

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.work.Worker
import androidx.work.WorkerParameters
import io.kiwik.domain.interactors.SignOutUseCase
import io.kiwik.domain.util.ResponseStatus
import io.kiwik.ibkapp.ui.login.LoginActivity
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class SessionWorker(private val appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams), KoinComponent {

    private val signOutUseCase by inject<SignOutUseCase>()

    override fun doWork(): Result {

        return runBlocking {
            val result = signOutUseCase.execute()
            val intent = Intent(appContext, LoginActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(appContext, 1, intent, PendingIntent.FLAG_IMMUTABLE)
            if (result.responseStatus == ResponseStatus.SUCCESS) {
                pendingIntent.send()
                return@runBlocking Result.success()
            } else {
                return@runBlocking Result.failure()
            }
        }

    }
}
