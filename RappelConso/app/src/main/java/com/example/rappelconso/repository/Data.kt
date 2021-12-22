package com.example.rappelconso.repository

data class Data<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T, message: String): Data<T> = Data(status = Status.SUCCESS, data = data, message = message)

        fun <T> error(data: T?, message: String):Data<T> =
            Data(status = Status.ERROR, data = data, message = message)
    }
}