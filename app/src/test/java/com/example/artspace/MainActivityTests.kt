package com.example.artspace

import org.junit.Test
import org.junit.Assert.assertEquals

class MainActivityTests {

    @Test
    fun previousArtwork_from3to2() {
        val current = 3
        assertEquals(2, previousArtwork(current))
    }

    @Test
    fun previousArtwork_from1to5() {
        val current = 1
        assertEquals(5, previousArtwork(current))
    }

    @Test
    fun nextArtwork_from3to4() {
        val current = 3
        assertEquals(4, nextArtwork(current))
    }

    @Test
    fun nextArtwork_from5to1() {
        val current = 5
        assertEquals(1, nextArtwork(current))
    }
}