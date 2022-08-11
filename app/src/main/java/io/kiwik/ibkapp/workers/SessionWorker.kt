package io.kiwik.ibkapp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import io.kiwik.domain.repository.auth.AuthRepository
import io.kiwik.domain.util.ResponseStatus
import kotlinx.coroutines.runBlocking

class SessionWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {

        return runBlocking {
            val authRepository = AuthRepository()
            val result = authRepository.signOut()
            if (result.responseStatus == ResponseStatus.SUCCESS) {
                return@runBlocking Result.success()
            } else {
                return@runBlocking Result.failure()
            }
        }

    }
}
