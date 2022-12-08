package redux.store

import kotlinx.js.jso
import redux.feature.FeatureSlice
import redux.root.RootState

object HelloWorldStore : ReduxStore<RootState>() {

    override fun combinedReducers() = combineReducers(
        mapOf(
            RootState::featureState to FeatureSlice::reducer,
        )
    )

    override fun defaultState(): RootState {
        return jso<RootState>{
            featureState = FeatureSlice.State()
        }
    }


}
