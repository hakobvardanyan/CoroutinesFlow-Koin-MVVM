package com.example.coroutinesflow_koin_mvvm.extension

import android.view.View
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate

@ExperimentalCoroutinesApi
fun <E> SendChannel<E>.safeOffer(value: E) = !isClosedForSend && try {
    offer(value)
} catch (e: CancellationException) {
    false
}

@ExperimentalCoroutinesApi
fun View.clicks(): Flow<Unit> = callbackFlow<Unit> {
    val listener = View.OnClickListener { safeOffer(Unit) }
    setOnClickListener(listener)
    awaitClose { setOnClickListener(null) }
}.conflate()