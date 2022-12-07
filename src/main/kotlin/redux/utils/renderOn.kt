package redux.utils

import react.*

fun <P : Props, R : Props> HOC<P, R>.renderOn(component: FC<P>): ComponentClass<R> {
    return invoke {
        child(component, it)
    }
}