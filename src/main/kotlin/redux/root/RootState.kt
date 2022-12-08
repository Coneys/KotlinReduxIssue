package redux.root

import redux.feature.FeatureSlice


external interface RootState {
    var featureState: FeatureSlice.State
}