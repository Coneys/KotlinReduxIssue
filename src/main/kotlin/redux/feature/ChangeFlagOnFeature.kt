package redux.feature

import redux.RAction

class ChangeFlagOnFeature : RAction {
    fun updateState(state: FeatureSlice.State): FeatureSlice.State {
        return state.copy(flag = state.flag.not())
    }
}