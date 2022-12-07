package redux.root

import redux.feature.FeatureSlice


data class RootState(val featureState: FeatureSlice.State = FeatureSlice.State(false))