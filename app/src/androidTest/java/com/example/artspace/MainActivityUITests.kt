package com.example.artspace

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.junit.Rule
import org.junit.Test

class MainActivityUITests {

    // The rule is used to start the UI with a certain content
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun previousArtwork_from1to5_checkArtwork() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ComposeMainActivity()
            }
        }

        composeTestRule.onNodeWithText("Previous").performClick()

        composeTestRule.onNodeWithContentDescription("Image of the painting: De Sterrennacht")
            .assertExists("NOT FOUND")
        composeTestRule.onNodeWithText("De Sterrennacht").assertExists("NOT FOUND")
        composeTestRule.onNodeWithText("Vincent Van Gogh, 1889").assertExists("NOT FOUND")
    }

    @Test
    fun nextArtwork_from1to2_checkArtwork() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ComposeMainActivity()
            }
        }

        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithContentDescription("Image of the painting: Ultima Cena")
            .assertExists("NOT FOUND")
        composeTestRule.onNodeWithText("Ultima Cena").assertExists("NOT FOUND")
        composeTestRule.onNodeWithText("Leonardo da Vinci, 1498").assertExists("NOT FOUND")
    }


    @Test
    fun nextArtwork_from1to5to1_checkTitle() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ComposeMainActivity()
            }
        }

        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithContentDescription("Image of the painting: Monna Lisa")
            .assertExists("NOT FOUND")
        composeTestRule.onNodeWithText("Monna Lisa").assertExists("NOT FOUND")
        composeTestRule.onNodeWithText("Leonardo da Vinci, 1503").assertExists("NOT FOUND")
    }

}