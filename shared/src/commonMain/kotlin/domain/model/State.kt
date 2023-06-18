package domain.model

enum class State {
    LOADING,
    CONTENT,
    ERROR,
    EMPTY
}

// sealed class State {
//     object LOADING : State()
//     data class CONTENT(val data: Any?) : State()
//     object ERROR : State()
//     object EMPTY : State()
// }
