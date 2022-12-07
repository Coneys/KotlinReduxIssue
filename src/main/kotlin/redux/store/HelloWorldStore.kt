package redux.store

import redux.feature.FeatureSlice
import redux.root.RootState

object HelloWorldStore : ReduxStore<RootState>() {

    override fun combinedReducers() = combineReducers(
        mapOf(
            RootState::featureState to FeatureSlice::reducer,
        )
    )

    override fun defaultState(): RootState {
        return RootState()
    }


}
