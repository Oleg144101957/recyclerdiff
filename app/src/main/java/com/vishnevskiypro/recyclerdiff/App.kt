package com.vishnevskiypro.recyclerdiff

import android.app.Application
import com.vishnevskiypro.recyclerdiff.model.UserService

class App : Application() {

    val usersService = UserService()
}