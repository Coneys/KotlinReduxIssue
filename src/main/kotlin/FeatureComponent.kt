import react.ComponentClass
import react.FC
import react.Props
import react.dom.html.ReactHTML.button
import react.redux.rConnect
import redux.RAction
import redux.WrapperAction
import redux.feature.ChangeFlagOnFeature
import redux.root.RootState
import redux.utils.renderOn


external interface FeatureStateProps : Props {
    var flagState: Boolean
}

external interface FeatureDispatchProps : Props {
    var changeFlag: () -> Unit
}

external interface FeatureProps : Props, FeatureStateProps, FeatureDispatchProps

private val featureComponent = FC<FeatureProps> { props ->

    button {
        onClick = {
            props.changeFlag()
        }
        +"Test button ${props.flagState}"
    }

}

val Feature: ComponentClass<Props> =
    rConnect<RootState, RAction, WrapperAction, Props, FeatureStateProps, FeatureDispatchProps, FeatureProps>(
        { state, _ ->
            console.log(state) // prints correct object on IR
            console.log(state.featureState) // undefined on IR
            flagState = state.featureState.flag // undefined on IR
        },
        { dispatch, _ ->
            changeFlag = { dispatch(ChangeFlagOnFeature()) }
        }
    ).renderOn(featureComponent)
