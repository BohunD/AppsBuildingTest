package com.bohunapps.appsbuildingtest.util

import com.bohunapps.appsbuildingtest.util.Constants.ENTER_AGE_SCREEN
import com.bohunapps.appsbuildingtest.util.Constants.ENTER_NAME_SCREEN
import com.bohunapps.appsbuildingtest.util.Constants.SHOW_INFO_SCREEN

sealed class Destination(val route: String){
    object EnterAge: Destination(ENTER_NAME_SCREEN)
    object EnterName: Destination(ENTER_AGE_SCREEN)
    object ShowInfo: Destination(SHOW_INFO_SCREEN)
}
