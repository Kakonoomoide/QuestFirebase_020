package com.example.pam_pert11.ui.navigation

interface DestinasiNavigasi {
    val route: String
    val titleRes: String
}

// home page
object DestinasiHome : DestinasiNavigasi{
    override val route: String = "home"
    override val titleRes: String = "Home"
}

// Insert page
object DestinasiInsert : DestinasiNavigasi{
    override val route: String = "insert"
    override val titleRes: String = "Insert"
}