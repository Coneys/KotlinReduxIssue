package redux.feature

import redux.RAction

object FeatureSlice {
    data class State(
        val flag: Boolean = false,
    )

    fun reducer(state: State?, action: RAction): State {
        val currentState = state ?: State()
        return when (action) {
            is ChangeFlagOnFeature -> action.updateState(currentState)
            else -> currentState
        }
    }

}
