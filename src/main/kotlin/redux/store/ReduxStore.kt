
package redux.store

import redux.*
import kotlin.reflect.KProperty1


abstract class ReduxStore<ApplicationStateType> {

    abstract fun combinedReducers(): Reducer<ApplicationStateType, RAction>
    abstract fun defaultState(): ApplicationStateType

    operator fun invoke(): Store<ApplicationStateType, RAction, dynamic> {
        return createStore(
            combinedReducers(),
            defaultState(),
            rEnhancer(),
        )
    }

    protected fun <ApplicationStateType, A, R> combineReducers(reducers: Map<KProperty1<ApplicationStateType, R>, Reducer<*, A>>): Reducer<ApplicationStateType, A> {
        return redux.combineReducers(reducers.mapKeys { it.key.name })
    }
}
