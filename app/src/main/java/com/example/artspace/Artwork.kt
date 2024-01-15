package com.example.artspace

import androidx.compose.ui.graphics.painter.Painter

data class Artwork(
    val id: Int,
    val image: Painter,
    val contentDescription: String,
    val title: String,
    val artist: String,
    val year: String
)