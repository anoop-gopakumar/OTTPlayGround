package com.example.ottapplication.ui.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

   // var userGuess by mutableStateOf("") set
   var userGuess by mutableStateOf("")
       private set

    // Set of words used in the game
    private var usedWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String

    init {
        resetGame()
    }

    /*
     * Re-initializes the game data to restart the game.
     */
    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    /*
     * Update the user's guess
     */
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    /*
     * Checks if the user's guess is correct.
     * Increases the score accordingly.
     */
    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // User's guess is correct, increase the score
            // and call updateGameState() to prepare the game for next round
            val updatedScore = _uiState.value.score.plus(10)
            updateGameState(updatedScore)
        } else {
            // User's guess is wrong, show an error
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        // Reset user guess
        updateUserGuess("")
    }

    /*
     * Skip to next word
     */
    fun skipWord() {
        updateGameState(_uiState.value.score)
        // Reset user guess
        updateUserGuess("")
    }

    /*
     * Picks a new currentWord and currentScrambledWord and updates UiState according to
     * current game state.
     */
    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == 100){
            //Last round in the game, update isGameOver to true, don't pick a new word
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else{
            // Normal round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun setCurrentWord(word: String){
        currentWord = word
    }

    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random().toString()
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            shuffleCurrentWord(currentWord)
        }
    }
}

val allWords: Set<String> =
    setOf(
        "animal",
        "auto",
        "anecdote",
        "alphabet",
        "all",
        "awesome",
        "arise",
        "balloon",
        "basket",
        "bench",
        "best",
        "birthday",
        "book",
        "briefcase",
        "camera",
        "camping",
        "candle",
        "cat",
        "cauliflower",
        "chat",
        "children",
        "class",
        "classic",
        "classroom",
        "coffee",
        "colorful",
        "cookie",
        "creative",
        "cruise",
        "dance",
        "daytime",
        "dinosaur",
        "doorknob",
        "dine",
        "dream",
        "dusk",
        "eating",
        "elephant",
        "emerald",
        "eerie",
        "electric",
        "finish",
        "flowers",
        "follow",
        "fox",
        "frame",
        "free",
        "frequent",
        "funnel",
        "green",
        "guitar",
        "grocery",
        "glass",
        "great",
        "giggle",
        "haircut",
        "half",
        "homemade",
        "happen",
        "honey",
        "hurry",
        "hundred",
        "ice",
        "igloo",
        "invest",
        "invite",
        "icon",
        "introduce",
        "joke",
        "jovial",
        "journal",
        "jump",
        "join",
        "kangaroo",
        "keyboard",
        "kitchen",
        "koala",
        "kind",
        "kaleidoscope",
        "landscape",
        "late",
        "laugh",
        "learning",
        "lemon",
        "letter",
        "lily",
        "magazine",
        "marine",
        "marshmallow",
        "maze",
        "meditate",
        "melody",
        "minute",
        "monument",
        "moon",
        "motorcycle",
        "mountain",
        "music",
        "north",
        "nose",
        "night",
        "name",
        "never",
        "negotiate",
        "number",
        "opposite",
        "octopus",
        "oak",
        "order",
        "open",
        "polar",
        "pack",
        "painting",
        "person",
        "picnic",
        "pillow",
        "pizza",
        "podcast",
        "presentation",
        "puppy",
        "puzzle",
        "recipe",
        "release",
        "restaurant",
        "revolve",
        "rewind",
        "room",
        "run",
        "secret",
        "seed",
        "ship",
        "shirt",
        "should",
        "small",
        "spaceship",
        "stargazing",
        "skill",
        "street",
        "style",
        "sunrise",
        "taxi",
        "tidy",
        "timer",
        "together",
        "tooth",
        "tourist",
        "travel",
        "truck",
        "under",
        "useful",
        "unicorn",
        "unique",
        "uplift",
        "uniform",
        "vase",
        "violin",
        "visitor",
        "vision",
        "volume",
        "view",
        "walrus",
        "wander",
        "world",
        "winter",
        "well",
        "whirlwind",
        "x-ray",
        "xylophone",
        "yoga",
        "yogurt",
        "yoyo",
        "you",
        "year",
        "yummy",
        "zebra",
        "zigzag",
        "zoology",
        "zone",
        "zeal"
    )