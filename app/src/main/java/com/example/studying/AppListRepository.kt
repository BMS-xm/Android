package com.example.studying

class AppListRepository{
    fun get(): List<App> = listOf(
        App(R.drawable.ic_launcher_foreground, "Calc", "Smart calculator", "Tools"),
        App(R.drawable.ic_launcher_foreground, "Note", "Smart notepad", "Business"),
        App(R.drawable.ic_launcher_foreground, "Cam", "Smart camera", "Multimedia"),
        App(R.drawable.ic_launcher_foreground, "Dict", "Smart dictophone", "Multimedia")
    )
}